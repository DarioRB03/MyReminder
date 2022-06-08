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
 * Clase FXML Controller
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
    

    private PooUsuarioModel pum;
    private ArrayList<PooUsuario> arrayUsuarios;
    /**
     * Inicializa la clase controller
     * Se muestra la pantalla de inicio de sesión
     * Pide nick y contraseña
     * Boton de inicio de sesión y de registro
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //Se obtienen los usuarios de la base de datos y se meten en un ArrayList
        pum = new PooUsuarioModel();
        arrayUsuarios = pum.getUsuarios();
    }    

    /**
     * Obtiene los datos de la interfaz y se comprueba que el nick y el usuario coincidan, 
     * estableciendo una booleana a true y dando valor a la estática de id de usuario (log)
     * @param event 
     */
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
            //Si la booleana es correcta nos salta un alert de OK y nos lleva a la pantalla base
            
            Alert correcto = new Alert(Alert.AlertType.INFORMATION);
            correcto.setHeaderText("OK");
            correcto.setContentText("Inicio de sesión correcto");
            correcto.showAndWait();
            
            
            try {
            Parent root = FXMLLoader.load(getClass().getResource("FXMLPantallaBase.fxml"));
        
            Scene scene = new Scene(root);
            Stage stage = new Stage();
        
                stage.setScene(scene);
                stage.setResizable(false);
                stage.show();
        
                Stage myStage = (Stage) this.buttonLogIn.getScene().getWindow();
                myStage.close();
            } catch (IOException ex) {
                Logger.getLogger(FXMLPantallaLogInController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        } else {
            //Si la booleana es incorrecta nos salta un error de inicio de sesion
            
            Alert error = new Alert(Alert.AlertType.ERROR);
            error.setHeaderText("ERROR DE INICIO DE SESIÓN");
            error.setContentText("El usuario no existe o las credenciales no coinciden");
            error.showAndWait();
            
        }
        
        
    }

    /**
     * Nos lleva a la página de registro
     * @param event 
     */
    @FXML
    private void handleRegistrarseAction(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("FXMLPantallaRegister.fxml"));
        
            Scene scene = new Scene(root);
            Stage stage = new Stage();
        
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        
            Stage myStage = (Stage) this.buttonLogIn.getScene().getWindow();
            myStage.close();
        } catch (IOException ex) {
            Logger.getLogger(FXMLPantallaLogInController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
