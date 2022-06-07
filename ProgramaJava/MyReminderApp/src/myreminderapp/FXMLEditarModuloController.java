/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package myreminderapp;

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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author 1erDAM
 */
public class FXMLEditarModuloController implements Initializable {

    @FXML
    private Text tituloTxt;
    @FXML
    private Text editarPorcTxt;
    @FXML
    private Text editarNotaTxt;
    @FXML
    private Label editarPorcLabel;
    @FXML
    private Text añadirPorcTxt;
    @FXML
    private Text añadirNotaTxt;
    @FXML
    private Label añadirPorcLabel;
    @FXML
    private Button buttonConfirmar;
    @FXML
    private Button buttonAñadir;
    @FXML
    private ComboBox<?> ComboBoxEv;
    @FXML
    private Button buttonVolver;
    @FXML
    private TextField tituloField;
    @FXML
    private Text EditarModuloTxt;
    @FXML
    private TextField editarPorcField;
    @FXML
    private TextField editarNotaField;
    @FXML
    private Text evaluacionTxt;
    @FXML
    private Text EditarEvTxt;
    @FXML
    private Text añadirEvTxt;
    @FXML
    private TextField añadirPorcField;
    @FXML
    private TextField añadirNotaField;
    @FXML
    private Button buttonAplicar1;
    @FXML
    private Button buttonEliminar1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleAplicarAction(ActionEvent event) {
    }

    @FXML
    private void handleEliminarAction(ActionEvent event) {
    }

    @FXML
    private void handleConfirmarAction(ActionEvent event) {
    }

    @FXML
    private void handleAñadirAction(ActionEvent event) {
    }

    @FXML
    private void handleVolverAction(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("FXMLPantallaBase.fxml"));
            
            Scene scene = new Scene(root);
            Stage stage = new Stage();
        
            stage.setScene(scene);
            stage.show();
        
            Stage myStage = (Stage) this.buttonVolver.getScene().getWindow();
            myStage.close();
        } catch (IOException ex) {
            Logger.getLogger(FXMLPantallaLogInController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
