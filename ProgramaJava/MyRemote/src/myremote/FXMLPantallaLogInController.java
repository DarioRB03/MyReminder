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
public class FXMLPantallaLogInController implements Initializable {

    @FXML
    private TextField fieldTextNick;
    @FXML
    private TextField fieldTextPasswd;
    @FXML
    private Button buttonLogIn;
    @FXML
    private Button buttonRegister;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleIniciarSesionAction(ActionEvent event) {
    }

    @FXML
    private void handleRegistrarseAction(ActionEvent event) {
    }
    
}
