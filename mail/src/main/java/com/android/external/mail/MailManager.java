package com.android.external.mail;

import android.os.AsyncTask;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
/**
 * 邮件管理类
 * Created by DevWiki on 2016/8/21.
 */
public class MailManager {

//    private static final String SENDER_NAME = "258474063@qq.com";
//    private static final String SENDER_PASS = "nbbugagbxrbfcbbe";
//    private static final String VALUE_MAIL_HOST = "smtp.qq.com";
//    private static final String KEY_MAIL_HOST = "mail.smtp.host";
//    private static final String KEY_MAIL_AUTH = "mail.smtp.auth";
//    private static final String VALUE_MAIL_AUTH = "true";

    public static MailManager getInstance() {
        return InstanceHolder.instance;
    }

    private MailManager() {
    }

    private static class InstanceHolder {
        private static MailManager instance = new MailManager();
    }

    private class MailTask extends AsyncTask<Void, Void, Boolean> {

        private MimeMessage mimeMessage;

        public MailTask(MimeMessage mimeMessage) {
            this.mimeMessage = mimeMessage;
        }

        @Override
        protected Boolean doInBackground(Void... voids) {
            try {
                Transport.send(mimeMessage);
                return Boolean.TRUE;
            } catch (MessagingException e) {
                e.printStackTrace();
                return Boolean.FALSE;
            }
        }
    }

    public void sendMail(List<String> mailAddressTo , final String title, final String content) {
        MimeMessage mimeMessage = createMessage(mailAddressTo , title, content);
        MailTask mailTask = new MailTask(mimeMessage);
        mailTask.execute();
    }

    public void sendMail(String mailAddressTo , final String title, final String content){
        ArrayList<String> addresses = new ArrayList<String>();
        addresses.add(mailAddressTo);
        sendMail(addresses , title, content);
    }

    public void sendMailWithFile(List<String> mailAddressTo  , String title, String content, String filePath) {
        MimeMessage mimeMessage = createMessage(mailAddressTo , title, content);
        appendFile(mimeMessage, filePath);
        MailTask mailTask = new MailTask(mimeMessage);
        mailTask.execute();
    }

    public void sendMailWithFile(String mailAddressTo  , String title, String content, String filePath){
        ArrayList<String> addresses = new ArrayList<String>();
        addresses.add(mailAddressTo);
        sendMailWithFile(addresses  , title, content, filePath);
    }

    public void sendMailWithMultiFile(List<String> mailAddressTo , String title, String content, List<String> pathList) {
        MimeMessage mimeMessage = createMessage(mailAddressTo , title, content);
        appendMultiFile(mimeMessage, pathList);
        MailTask mailTask = new MailTask(mimeMessage);
        mailTask.execute();
    }

    public void sendMailWithMultiFile(String mailAddressTo , String title, String content, List<String> pathList){
        ArrayList<String> addresses = new ArrayList<String>();
        addresses.add(mailAddressTo);
        sendMailWithMultiFile(addresses , title, content, pathList);
    }

    private Authenticator getAuthenticator() {
        return new Authenticator(){
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(MailParams.getInstance().getSenderMailAddress(), MailParams.getInstance().getSenderPass());
            }
        };
    }

    private MimeMessage createMessage(List<String> mailAddressTo , String title, String content) {
        Properties properties = System.getProperties();
        properties.put(MailParams.getInstance().getKeyMailHost(), MailParams.getInstance().getValueMailHost());
        properties.put(MailParams.getInstance().getKeyMailAuth(), MailParams.getInstance().getValueMailAuth());
        properties.setProperty(MailParams.getInstance().getKeyMailSslEnabled(), MailParams.getInstance().getValueMailSslEnabled()); //mail.smtp.ssl.enable/true
        properties.setProperty(MailParams.getInstance().getKeyMailPort(), MailParams.getInstance().getValueMailPort()); // SMTP邮件服务器默认端口 //"mail.smtp.port", "465"
        properties.setProperty(MailParams.getInstance().getKeyMailSocketFactoryClass(), MailParams.getInstance().getValueMailSocketFactoryClass()); //"mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory"
        Session session = Session.getInstance(properties, getAuthenticator());
        MimeMessage mimeMessage = new MimeMessage(session);
        try {
            mimeMessage.setFrom(new InternetAddress(MailParams.getInstance().getSenderMailAddress()));
            int size = mailAddressTo.size();
            InternetAddress[] addresses = new InternetAddress[size];
            for (int i = 0 ; i < size ; i ++){
                addresses[i] = new InternetAddress(mailAddressTo.get(i));
            }
            //InternetAddress[] addresses = new InternetAddress[]{new InternetAddress("1817570011@qq.com")};
            mimeMessage.setRecipients(Message.RecipientType.TO, addresses);
            mimeMessage.setSubject(title);
            MimeBodyPart textPart = new MimeBodyPart();
            textPart.setContent(content, MailParams.getInstance().getContentType());//text/html;charset=utf-8
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(textPart);
            mimeMessage.setContent(multipart);
            mimeMessage.setSentDate(new Date());
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return mimeMessage;
    }

    private void appendFile(MimeMessage message, String filePath) {
        try {
            Multipart multipart = (Multipart) message.getContent();
            MimeBodyPart filePart = new MimeBodyPart();
            filePart.attachFile(filePath);
            multipart.addBodyPart(filePart);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    private void appendMultiFile(MimeMessage message, List<String> pathList) {
        try {
            Multipart multipart = (Multipart) message.getContent();
            for (String path : pathList) {
                MimeBodyPart filePart = new MimeBodyPart();
                filePart.attachFile(path);
                multipart.addBodyPart(filePart);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}

