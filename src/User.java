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
import java.security.*;
import java.util.Formatter;
public class User {
   String firstName,lastName,email,password;
   Connection con;
    Statement st;
    ResultSet rs;
    String uname="root";
    String pass="";
    String url = "jdbc:mysql://localhost/chatapp";   
   
   public User(){
       getConnection();
   }
   public User(String firstName,String lastName,String email,String password)
   {
       this.firstName=firstName;
       this.lastName=lastName;
       this.email=email;
       this.password=password;
       getConnection();
      
   }
   public void getConnection()
   {
        try{
             System.out.println("inside");
         Class.forName("com.mysql.jdbc.Driver");
         con=DriverManager.getConnection(url, uname, pass);

        }
        catch(Exception e)
        {
           e.printStackTrace(); 
        }
   }

    public boolean createUser(String firstName,String lastName,String email,String password) {
     boolean ans = false;
            try{

            st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE); 
            String query="select * from user where email='" + email +"'";  
            System.out.println(""+query);
            rs=st.executeQuery(query);
            if(rs.next())
            {
                System.out.println("rs not null");
               ans=false;
            }
            else
            {
                System.out.println("rs null");
                password=encryptPassword(password);        
                String insert="insert into user (firstName,lastName,email,password) values('"+ firstName +"','"+ lastName +"','" + email +"','" + password +"' )";
                st.executeUpdate(insert);
                ans=true;            
            }
        }
    catch(SQLException e){e.printStackTrace();}
        return ans;
    }
    private static String encryptPassword(String password)
    {
        String sha1 = "";
        try
        {
            MessageDigest crypt = MessageDigest.getInstance("SHA-1");
            crypt.reset();
            crypt.update(password.getBytes("UTF-8"));
            sha1 = byteToHex(crypt.digest());
        }   
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return sha1;
    }

    private static String byteToHex(final byte[] hash)
    {
        Formatter formatter = new Formatter();
        for (byte b : hash)
        {
            formatter.format("%02x", b);
        }
        String result = formatter.toString();
        formatter.close();
        return result;
    }
    
    public boolean checkLogin(String email,String password)
    {
        boolean ans = false;
        try
        {      
            st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE); 
            String passd="";
            String query="select password from user where email='" + email +"'"; 
            password=encryptPassword(password);  
            System.out.println(""+query+"\npassword"+password);
            rs=st.executeQuery(query);
            if(rs!=null)
            {
                while(rs.next())
                {
                    passd=rs.getString(1);                
                }
                query="update user set isOnline=1 where email='" + email +"'";
                st.executeUpdate(query);
                System.out.println(passd);
                if(passd.equals(password))
                {
                    System.out.println("yaay!!!");           
                    ans=true;
                }
                else
                {
                    ans=false;
                    
                    System.out.println("password missmach\n password form db "+passd+"\npassword from input "+password);  
                }
            }
            else
            {
                System.out.println("User doesnt exists");            
                ans=false;            
            }
        }
        catch(SQLException e){e.printStackTrace();}
        return ans;
    }
    
    public ResultSet getOnlineUsers(String email)
    {
     try
        {     
            st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE); 
            String query="select email from user where isOnline=1 and email!='" + email +"'";
            System.out.println(""+query);
            rs=st.executeQuery(query);
            if(rs!=null)
            {
                System.out.println("These users are online"); 
            }
            else
            {
                System.out.println("no user online");
            }
        }
        catch(SQLException e){e.printStackTrace();}
        return rs;   
    }

    public ResultSet loadChat(String from,String to) {
    try
         {           
             st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE); 
             String query="select firstName, msg from message where fromUser in ('" + to +"','"+from+"') and toUser in ('" + to +"','"+from+"') order by messageTime asc";
             System.out.println(""+query);
             rs=st.executeQuery(query);
             if(rs!=null)
             {
                 System.out.println("These are the messages");
//                 while(rs.next())
//                 {
//                     System.out.println(rs.getString(1));
//                 }

             }
             else
             {
                 System.out.println("no user online");
             }
         }
         catch(SQLException e){e.printStackTrace();}
         return rs; 
    }

    public void sendMessage(String from, String to, String sendmsg) {
       try
         {
             st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE); 
             String query0="select firstName from user where email='"+from+"'";
             rs=st.executeQuery(query0);
             rs.first();
             String fname=rs.getString(1);  
             System.out.println("from: "+fname);
             
             String query="insert into message(fromUser,toUser,msg,firstName)values ('" + from +"','"+to+"','"+sendmsg+"','"+fname+"')";
             System.out.println("query : "+query);
             int no=st.executeUpdate(query);
             if(no>0)
             {
                 System.out.println("message sent");
             }
             else
             {
                 System.out.println("not sent");
             }
         }
         catch(SQLException e){e.printStackTrace();}       
    }

    public boolean logout(String email) {
        
        boolean ans = false;
        try
        {
            st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE); 
            String query="update user set isOnline=0 where email='" + email +"'";            
            System.out.println(""+query);
            int n=st.executeUpdate(query);
            closeConnection();
            if(n>0)
            {
              ans=true;
            }
            else
            {
                System.out.println("error in logout");            
                ans=false;            
            }
        }
        catch(SQLException e){e.printStackTrace();}
        return ans;
    }
    
    public void closeConnection()
    {
        try{
            st.close();
            con.close();     
            System.out.println("connection closed");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
