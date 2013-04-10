package ebay.action;
import javax.mail.Message.RecipientType;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.util.MyLog;
/**
 * 
 * @author Satya Deepthi Bhagi
 */


public class email {
	
public void sendmail(String username,String to,String role){
     
    
    /* Send e-mail*/
	MyLog.log("Getting mail list is"+to);
	System.out.println("Getting mail list is"+to);
    javax.mail.Session defaultSession;
    String  from , host;

    String password;  
         from = "wfmanage";
         password ="satyadeepthi";
         host = "smtp.gmail.com";
         
         try
         {
         java.util.Properties props = System.getProperties(); 
         props.put("mail.smtp.starttls.enable", "true"); 
         props.put("mail.smtp.host", host); 
         props.setProperty("mail.transport.protocol", "smtp");
         props.put("mail.smtp.user", from); 
         props.put("mail.smtp.password", password); 
         props.put("mail.smtp.port", "25"); 
         props.put("mail.smtp.auth", "true"); 
         defaultSession = javax.mail.Session.getDefaultInstance(props, new javax.mail.Authenticator() {
                protected javax.mail.PasswordAuthentication 
                getPasswordAuthentication() {
                return new javax.mail.PasswordAuthentication("wfmanage@gmail.com", "satyadeepthi");
                }}); 
         MimeMessage message = new MimeMessage(defaultSession); 
         InternetAddress fromAddress = null;
         InternetAddress toAddress = null;

         try {
         fromAddress = new InternetAddress(from);
         toAddress = new InternetAddress(to);
         } catch (AddressException e) {

         e.printStackTrace();
         }

         message.setFrom(fromAddress);
         message.addRecipients(RecipientType.TO, to);

          if(role==""||role==null){
             message.setSubject("Your Registrtion to eBay is Successful");
             String emailBody = "Dear "+ username + ", Congratulations. Your Registration to eBay has been completed Successfully. Please use your username and password to login to eBay";
             message.setText(emailBody); 
             }
          else{
        	  message.setSubject("Item is getting out of stock");
              String emailBody = "Dear "+ username + ", Your item to sell '"+ role+ "' is becoming out of stock. Please improve the quantity for better sales.";
              message.setText(emailBody);
          }
         //SMTPSSLTransport transport =(SMTPSSLTransport)session.getTransport("smtps");

         Transport.send(message);
         }catch(Exception ex){
             ex.printStackTrace();
         }
      
    }

}