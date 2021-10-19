/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.TextField;

/**
 *
 * @author acer
 */
public class ProductItem {
    private SimpleStringProperty ProductName;
    private Integer ProductID;
    private SimpleStringProperty Type;
    private SimpleStringProperty Color; private SimpleStringProperty Size; private SimpleStringProperty Price;
    public ProductItem(Integer ProductID, String ProductName, String Type, String Color, String Size, String Price) {
        this.ProductName = new SimpleStringProperty(ProductName);
        this.ProductID = ProductID;
        this.Type = new SimpleStringProperty(Type);
        this.Color = new SimpleStringProperty(Color);
        this.Size = new SimpleStringProperty(Size);
        this.Price = new SimpleStringProperty(Price);
    }

    public String getProductName() {
        return ProductName.get();
    }

    public Integer getProductID() {
        return ProductID;
    }

    public String getType() {
        return Type.get();
    }

    public String getColor() {
        return Color.get();
    }

    public String getSize() {
        return Size.get();
    }

    public String getPrice() {
        return Price.get()+"$";
    }

    public void setProductName(SimpleStringProperty ProductName) {
        this.ProductName = ProductName;
    }

    public void setProductID(Integer ProductID) {
        this.ProductID = ProductID;
    }

    public void setType(SimpleStringProperty Type) {
        this.Type = Type;
    }

    public void setColor(SimpleStringProperty Color) {
        this.Color = Color;
    }

    public void setSize(SimpleStringProperty Size) {
        this.Size = Size;
    }

    public void setPrice(SimpleStringProperty Price) {
        this.Price = Price;
    }

    @Override
    public String toString() {
        return "ProductItem{" + "ProductName=" + ProductName + ", ProductID=" + ProductID + ", Type=" + Type + ", Color=" + Color + ", Size=" + Size + ", Price=" + Price + '}';
    }
    
   

    
    
    
}

