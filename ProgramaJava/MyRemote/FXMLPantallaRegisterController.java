/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package myremote;

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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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
        try {
            Parent root = FXMLLoader.load(getClass().getResource("FXMLPantallaLogIn.fxml"));
        
            Scene scene = new Scene(root);
            Stage stage = new Stage();
        
            stage.setScene(scene);
            stage.show();
        
            Stage myStage = (Stage) this.buttonRegistrarse.getScene().getWindow();
            myStage.close();
        } catch (IOException ex) {
            Logger.getLogger(FXMLPantallaLogInController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void handleVolverAction(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("FXMLPantallaLogIn.fxml"));
        
            Scene scene = new Scene(root);
            Stage stage = new Stage();
        
            stage.setScene(scene);
            stage.show();
        
            Stage myStage = (Stage) this.buttonRegistrarse.getScene().getWindow();
            myStage.close();
        } catch (IOException ex) {
            Logger.getLogger(FXMLPantallaLogInController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
