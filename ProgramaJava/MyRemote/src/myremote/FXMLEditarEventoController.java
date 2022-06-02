/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package myremote;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;


/**
 * FXML Controller class
 *
 * @author 1erDAM
 */
public class FXMLEditarEventoController implements Initializable {
    
    private boolean claro;
    @FXML
    private TextArea DescripTextArea;
    @FXML
    private Text fechaTxt;
    @FXML
    private ComboBox<?> idModuloComboBox;
    @FXML
    private Button buttonAplicar;
    @FXML
    private Button buttonEliminar;
    @FXML
    private Button buttonVolver;
    @FXML
    private ComboBox<?> prioridadComboBox;
    @FXML
    private AnchorPane pane;
    @FXML
    private Text EditarEventoTxt;
    @FXML
    private Text tituloTxt;
    @FXML
    private TextField TituloEventoField;
    @FXML
    private Text DescripcionTxt;
    @FXML
    private TextField fechaField;
    @FXML
    private Text idModuloTxt;
    @FXML
    private Text medioTxt;
    @FXML
    private Text nivelPrioridadTxt;
    @FXML
    private Text AltoTxt;
    @FXML
    private Text bajoTxt;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        claro=true;
        
        if(claro=true){
             Paint labelPaint = Paint.valueOf("#000");
        
        this.pane.setStyle("-fx-background-color: #FFF");
        this.fechaTxt.setFill(labelPaint);
        this.tituloTxt.setFill(labelPaint);
        this.DescripcionTxt.setFill(labelPaint);
        this.idModuloTxt.setFill(labelPaint);
        this.medioTxt.setFill(labelPaint);
        this.nivelPrioridadTxt.setFill(labelPaint);
        this.AltoTxt.setFill(labelPaint);
        this.bajoTxt.setFill(labelPaint);
        this.idModuloComboBox.setStyle("-fx-background-color: #dddddd");
        this.prioridadComboBox.setStyle("-fx-background-color: #dddddd");
        this.idModuloComboBox.setStyle("-fx-background-color: #dddddd");
        this.idModuloComboBox.setStyle("-fx-background-color: #dddddd");     
        }else{
        
        Paint labelPaint = Paint.valueOf("#ffffff");
        
        this.pane.setStyle("-fx-background-color: #404040");
        this.fechaTxt.setFill(labelPaint);
        this.tituloTxt.setFill(labelPaint);
        this.DescripcionTxt.setFill(labelPaint);
        this.idModuloTxt.setFill(labelPaint);
        this.medioTxt.setFill(labelPaint);
        this.nivelPrioridadTxt.setFill(labelPaint);
        this.AltoTxt.setFill(labelPaint);
        this.bajoTxt.setFill(labelPaint);
        
        }
    }    

    @FXML
    private void handleAplicarAction(ActionEvent event) {
    }

    @FXML
    private void handleEliminarAction(ActionEvent event) {
    }

    @FXML
    private void handleVolverAction(ActionEvent event) {
    }
    
}
