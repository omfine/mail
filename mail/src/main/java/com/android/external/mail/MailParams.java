package com.android.external.mail;

public class MailParams {

    private String senderMailAddress = null;
    private String senderPass = null;
    private String keyMailHost = "mail.smtp.host";
    private String valueMailHost = "smtp.qq.com";
    private String keyMailAuth = "mail.smtp.auth";
    private String valueMailAuth = "true";
    private String keyMailSslEnabled = "mail.smtp.ssl.enable";
    private String valueMailSslEnabled = "true";
    private String keyMailPort = "mail.smtp.port";
    private String valueMailPort = "465";
    private String keyMailSocketFactoryClass = "mail.smtp.socketFactory.class";
    private String valueMailSocketFactoryClass = "javax.net.ssl.SSLSocketFactory";
    private String contentType = "text/html;charset=utf-8";

    private MailParams(){}

    private MailParams setParams(String senderMailAddress, String senderPass,
                      String keyMailHost, String valueMailHost,
                      String keyMailAuth, String valueMailAuth ,
                      String keyMailSslEnabled , String valueMailSslEnabled ,
                      String keyMailPort , String valueMailPort ,
                      String keyMailSocketFactoryClass , String valueMailSocketFactoryClass ,
                      String contentType) {
        getInstance().senderMailAddress = senderMailAddress;
        getInstance().senderPass = senderPass;
        getInstance().keyMailHost = keyMailHost;
        getInstance().valueMailHost = valueMailHost;
        getInstance().keyMailAuth = keyMailAuth;
        getInstance().valueMailAuth = valueMailAuth;
        getInstance().keyMailSslEnabled = keyMailSslEnabled;
        getInstance().valueMailSslEnabled = valueMailSslEnabled;
        getInstance().keyMailPort = keyMailPort;
        getInstance().valueMailPort = valueMailPort;
        getInstance().keyMailSocketFactoryClass = keyMailSocketFactoryClass;
        getInstance().valueMailSocketFactoryClass = valueMailSocketFactoryClass;
        getInstance().contentType = contentType;
        return getInstance();
    }

    private static class InstanceHolder {
        private static MailParams instance = new MailParams();
    }

    public static MailParams getInstance(){
        return InstanceHolder.instance;
    }

    public String getSenderMailAddress() {
        return senderMailAddress;
    }

    public String getSenderPass() {
        return senderPass;
    }

    public String getKeyMailHost() {
        return keyMailHost;
    }

    public String getValueMailHost() {
        return valueMailHost;
    }

    public String getKeyMailAuth() {
        return keyMailAuth;
    }

    public String getValueMailAuth() {
        return valueMailAuth;
    }

    public String getKeyMailSslEnabled() {
        return keyMailSslEnabled;
    }

    public String getValueMailSslEnabled() {
        return valueMailSslEnabled;
    }

    public String getKeyMailPort() {
        return keyMailPort;
    }
    public String getValueMailPort() {
        return valueMailPort;
    }
    public String getKeyMailSocketFactoryClass() {
        return keyMailSocketFactoryClass;
    }
    public String getValueMailSocketFactoryClass() {
        return valueMailSocketFactoryClass;
    }
    public String getContentType() {
        return contentType;
    }

    public static class Builder{

        public Builder(){}

        private String senderMailAddress = null;
        private String senderPass = null;
        private String keyMailHost = "mail.smtp.host";
        private String valueMailHost = "smtp.qq.com";
        private String keyMailAuth = "mail.smtp.auth";
        private boolean valueMailAuth = true;

        private String keyMailSslEnabled = "mail.smtp.ssl.enable";
        private boolean valueMailSslEnabled = true;

        private String keyMailPort = "mail.smtp.port";
        private String valueMailPort = "465";

        private String keyMailSocketFactoryClass = "mail.smtp.socketFactory.class";
        private String valueMailSocketFactoryClass = "javax.net.ssl.SSLSocketFactory";

        private String contentType = "text/html;charset=utf-8";

        public Builder setSenderMailAddress(String senderMailAddress){
            this.senderMailAddress  = senderMailAddress;
            return this;
        }

        public Builder setSenderPass(String senderPass){
            this.senderPass = senderPass;
            return this;
        }

        public Builder setKeyMailHost(String keyMailHost){
            this.keyMailHost = keyMailHost;
            return this;
        }

        public Builder setValueMailHost(String valueMailHost){
            this.valueMailHost = valueMailHost;
            return this;
        }

        public Builder setKeyMailAuth(String keyMailAuth){
            this.keyMailAuth = keyMailAuth;
            return this;
        }

        public Builder setValueMailAuth(boolean valueMailAuth){
            this.valueMailAuth = valueMailAuth;
            return this;
        }

        public Builder setKeyMailSslEnabled(String keyMailSslEnabled){
            this.keyMailSslEnabled = keyMailSslEnabled;
            return this;
        }

        public Builder setValueMailSslEnabled(boolean valueMailSslEnabled){
            this.valueMailSslEnabled = valueMailSslEnabled;
            return this;
        }

        public Builder setKeyMailPort(String keyMailPort){
            this.keyMailPort = keyMailPort;
            return this;
        }

        public Builder setValueMailPort(String valueMailPort){
            this.valueMailPort = valueMailPort;
            return this;
        }

        public Builder setKeyMailSocketFactoryClass(String keyMailSocketFactoryClass){
            this.keyMailSocketFactoryClass = keyMailSocketFactoryClass;
            return this;
        }

        public Builder setValueMailSocketFactoryClass(String valueMailSocketFactoryClass){
            this.valueMailSocketFactoryClass = valueMailSocketFactoryClass;
            return this;
        }

        public Builder setContentType(String contentType){
            this.contentType = contentType;
            return this;
        }

        public MailParams build(){
            return getInstance().setParams(senderMailAddress, senderPass,keyMailHost , valueMailHost , keyMailAuth ,
                    valueMailAuth ? "true" : "false" , keyMailSslEnabled , valueMailSslEnabled?"true" : "false" ,
                    keyMailPort , valueMailPort , keyMailSocketFactoryClass ,
                    valueMailSocketFactoryClass , contentType);
        }

    }


}
