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
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author 1erDAM
 */
public class FXMLPantallaRegisterController implements Initializable {

    @FXML
    private TextField fillTextNickR;
    @FXML
    private TextField fillTextApellidosR;
    @FXML
    private TextField fillTextPasswdR;
    @FXML
    private TextField fillTextNombreR;
    @FXML
    private Button buttonRegistrarse;
    @FXML
    private Button buttonVolver;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleRegistrarseAction(ActionEvent event) {
    }

    @FXML
    private void handleVolverAction(ActionEvent event) {
    }
    
}
