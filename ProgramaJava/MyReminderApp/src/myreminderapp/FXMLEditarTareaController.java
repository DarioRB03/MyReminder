/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package myreminderapp;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author 1erDAM
 */
public class FXMLEditarTareaController implements Initializable {

    @FXML
    private Button buttonAplicar;
    @FXML
    private Button buttonEliminar;
    @FXML
    private ComboBox<?> idModuloComboBox;
    @FXML
    private TextArea DescripTextArea;
    @FXML
    private Text fechaTxt;
    @FXML
    private Button buttonVolver;
    @FXML
    private ComboBox<?> prioridadComboBox;
    @FXML
    private ComboBox<?> añoComboBox;
    @FXML
    private ComboBox<?> diaComboBox;
    @FXML
    private ComboBox<?> mesComboBox;
    @FXML
    private CheckBox realizadaCheckBox;
    @FXML
    private Text EditarTareaTxt;
    @FXML
    private Text tituloTxt;
    @FXML
    private TextField TituloEventoField;
    @FXML
    private Text DescripcionTxt;
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
