# mail
init

step 1 , add permissions below in your AndroidManifest.xml

    <uses-permission android:name="android.permission.INTERNET"/>
    <uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE"/>
    <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE"/>
    
step 2 ,init some parameters

        MailParams.Builder()
              .setSenderMailAddress("2215522@qq.com")
              .setSenderPass("nbbugagbxrbfcbbe")
//            .setKeyMailHost("mail.smtp.host") //if use qq mail host , this param not added , has inited in code
//            .setValueMailHost("smtp.qq.com") //if use qq mail host , this param not added , has inited in code
//            .setKeyMailAuth("mail.smtp.auth") //if use qq mail host , this param not added , has inited in code
//            .setValueMailAuth(true) //if use qq mail host , this param not added , has inited in code
//            .setKeyMailSslEnabled("mail.smtp.ssl.enable") //if use qq mail host , this param not added , has inited in code
//            .setValueMailSslEnabled(true) //if use qq mail host , this param not added , has inited in code
//            .setKeyMailPort("mail.smtp.port") //if use qq mail host , this param not added , has inited in code
//            .setValueMailPort("465") //if use qq mail host , this param not added , has inited in code
//            .setKeyMailSocketFactoryClass("mail.smtp.socketFactory.class") //if use qq mail host , this param not added , has inited in code
//            .setValueMailSocketFactoryClass("javax.net.ssl.SSLSocketFactory") //if use qq mail host , this param not added , has inited in code
//            .setContentType("text/html;charset=utf-8") //if use qq mail host , this param not added , has inited in code
            .build()
            
step 3, now all step completed , so you can use like this below
 
     MailManager.getInstance().sendMail( "2585225@qq.com","过来" , "你可以过来一下吗?")
     
     //and there are other api s ,you can use it.
    
    
