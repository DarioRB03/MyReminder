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
public class FXMLEditarModuloController implements Initializable {

    
    
    
    @FXML
    private Text tituloTxt;
    @FXML
    private TextField tituloField;
    @FXML
    private Text EditarModuloTxt;
    @FXML
    private TextField editarPorcField;
    @FXML
    private TextField editarNotaField;
    @FXML
    private Text evaluacionTxt;
    @FXML
    private Text EditarEvTxt;
    @FXML
    private Text editarPorcTxt;
    @FXML
    private Label editarPorcLabel;
    @FXML
    private Text editarNotaTxt;
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
    private ComboBox<?> ComboBoxEv;
    @FXML
    private Button buttonVolver;
    @FXML
    private Button buttonAplicar1;
    @FXML
    private Button buttonEliminar1;
    
    
    private PooModulo modulo;
    
    private ObservableList listaEv = FXCollections.observableArrayList();
    
    private ArrayList<PooModulo> arrayModulos;
    private ArrayList<PooEvaluacion> arrayEvaluaciones;
    private PooEvaluacionModel pem;
    private PooModuloModel pmm;
    private int idModulo;
    private int log;
    
    /**
     * Inicializa la clase controller
     * Se generan los comboBox
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //Obtener id de usuario y de modulo a ver desde estáticas
        idModulo=MyReminderApp.getIdModVer();
        log=MyReminderApp.getLog();

        
        pem = new PooEvaluacionModel();
        pmm = new PooModuloModel();
        arrayModulos = pmm.getModulosDeUsuario(log);
        arrayEvaluaciones = pem.getEvaluacionDeModulo(idModulo);
        
        
        //Añadir el array de evaluaciones al ComboBox
        for (PooEvaluacion e : arrayEvaluaciones){
            String numero = String.valueOf(e.getNumEvaluacion());
            listaEv.add(numero);
        }
        
        //Recorre el array de modulos y asigna un objeto modulo coincidente con el idModulo obtenido anteriormente
        for (PooModulo m : arrayModulos){
            if(idModulo==m.getIdModulo()){
                modulo = m;
            }
        }

        //Añadir lista de evaluaciones al ComboBox de evaluaciones
        ComboBoxEv.setItems(listaEv);
    }    

    /**
     * Se leen todos los campos y se asignan al modulo que luego asignamos a la base de datos como editado
     * @param event 
     */
    @FXML
    private void handleAplicarAction(ActionEvent event) {
        
        pmm.editarModulo(idModulo, log, tituloField.getText());
        
        try {
            Parent root = FXMLLoader.load(getClass().getResource("FXMLVerModulo.fxml"));
        
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
     * Se elimina el módulo de la base de datos
     * @param event 
     */
    @FXML
    private void handleEliminarAction(ActionEvent event) {
        
        pmm.eliminarModulo(idModulo);
        
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
     * Confirmar los cambios obtenidos desde la interfaz
     * @param event 
     */
    @FXML
    private void handleConfirmarAction(ActionEvent event) {
        
        int ind = Integer.parseInt(ComboBoxEv.getValue().toString());
        PooEvaluacion ev = arrayEvaluaciones.get(ind);
        
        int porc = Integer.parseInt(editarPorcField.getText());
        int nota = Integer.parseInt(editarNotaField.getText());
        
        ev.setPorcentaje(porc);
        ev.setNota(nota);
        
        //Añadida la evaluacion editada a la base de datos y al array de evaluaciones
        arrayEvaluaciones.add(ind, ev);
        pem.editarEvaluacion(idModulo, ind, porc, nota);
        
        Alert alertaInfo = new Alert(Alert.AlertType.INFORMATION);
        alertaInfo.setHeaderText("EVALUACION CONFIRMADA");
        alertaInfo.setContentText(ev.getIdModulo() + " - " + ev.getNumEvaluacion() + " - " + ev.getPorcentaje() + " - " + ev.getNota());
        alertaInfo.showAndWait();
    }

    /**
     * Se añade una nueva evaluacion al array de evaluaciones
     * @param event 
     */
    @FXML
    private void handleAñadirAction(ActionEvent event) {
        int porc = Integer.parseInt(añadirPorcField.getText());
        int nota = Integer.parseInt(añadirNotaField.getText());
        int idEv = arrayEvaluaciones.size()+1;
        PooEvaluacion nueva = new PooEvaluacion(idModulo, idEv, porc, nota);
        
        //Aádir la nueva evaluacion al array, el array observable, la ComboBox y a la base de datos. Obtenida desde la interfaz
        arrayEvaluaciones.add(nueva);
        listaEv.add(String.valueOf(nueva.getNumEvaluacion()));
        ComboBoxEv.setItems(listaEv);
        pem.agregarEvaluacion(idModulo, idEv, porc, nota);
        
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
            Parent root = FXMLLoader.load(getClass().getResource("FXMLVerModulo.fxml"));
        
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
