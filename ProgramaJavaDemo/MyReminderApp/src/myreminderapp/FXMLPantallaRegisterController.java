/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package myreminderapp;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
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
/*
    private PooUsuarioModel pum;*/
    private ArrayList<PooUsuario> arrayUsuarios;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
       /* pum = new PooUsuarioModel();
        arrayUsuarios = pum.getUsuarios();*/
        arrayUsuarios = new ArrayList<PooUsuario>();
        PooUsuario p = new PooUsuario(1,"Pau","Test","p","23aA");
        arrayUsuarios.add(p);
    }    

    @FXML
    private void handleRegistrarseAction(ActionEvent event) {
        
        String nick = fillTextNickR.getText();
        String nombre = fillTextNombreR.getText();
        String apellidos = fillTextApellidosR.getText();
        String passwd = fillTextPasswdR.getText();
        boolean nickOk = true;
        boolean nickOk2 = true;
        boolean nombreOk = true;
        boolean apellidoOk = true;
        boolean passwdOk = true;
        
        for (PooUsuario u : arrayUsuarios){
            if (nick.equals(u.getNick())){
                nickOk2 = false;
            }
            if (nick.equals("")){
                nickOk = false;
            }
            if (nombre.equals("")){
                nombreOk = false;
            }
            if (apellidos.equals("")){
                apellidoOk = false;
            }
            if (passwd.equals("")){
                passwdOk = false;
            }
        }
        
        if (!nickOk || !nombreOk || !apellidoOk || !passwdOk) {
            
            Alert error = new Alert(Alert.AlertType.ERROR);
            error.setHeaderText("ERROR DE REGISTRO");
            error.setContentText("Faltan credenciales por rellenar");
            error.showAndWait();
            
        } else if(!nickOk2){
            
            Alert error = new Alert(Alert.AlertType.ERROR);
            error.setHeaderText("ERROR DE REGISTRO");
            error.setContentText("Ya existe un usuario con ese NICK");
            error.showAndWait();
            
        } else {
            
            Alert correcto = new Alert(Alert.AlertType.INFORMATION);
            correcto.setHeaderText("OK");
            correcto.setContentText("Registro completado para el usuario:\n\nNICK:  " + nick + "\nNOMBRE:   " + nombre + "\nAPELLIDOS:  " + apellidos + "\nCONTRASEÑA:  " + passwd);
            correcto.showAndWait();
            /*
            pum.agregarUsuario(nombre, apellidos, nick, passwd);
            */
            try {
                Parent root = FXMLLoader.load(getClass().getResource("FXMLPantallaLogIn.fxml"));
        
                Scene scene = new Scene(root);
                Stage stage = new Stage();
        
                stage.setScene(scene);
                stage.setResizable(false);
                stage.show();
            
                Stage myStage = (Stage) this.buttonRegistrarse.getScene().getWindow();
                myStage.close();
            } catch (IOException ex) {
                Logger.getLogger(FXMLPantallaLogInController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
       
    }

    @FXML
    private void handleVolverAction(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("FXMLPantallaLogIn.fxml"));
        
            Scene scene = new Scene(root);
            Stage stage = new Stage();
        
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        
            Stage myStage = (Stage) this.buttonRegistrarse.getScene().getWindow();
            myStage.close();
        } catch (IOException ex) {
            Logger.getLogger(FXMLPantallaLogInController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
