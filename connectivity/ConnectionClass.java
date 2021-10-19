/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connectivity;

import java.io.FileWriter;
import java.sql.Statement;
import java.sql.Timestamp;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.swing.JOptionPane;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.json.JSONArray;
import org.json.JSONObject;
import project.ProductItem;

/**
 *
 * @author acer
 */
public class ConnectionClass {
    public Connection connection;
    private static ConnectionClass c=new ConnectionClass();
    private   ConnectionClass(){


        String dbName="Abscence";
        String userName="root";
        String password="";

        try {
            Class.forName("com.mysql.jdbc.Driver");

        connection= DriverManager.getConnection("jdbc:mysql://localhost/productcatalog",userName,password);
        System.out.println("connected");


        } catch (Exception e) {
        	System.out.println("not connected");
           JOptionPane.showMessageDialog(null,e);
           
        }


        
    }
      
    public ProductItem retreiveproduct(int id) throws IOException{
        ProductItem pr= null;
         try {
            Statement stmnt = connection.createStatement();
            String sql2="Select * from product where ProductId="+id; 
             ResultSet rs2=stmnt.executeQuery(sql2);
             JSONObject jsonObject0 = new JSONObject();
      //Creating a json array
             JSONArray array = new JSONArray();
             
             if(rs2.next()){
                 JSONObject jsonObject = new JSONObject();
                 jsonObject.put("ID", rs2.getInt("ProductId"));
                jsonObject.put("Name", rs2.getString("Name"));
                jsonObject.put("Type", rs2.getString("Type"));
                jsonObject.put("Category", rs2.getDate("Category"));
                jsonObject.put("Color", rs2.getString("Color"));
                jsonObject.put("Size", rs2.getString("Size"));
                jsonObject.put("Price", rs2.getString("Price"));
                 pr = new ProductItem(id,rs2.getString("Name"),rs2.getString("Type"),rs2.getString("Color"),rs2.getString("Size"),
                 rs2.getString("Price")); 
                  array.put(jsonObject);}
              jsonObject0.put("Productitem", array);
                  FileWriter file = new FileWriter("E:/ProductItem.json");
         file.write(jsonObject0.toString());
         file.close();
            
         }
         catch (SQLException ex) {
                 
            Logger.getLogger(ConnectionClass.class.getName()).log(Level.SEVERE, null, ex);
          
        } 
        return pr;
    }
     public String getcategory(int id) throws IOException{
       String cat=null;
         try {
            Statement stmnt = connection.createStatement();
            String sql2="Select Category from product where ProductId="+id; 
             ResultSet rs2=stmnt.executeQuery(sql2);
             JSONObject jsonObject0 = new JSONObject();
      //Creating a json array
             JSONArray array = new JSONArray();
             
             if(rs2.next()){ 
                  JSONObject jsonObject = new JSONObject();
                 jsonObject.put("Category", rs2.getInt("Category"));
               cat= rs2.getString("Category");
               array.put(jsonObject);
             }
              jsonObject0.put("Category", array);
                  FileWriter file = new FileWriter("E:/Category.json");
         file.write(jsonObject0.toString());
         file.close();
         }
         catch (SQLException ex) {
                 
            Logger.getLogger(ConnectionClass.class.getName()).log(Level.SEVERE, null, ex);
          
        } 
        return cat;
    }
     
