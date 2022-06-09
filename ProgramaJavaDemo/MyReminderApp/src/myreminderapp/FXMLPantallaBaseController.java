/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package myreminderapp;

import javafx.scene.paint.Paint;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author 1erDAM
 */
public class FXMLPantallaBaseController implements Initializable {

    

    @FXML
    private Button buttonModulos;
    @FXML
    private Button buttonTareas;
    @FXML
    private Button buttonEventos;
    @FXML
    private Button buttonCalendario;
    @FXML
    private Button buttonOpciones;
    @FXML
    private AnchorPane rootPane;
    
    private int log;
    private Paint activeButtonPaint;
    private Paint unactiveButtonPaint;
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        log = MyReminderApp.getLog();
        System.out.println(log);
        activeButtonPaint = Paint.valueOf("#00f");
        unactiveButtonPaint = Paint.valueOf("#000");
        
        buttonModulos.setTextFill(unactiveButtonPaint);
        buttonTareas.setTextFill(unactiveButtonPaint);
        buttonEventos.setTextFill(unactiveButtonPaint);
        buttonCalendario.setTextFill(unactiveButtonPaint);
        buttonOpciones.setTextFill(activeButtonPaint);
        
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("FXMLPantallaOpciones.fxml"));
            this.rootPane.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(FXMLPantallaBaseController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void modulosPageAction(ActionEvent event) {
        buttonModulos.setTextFill(activeButtonPaint);
        buttonTareas.setTextFill(unactiveButtonPaint);
        buttonEventos.setTextFill(unactiveButtonPaint);
        buttonCalendario.setTextFill(unactiveButtonPaint);
        buttonOpciones.setTextFill(unactiveButtonPaint);
         
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("FXMLPantallaModulos.fxml"));
            this.rootPane.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(FXMLPantallaBaseController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void tareasPageAction(ActionEvent event) {
        buttonModulos.setTextFill(unactiveButtonPaint);
        buttonTareas.setTextFill(activeButtonPaint);
        buttonEventos.setTextFill(unactiveButtonPaint);
        buttonCalendario.setTextFill(unactiveButtonPaint);
        buttonOpciones.setTextFill(unactiveButtonPaint);
        
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("FXMLPantallaTareas.fxml"));
            this.rootPane.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(FXMLPantallaBaseController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void eventosPageAction(ActionEvent event) {
        buttonModulos.setTextFill(unactiveButtonPaint);
        buttonTareas.setTextFill(unactiveButtonPaint);
        buttonEventos.setTextFill(activeButtonPaint);
        buttonCalendario.setTextFill(unactiveButtonPaint);
        buttonOpciones.setTextFill(unactiveButtonPaint);
        
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("FXMLPantallaEventos.fxml"));
            this.rootPane.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(FXMLPantallaBaseController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void calendarioPageAction(ActionEvent event) {
        buttonModulos.setTextFill(unactiveButtonPaint);
        buttonTareas.setTextFill(unactiveButtonPaint);
        buttonEventos.setTextFill(unactiveButtonPaint);
        buttonCalendario.setTextFill(activeButtonPaint);
        buttonOpciones.setTextFill(unactiveButtonPaint);
        
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("FXMLPantallaCalendario.fxml"));
            this.rootPane.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(FXMLPantallaBaseController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void opcionesPageAction(ActionEvent event) {
        buttonModulos.setTextFill(unactiveButtonPaint);
        buttonTareas.setTextFill(unactiveButtonPaint);
        buttonEventos.setTextFill(unactiveButtonPaint);
        buttonCalendario.setTextFill(unactiveButtonPaint);
        buttonOpciones.setTextFill(activeButtonPaint);
        
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("FXMLPantallaOpciones.fxml"));
            this.rootPane.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(FXMLPantallaBaseController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
