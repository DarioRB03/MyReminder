/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package myremote;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.util.logging.Level;
import java.util.logging.Logger;


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
        
        try {
            Parent root = FXMLLoader.load(getClass().getResource("FXMLPantallaBase.fxml"));
        
            Scene scene = new Scene(root);
            Stage stage = new Stage();
        
            stage.setScene(scene);
            stage.show();
        
            Stage myStage = (Stage) this.buttonLogIn.getScene().getWindow();
            myStage.close();
        } catch (IOException ex) {
            Logger.getLogger(FXMLPantallaLogInController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @FXML
    private void handleRegistrarseAction(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("FXMLPantallaRegister.fxml"));
        
            Scene scene = new Scene(root);
            Stage stage = new Stage();
        
            stage.setScene(scene);
            stage.show();
        
            Stage myStage = (Stage) this.buttonLogIn.getScene().getWindow();
            myStage.close();
        } catch (IOException ex) {
            Logger.getLogger(FXMLPantallaLogInController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
