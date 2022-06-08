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
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author 1erDAM
 */
public class FXMLVerEventoController implements Initializable {

    @FXML
    private Button buttonEditar;
    @FXML
    private TextArea DescripLabel;
    @FXML
    private Text IdTxt;
    @FXML
    private Text PrioridadTxt;
    @FXML
    private Text DescripTxt;
    @FXML
    private Text FechaTxt;
    @FXML
    private Text TituloTxt;
    @FXML
    private Text ModuloTxt;
    @FXML
    private Text EventoTxt;
    @FXML
    private Label IdLabel;
    @FXML
    private Label TituloLabel;
    @FXML
    private Label ModuloLabel;
    @FXML
    private Label FechaLabel;
    @FXML
    private Label PrioridadLabel;
    @FXML
    private Button buttonVolver;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void handleEditarAction(ActionEvent event) {
        
    }

    @FXML
    private void handleVolverAction(ActionEvent event) {
    }
    
}
