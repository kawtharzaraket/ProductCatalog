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
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author acer
 */
public class IndexNewController implements Initializable {

    @FXML
    private AnchorPane NewCategory;
    @FXML
    private ComboBox<String> category;
    @FXML
    private TableView<ProductItem> table;
    @FXML
    private TableColumn<ProductItem, Integer> ProductID;
    @FXML
    private TableColumn<ProductItem, String> ProductName;
    @FXML
    private TableColumn<ProductItem, String> Type;
    @FXML
    private TableColumn<ProductItem, String> Color;
    @FXML
    private TableColumn<ProductItem, String> Size;
    @FXML
    private TableColumn<ProductItem, String> Price;
    @FXML
    private Hyperlink AddProduct;
    @FXML
    private Hyperlink EditProduct;
    @FXML
    private Hyperlink DeleteProduct;
    @FXML
    private Button Renamecat;
    @FXML
    private TextField Newcatt;

    @FXML
    private Button Deletecat;
     private ObservableList<String> data ;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       
        table.setVisible(false);
        ConnectionClass c = ConnectionClass.getInstance();
        data=c.getcategoryname();
        if(data!=null)
            category.setItems(data);
    }    

    @FXML
    private void ShowTable(ActionEvent event) {
        String name=category.getValue();
        ConnectionClass c = ConnectionClass.getInstance();
        ProductID.setCellValueFactory(new PropertyValueFactory<ProductItem, Integer>("ProductID"));
        ProductName.setCellValueFactory(new PropertyValueFactory<ProductItem, String>("ProductName"));
        Type.setCellValueFactory(new PropertyValueFactory<ProductItem, String>("Type"));
        Color.setCellValueFactory(new PropertyValueFactory<ProductItem, String>("Color"));
        Size.setCellValueFactory(new PropertyValueFactory<ProductItem, String>("Size"));
        Price.setCellValueFactory(new PropertyValueFactory<ProductItem, String>("Price"));
       
        
        table.setItems(c.getProducttable(name)); System.out.println(c.getProducttable(name));
        table.setVisible(true);
        
        table.autosize();
    }

    @FXML
    private void MoveTONext( ActionEvent event) {
        final Node  source= (Node)event.getSource();
        if(source.getId().equalsIgnoreCase("AddProduct")){
            try {
               Stage stage= new Stage();
               
               Parent root = FXMLLoader.load(getClass().getResource("NewProduct.fxml"));
               
               Scene scene = new Scene(root);
               
               stage.setScene(scene);
               stage.show();
           } catch (IOException ex) {
               Logger.getLogger(LoginController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
           }
        }
        else {
            try {
               Stage stage= new Stage();
               
               Parent root = FXMLLoader.load(getClass().getResource("AdjustProduct.fxml"));
               
               Scene scene = new Scene(root);
               
               stage.setScene(scene);
               stage.show();
           } catch (IOException ex) {
               Logger.getLogger(LoginController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
           }
        }
    }

    @FXML
    private void RenameCategory(ActionEvent event) {
         
        String old=category.getValue();
        String newn=Newcatt.getText(); System.out.println(old);System.out.println(newn);
         ConnectionClass c = ConnectionClass.getInstance();
         c.renamecategory(old,newn);
    }
    

    @FXML
    private void DeleteCategory(ActionEvent event) {
         String name=category.getValue();
         ConnectionClass c = ConnectionClass.getInstance();
         c.deletecategory(name);
    }
    
}
