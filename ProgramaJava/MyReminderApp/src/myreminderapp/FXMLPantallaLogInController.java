/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package myreminderapp;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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
import javafx.scene.control.Alert;


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
    
/*
    private PooUsuarioModel pum;*/
    private ArrayList<PooUsuario> arrayUsuarios;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
 /*       pum = new PooUsuarioModel();
        arrayUsuarios = pum.getUsuarios();*/
        arrayUsuarios = new ArrayList<PooUsuario>();
        PooUsuario p = new PooUsuario(1,"Pau","Test","p","23aA");
        PooUsuario p2 = new PooUsuario(2,"Antoni","Test","a","1234");
        arrayUsuarios.add(p);
        arrayUsuarios.add(p2);
    }    

    @FXML
    private void handleIniciarSesionAction(ActionEvent event) {
        
        String nick = fieldTextNick.getText();
        String passwd = fieldTextPasswd.getText();
        boolean logInCorrecto = false;
        for (PooUsuario u : arrayUsuarios){
            if (nick.equals(u.getNick()) && passwd.equals(u.getPassword())){
                logInCorrecto = true;
                MyReminderApp.setLog(u.getIdUsuario());
            }
        }
        
        if (logInCorrecto){
            
            Alert correcto = new Alert(Alert.AlertType.INFORMATION);
            correcto.setHeaderText("OK");
            correcto.setContentText("Inicio de sesión correcto");
            correcto.showAndWait();
            
            
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
            
        } else {
            
            Alert error = new Alert(Alert.AlertType.ERROR);
            error.setHeaderText("ERROR DE INICIO DE SESIÓN");
            error.setContentText("El usuario no existe o las credenciales no coinciden");
            error.showAndWait();
            
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
