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
public class FXMLEditarModuloController implements Initializable {

    @FXML
    private Text tituloTxt;
    @FXML
    private Text editarPorcTxt;/**/
    @FXML
    private Text editarNotaTxt;/**/
    @FXML
    private Label editarPorcLabel;
    @FXML
    private Text añadirPorcTxt;/**/
    @FXML
    private Text añadirNotaTxt;/**/
    @FXML
    private Label añadirPorcLabel;
    @FXML
    private Button buttonConfirmar;/**/
    @FXML
    private Button buttonAñadir;/**/
    @FXML
    private ComboBox<String> ComboBoxEv;/**/
    @FXML
    private Button buttonVolver;/**/
    
    private ObservableList listaEv = FXCollections.observableArrayList();
    
    private ArrayList<PooModulo> arrayModulos;
    private ArrayList<PooEvaluacion> arrayEvaluaciones;
    private PooEvaluacionModel pem;
    private PooModuloModel pmm;
    private int idModulo;
    private int log;
    private PooModulo modulo;
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
    private Text añadirEvTxt;
    @FXML
    private TextField añadirPorcField;
    @FXML
    private TextField añadirNotaField;
    @FXML
    private Button buttonAplicar1;
    @FXML
    private Button buttonEliminar1;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        idModulo=MyReminderApp.getIdModVer();
        log=MyReminderApp.getLog();
        System.out.println(idModulo + " - " + log);
        
        
        arrayModulos = new ArrayList<PooModulo>();
        arrayEvaluaciones = new ArrayList<PooEvaluacion>();
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
        PooEvaluacion evaTest = new PooEvaluacion(1,1,30,5);
        PooEvaluacion evaTest2 = new PooEvaluacion(1,2,30,4);
        PooEvaluacion evaTest3 = new PooEvaluacion(1,3,40,7);
        arrayEvaluaciones.add(evaTest);
        arrayEvaluaciones.add(evaTest2);
        arrayEvaluaciones.add(evaTest3);
        
        /*
        pem = new PooEvaluacionModel();
        pmm = new PooModuloModel();
        arrayModulos = pmm.getModulosDeUsuario(log);
        arrayEvaluaciones = pem.getEvaluacionDeModulo(idModulo);
        */

        for (PooEvaluacion e : arrayEvaluaciones){
            listaEv.add(String.valueOf(e.getNumEvaluacion()));
        }
        
        
        for (PooModulo m : arrayModulos){
            if(idModulo==m.getIdModulo()){
                modulo = m;
            }
        }

        ComboBoxEv.setItems(listaEv);
    }    

    @FXML
    private void handleAplicarAction(ActionEvent event) {
        /*
        pmm.editarModulo(idModulo, log, tituloTxt.getText());*/
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

    @FXML
    private void handleEliminarAction(ActionEvent event) {/*
        pmm.eliminarModulo(idModulo);*/
        
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
    private void handleConfirmarAction(ActionEvent event) {
        int ind = Integer.parseInt(ComboBoxEv.getValue().toString());
        PooEvaluacion ev = arrayEvaluaciones.get(ind);
        
        float porc = Float.parseFloat(editarPorcTxt.getText());
        float nota = Float.parseFloat(editarNotaTxt.getText());
        
        arrayEvaluaciones.add(ind, ev);/*
        pem.editarEvaluacion(idModulo, ind, porc, nota);*/
    }

    @FXML
    private void handleAñadirAction(ActionEvent event) {
        
        float porc = Float.parseFloat(añadirPorcTxt.getText());
        float nota = Float.parseFloat(añadirNotaTxt.getText());
        int idEv = arrayEvaluaciones.size()+1;
        PooEvaluacion nueva = new PooEvaluacion(idModulo, idEv, porc, nota);
        
        arrayEvaluaciones.add(nueva);
        listaEv.add(String.valueOf(nueva.getNumEvaluacion()));
        ComboBoxEv.setItems(listaEv);/*
        pem.agregarEvaluacion(idModulo, idEv, porc, nota);*/
    }

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
    
    
    private float calcularFinal(ArrayList<PooEvaluacion> arrayEvaluaciones){
        
        float nota = 0;
        
        for (PooEvaluacion e : arrayEvaluaciones){
            nota += e.getNota();
        }
        
        nota/=arrayEvaluaciones.size();
        
        return nota;
    }
    
    private void verEv(){
        int ind = Integer.parseInt(ComboBoxEv.getValue());
        PooEvaluacion ev = arrayEvaluaciones.get(ind);
        editarPorcTxt.setText(String.valueOf(ev.getPorcentaje()));
        editarNotaTxt.setText(String.valueOf(ev.getNota()));
    }
}
