/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import connectivity.ConnectionClass;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.InputMethodEvent;

/**
 * FXML Controller class
 *
 * @author acer
 */
public class NewProductController implements Initializable {

    @FXML
    private TextField ID;
    @FXML
    private TextField type;
    @FXML
    private TextField color;
    @FXML
    private TextField name;
    @FXML
    private TextField size;
    @FXML
    private TextField category;
    @FXML
    private TextField price;
    @FXML
    private Button Addp;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void AddCategory(ActionEvent event) {
        
        ConnectionClass c = ConnectionClass.getInstance();
        c.addproduct(Integer.parseInt(ID.getText()),name.getText(),type.getText()
                ,category.getText(),color.getText(),size.getText(),price.getText());
    }

    
}
