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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Clase FXML Controller
 *
 * @author 1erDAM
 */
public class FXMLCrearModuloController implements Initializable {

    @FXML
    private Text tituloTxt;
    @FXML
    private TextField tituloField;
    @FXML
    private Text CrearModuloTxt;
    @FXML
    private TextField editarPorcField;
    @FXML
    private TextField editarNotaField;
    @FXML
    private Text evaluacionTxt;
    @FXML
    private Text configEvTxt;
    @FXML
    private Text editarPorcTxt;
    @FXML
    private Label editarPorcLabel;
    @FXML
    private Text editarNotaTxt;
    @FXML
    private Button buttonCrear;
    @FXML
    private Text añadirEvTxt;
    @FXML
    private Text añadirPorcTxt;
    @FXML
    private Text añadirNotaTxt;
    @FXML
    private TextField añadirPorcField;
    @FXML
    private TextField añadirNotaField;
    @FXML
    private Label añadirPorcLabel;
    @FXML
    private Button buttonConfirmar;
    @FXML
    private Button buttonAñadir;
    @FXML
    private ComboBox<String> ComboBoxEv;
    @FXML
    private Button buttonVolver;

    private ObservableList listaEv = FXCollections.observableArrayList();
    
    private PooModulo m;
    private ArrayList<PooEvaluacion> arrayEvaluaciones;
    private ArrayList<PooModulo> arrayModulos;
    private PooModuloModel pmm;
    private PooEvaluacionModel pem;
    private int idModulo;
    private int log;
    /**
     * Inicializa la clase controller.
     * Genera las evaluaciones base y su respectivo comboBox
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        log=MyReminderApp.getLog();
        
        pmm = new PooModuloModel();
        pem = new PooEvaluacionModel();
        
        arrayModulos = pmm.getModulos();

        idModulo=arrayModulos.size()+1;

        //Se crean las evaluaciones vacías y se añaden al ComboBox
        arrayEvaluaciones = new ArrayList<PooEvaluacion>();
        /*
        for (PooEvaluacion e : arrayEvaluaciones){
            String numero = String.valueOf(e.getNumEvaluacion());
            listaEv.add(numero);
        }*/
        String num = "1";
        String num2 = "2";
        String num3 = "3";
        listaEv.add(num);
        listaEv.add(num2);
        listaEv.add(num3);
        
        ComboBoxEv.setItems(listaEv);
    }    

    /**
     * Recupera datos de la interfaz y crea un modulo que luego añadiremos a la base de datos
     * @param event 
     */
    @FXML
    private void handleCrearAction(ActionEvent event) {/*Crear modulo*/
        
        m = new PooModulo(idModulo,log,tituloField.getText(),0);
        
        //Agrregar las evaluaciones del modulo a la base de datos
        for(PooEvaluacion e : arrayEvaluaciones){
            pem.agregarEvaluacion(e.getIdModulo(), e.getNumEvaluacion(), e.getPorcentaje(), e.getNota());
        }
        
        //Agregar el modulo a la base de datos
        pmm.agregarModulo(log, m.getTitulo());
        
        try {
            Parent root = FXMLLoader.load(getClass().getResource("FXMLPantallaBase.fxml"));
        
            Scene scene = new Scene(root);
            Stage stage = new Stage();
        
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        
            Stage myStage = (Stage) this.buttonVolver.getScene().getWindow();
            myStage.close();
        } catch (IOException ex) {
            Logger.getLogger(FXMLPantallaLogInController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Confirmar datos de evaluacion. No se añade a la base de datos
     * @param event 
     */
    @FXML
    private void handleConfirmarAction(ActionEvent event) {
        
        int numEv = Integer.parseInt(ComboBoxEv.getValue().toString());
        int porc = Integer.parseInt(editarPorcField.getText());
        int nota = Integer.parseInt(editarNotaField.getText());
        PooEvaluacion ev = new PooEvaluacion(idModulo, numEv, porc, nota);
        arrayEvaluaciones.add(ev);
        
        System.out.println(ev.getIdModulo() + " - " + ev.getNumEvaluacion() + " - " + ev.getPorcentaje() + " - " + ev.getNota());
        
        Alert alertaInfo = new Alert(Alert.AlertType.INFORMATION);
        alertaInfo.setHeaderText("EVALUACION CONFIRMADA");
        alertaInfo.setContentText(ev.getIdModulo() + " - " + ev.getNumEvaluacion() + " - " + ev.getPorcentaje() + " - " + ev.getNota());
        alertaInfo.showAndWait();
    }

    /**
     * Confirmar datos de evaluacion nueva y se añade al array. No se añade a la base de datos
     * @param event 
     */
    @FXML
    private void handleAñadirAction(ActionEvent event) {
        
        int porc = Integer.parseInt(añadirPorcField.getText());
        int nota = Integer.parseInt(añadirNotaField.getText());
        int idEv = listaEv.size()+1;
        PooEvaluacion nueva = new PooEvaluacion(idModulo, idEv, porc, nota);
        
        System.out.println(String.valueOf(nueva.getIdModulo()) + " - " + String.valueOf(nueva.getNumEvaluacion()) + " - " + String.valueOf(nueva.getPorcentaje()) + " - " + String.valueOf(nueva.getNota()));
        
        arrayEvaluaciones.add(nueva);
        listaEv.add(String.valueOf(nueva.getNumEvaluacion()));
        ComboBoxEv.setItems(listaEv);
        
        Alert alertaInfo = new Alert(Alert.AlertType.INFORMATION);
        alertaInfo.setHeaderText("EVALUACION AÑADIDA");
        alertaInfo.setContentText(nueva.getIdModulo() + " - " + nueva.getNumEvaluacion() + " - " + nueva.getPorcentaje() + " - " + nueva.getNota());
        alertaInfo.showAndWait();
    }

    /**
     * Volver a la pantalla base
     * @param event 
     */
    @FXML
    private void handleVolverAction(ActionEvent event) {
       
        try {
            Parent root = FXMLLoader.load(getClass().getResource("FXMLPantallaBase.fxml"));
        
            Scene scene = new Scene(root);
            Stage stage = new Stage();
        
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        
            Stage myStage = (Stage) this.buttonVolver.getScene().getWindow();
            myStage.close();
        } catch (IOException ex) {
            Logger.getLogger(FXMLPantallaLogInController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
