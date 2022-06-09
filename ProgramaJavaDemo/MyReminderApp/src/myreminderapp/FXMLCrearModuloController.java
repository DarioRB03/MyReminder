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
 * FXML Controller class
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
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        log=MyReminderApp.getLog();
        /*
        pmm = new PooModuloModel();
        pem = new PooEvaluacionModel();
        
        arrayModulos = pmm.getModulos();*/
        arrayModulos = new ArrayList<PooModulo>();
        PooModulo modTest = new PooModulo(1,1,"Titulo Largo",2);
        PooModulo modTest2 = new PooModulo(2,1,"b",4);
        PooModulo modTest3 = new PooModulo(3,1,"a",2);
        PooModulo modTest4 = new PooModulo(4,1,"b",4);
        PooModulo modTest5 = new PooModulo(5,1,"a",2);
        PooModulo modTest6 = new PooModulo(6,1,"b",4);
        PooModulo modTest7 = new PooModulo(7,1,"b",4);
        PooModulo modTest8 = new PooModulo(8,1,"a",2);
        PooModulo modTest9 = new PooModulo(9,1,"b",4);
        arrayModulos.add(modTest);
        arrayModulos.add(modTest2);
        arrayModulos.add(modTest3);
        arrayModulos.add(modTest4);
        arrayModulos.add(modTest5);
        arrayModulos.add(modTest6);
        arrayModulos.add(modTest7);
        arrayModulos.add(modTest8);
        arrayModulos.add(modTest9);
        idModulo=arrayModulos.size()+1;

        arrayEvaluaciones = new ArrayList<PooEvaluacion>();
        PooEvaluacion ev1 = new PooEvaluacion(idModulo, 1, 0, 0);
        PooEvaluacion ev2 = new PooEvaluacion(idModulo, 2, 0, 0);
        PooEvaluacion ev3 = new PooEvaluacion(idModulo, 3, 0, 0);
        arrayEvaluaciones.add(ev1);
        arrayEvaluaciones.add(ev2);
        arrayEvaluaciones.add(ev3);
        
        for (PooEvaluacion e : arrayEvaluaciones){
            String numero = String.valueOf(e.getNumEvaluacion());
            listaEv.add(numero);
        }
        
        ComboBoxEv.setItems(listaEv);
    }    

    @FXML
    private void handleCrearAction(ActionEvent event) {/*Crear modulo*/
        m = new PooModulo(idModulo,log,tituloField.getText(),0);
        /*
        for(PooEvaluacion e : arrayEvaluaciones){
            pem.agregarEvaluacion(e.getIdModulo(), e.getNumEvaluacion(), e.getPorcentaje(), e.getNota());
        }
        
        pmm.agregarModulo(log, m.getTitulo());*/
        
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

    @FXML
    private void handleConfirmarAction(ActionEvent event) {/*Confirmar datos de evaluacion*/
        int numEv = Integer.parseInt(ComboBoxEv.getValue().toString());
        float porc = Float.parseFloat(editarPorcField.getText());
        float nota = Float.parseFloat(editarNotaField.getText());
        PooEvaluacion ev = new PooEvaluacion(idModulo, numEv, porc, nota);
        arrayEvaluaciones.add(numEv, ev);
        
        System.out.println(ev.getIdModulo() + " - " + ev.getNumEvaluacion() + " - " + ev.getPorcentaje() + " - " + ev.getNota());
        
        Alert alertaInfo = new Alert(Alert.AlertType.INFORMATION);
        alertaInfo.setHeaderText("EVALUACION CONFIRMADA");
        alertaInfo.setContentText(ev.getIdModulo() + " - " + ev.getNumEvaluacion() + " - " + ev.getPorcentaje() + " - " + ev.getNota());
        alertaInfo.showAndWait();
    }

    @FXML
    private void handleAñadirAction(ActionEvent event) {/*Añadir evaluacion*/
        float porc = Float.parseFloat(añadirPorcField.getText());
        float nota = Float.parseFloat(añadirNotaField.getText());
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
