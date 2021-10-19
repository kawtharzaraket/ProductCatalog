/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import connectivity.ConnectionClass;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import java.io.Console; 
import java.util.Scanner;
/**
 *
 * @author acer
 */
public class LoginController implements Initializable {
    
    @FXML
    private Button login;
    @FXML
    private Label label;
    @FXML
    private TextField username;
     @FXML
    private PasswordField password;
    
        
    
    @FXML
    private void LOGIN(ActionEvent event){
        
       ConnectionClass conn = ConnectionClass.getInstance();
       if (conn.isuser(username.getText(), password.getText())){
           try {
               Stage stage= new Stage();
               
               Parent root = FXMLLoader.load(getClass().getResource("Index.fxml"));
               
               Scene scene = new Scene(root);
               
               stage.setScene(scene);
               stage.show();
           } catch (IOException ex) {
               Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
           }
}
       else 
           JOptionPane.showMessageDialog(null, "YOU ARE NOT THE ADMIN!!");
    }
      @FXML
    void RegisterNew(ActionEvent event) {
        Console c=System.console();   Scanner in = new Scanner(System.in);
        System.out.println("Enter your Username: ");    
        String username=in.next();      
        System.out.println("Enter your password: ");    
        String pass=in.next();      
        System.out.println("Enter your email: ");    
        String email=in.next();      
             ConnectionClass conn = ConnectionClass.getInstance();
           conn.registeruser(username,pass,email);
           System.out.println("You are registered!!");  
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
