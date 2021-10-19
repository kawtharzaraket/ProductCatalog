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
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.InputMethodEvent;

/**
 * FXML Controller class
 *
 * @author acer
 */
public class AdjustProductController implements Initializable {

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
    private Button Adjust;
    @FXML
    private ComboBox<String> ID;
  @FXML
     private ObservableList<String> data ;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ConnectionClass c = ConnectionClass.getInstance();
        data=c.getIDs();
        if(data!=null)
            ID.setItems(data);
    }    

    @FXML
    private void ChangeText(InputMethodEvent event) {
        Adjust.setText("Edit");
    }

    @FXML
    private void AdjustAction(ActionEvent event) {
        if(Adjust.getText().equalsIgnoreCase("Delete")){
            ConnectionClass c = ConnectionClass.getInstance();
            c.deleteproduct(Integer.parseInt(ID.getValue()));
            
        }
        else {
            ConnectionClass c = ConnectionClass.getInstance();
            c.editproduct(Integer.parseInt(ID.getValue()),name.getText(),type.getText()
                ,category.getText(),color.getText(),size.getText(),price.getText());
        }
    }

    @FXML
    private void DisplayContent(ActionEvent event) throws IOException {
         ConnectionClass c = ConnectionClass.getInstance();
          ProductItem pr = c.retreiveproduct(Integer.parseInt(ID.getValue()));
          name.setText(pr.getProductName());
          type.setText(pr.getType());
          size.setText(pr.getSize());
          color.setText(pr.getColor());
          price.setText(pr.getPrice()); 
          category.setText(c.getcategory(Integer.parseInt(ID.getValue())));
    }
    
}
