/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author bhagyashree
 */
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Controller {
 String firstName,lastName,email,password;
 User u;
 RegistrationUI rui;
 Chat c;
   public Controller()
   {
       u=new User();
       rui=new RegistrationUI();
       
   }
   /*public Controller(String user,String password) {
        System.out.println("welcome to the application"+user+password);
        
    }*/
   public Controller(String firstName,String lastName,String email,String password){
       this.firstName=firstName;
       this.lastName=lastName;
       this.email=email;
       this.password=password;
      
   }
   public boolean createUser(String firstName,String lastName,String email,String password)
   {
      return u.createUser(firstName,lastName,email,password);
   }
   public boolean checkLogin(String email,String password)
   {
       return u.checkLogin(email,password);
   }
   public void Registration()
   {
       rui.setVisible(true);       
   }
   public ResultSet getOnlineUsers(String email)
   {
       ResultSet rs=u.getOnlineUsers(email);
       return rs;
   }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }

    public void chatWith(String from,String to) {      
        c=new Chat(from,to);
        c.setVisible(true);        
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ResultSet loadChat(String from, String to) {
       return u.loadChat(from ,to);
    // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void sendMessage(String from, String to, String sendmsg) {
        u.sendMessage(from,to,sendmsg);
    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean logout(String email) {
        return u.logout(email);        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