      public ObservableList<String> getcategoryname(){
        ObservableList<String> data =FXCollections.observableArrayList();
         try {
            Statement stmnt = connection.createStatement();
            String sql2="Select distinct Category from product where 1"; 
             ResultSet rs2=stmnt.executeQuery(sql2);
             while(rs2.next()){
                 data.add(rs2.getString("Category"));
             }
         }
         catch (SQLException ex) {
                 
            Logger.getLogger(ConnectionClass.class.getName()).log(Level.SEVERE, null, ex);
          
        } 
        return data;
    }
      public ObservableList<ProductItem> getProducttable(String category)
    {
        ObservableList<ProductItem> people = FXCollections.observableArrayList();
        Integer id;String name;
        String type; String color; String size; String price;
        
        try{
            Statement stmnt = connection.createStatement();
           
            String sql1="Select ProductId, Name, Type, Color, Size, Price from product where Category like '"+category+"'";
            ResultSet rs1=stmnt.executeQuery(sql1);
            
             while(rs1.next()){
                
                  id=new Integer(rs1.getInt("ProductId"));
                  name=rs1.getString("Name"); 
                  type=rs1.getString("Type"); 
                   color=rs1.getString("Color");
                   size=rs1.getString("Size");
                   price=rs1.getString("Price");
                  
                 ProductItem pr =new ProductItem(id,name,type,color,size,price);
                    people.add(pr);
                
             
            }
      
        }
         catch (SQLException ex) {
                 
            Logger.getLogger(ConnectionClass.class.getName()).log(Level.SEVERE, null, ex);
          
        } 
        return people;
    }
     public void deletecategory(String category){
          try { 
                 Statement stmnt = connection.createStatement();
               String sql1="Delete from product where Category like '"+category+"'";
                 stmnt.executeUpdate(sql1);
           
               
            } catch (SQLException ex) {
                Logger.getLogger(ConnectionClass.class.getName()).log(Level.SEVERE, "This category doesn't exist", ex);
                
            }
     } 
     public void deleteproduct(int ID){
          try { 
                 Statement stmnt = connection.createStatement();
               String sql1="Delete from product where ProductId = '"+ID+"'";
                 stmnt.executeUpdate(sql1);
           
               
            } catch (SQLException ex) {
                Logger.getLogger(ConnectionClass.class.getName()).log(Level.SEVERE, "This id doesn't exist", ex);
                
            }
     }  
       public void renamecategory(String oldcategory, String newcategory){
          try { 
                 Statement stmnt = connection.createStatement();
               String sql1="Update product  set Category ='"+newcategory+"' where Category='"+oldcategory+"'";  System.out.println(sql1);
                 stmnt.executeUpdate(sql1);
           
               
            } catch (SQLException ex) {
                Logger.getLogger(ConnectionClass.class.getName()).log(Level.SEVERE, "This category doesn't exist", ex);
                
            }
     }  
        public void editproduct(int id,String name,String type,String category, String color,String size, String price){
          try { 
                 Statement stmnt = connection.createStatement();
               String sql1="Update product Set Name ='"+name+"',Type ='"+type+"',Category ='"+category
                       + "', Color ='"+color+"',Size ='"+size+"',Price ='"+price
                        + "where ProductId ='"+id+"'" ;
                 stmnt.executeUpdate(sql1);
           
               
            } catch (SQLException ex) {
                Logger.getLogger(ConnectionClass.class.getName()).log(Level.SEVERE, "This Level doesn't exist", ex);
                
            }
     }
         public boolean addproduct(int id,String name,String type,String category, String color,String size, String price){
                 try {
                 Statement stmnt = connection.createStatement();
               
                 String sql1="Insert into product "
                         + "(ProductId, Name, Type, Category, Color, Price, Size) Values ("+id+",'"+name+"','"+type+"','"+category+"','"+color+"','"+size+"','"+price+"')";
                  stmnt.executeUpdate(sql1);
                  
                 return true;
                  }
                  catch (SQLException ex) {  
                 Logger.getLogger(ConnectionClass.class.getName()).log(Level.SEVERE, null, ex);
                 return false;
             }
         }
         public ObservableList<String> getIDs(){
        ObservableList<String> data =FXCollections.observableArrayList();
         try {
            Statement stmnt = connection.createStatement();
            String sql2="Select ProductId from product "; 
             ResultSet rs2=stmnt.executeQuery(sql2);
             while(rs2.next()){
                 data.add(rs2.getString("ProductId"));
             }
         }
         catch (SQLException ex) {
                 
            Logger.getLogger(ConnectionClass.class.getName()).log(Level.SEVERE, null, ex);
          
        } 
        return data;
    }
      
    public static ConnectionClass getInstance() {
    	return c;
    }
    
         public boolean isuser(String name,String pass){
        try {
            Statement stmnt = connection.createStatement();
             System.out.println(stmnt);
            ResultSet rs=stmnt.executeQuery("Select * from user where 1");
           while(rs.next()){
              String user=rs.getString("Username");
               String password=rs.getString("password");
               if(name.equals(user)&&password.equals(pass))
                   return true;
               
               
           }
          
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex);
        
        }
        return false;
    }
         
   
    public void registeruser(String username, String pass, String email) {
         try { 
                 Statement stmnt = connection.createStatement();
               String sql1="Insert into user (Username,password,Email) Values ('"+username+"','"+pass+"','"+email+"')";
                      
                 stmnt.executeUpdate(sql1);
         
               
            } catch (SQLException ex) {
                Logger.getLogger(ConnectionClass.class.getName()).log(Level.SEVERE, "This Level doesn't exist", ex);
                
            }
          
    }

   
}