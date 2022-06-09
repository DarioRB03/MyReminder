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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author 1erDAM
 */
public class FXMLCrearTareaController implements Initializable {

    @FXML
    private TextField TituloTareaField;
    @FXML
    private Text DescripcionTxt;
    @FXML
    private TextArea DescripTextArea;
    @FXML
    private Text ModuloTxt;
    @FXML
    private ComboBox<?> ModuloComboBox;
    @FXML
    private Button buttonCrear;
    @FXML
    private Button buttonVolver;
    @FXML
    private ComboBox<?> prioridadComboBox;
    @FXML
    private Text AltoTxt;
    @FXML
    private Text fechaTxt;
    @FXML
    private ComboBox<?> añoComboBox;
    @FXML
    private ComboBox<?> diaComboBox;
    @FXML
    private ComboBox<?> mesComboBox;
    @FXML
    private Text CrearEventoTxt;
    @FXML
    private Text tituloTxt;
    @FXML
    private Text medioTxt;
    @FXML
    private Text nivelPrioridadTxt;
    @FXML
    private Text bajoTxt;

    private PooTareaModel ptm;
    private PooModuloModel pmm;
    private ArrayList<PooTarea> arrayTareas;
    private ArrayList<PooModulo> arrayModulos;
    private PooTarea tarea;
    private int log;
    
    private ObservableList yearList = FXCollections.observableArrayList();
    private ObservableList monthList = FXCollections.observableArrayList();
    private ObservableList dayList = FXCollections.observableArrayList();
    private ObservableList moduloList = FXCollections.observableArrayList();
    private ObservableList prioridadList = FXCollections.observableArrayList();
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        log = MyReminderApp.getLog();
        tarea = new PooTarea();
        /*
        ptm = new PooTareaModel();
        arrayTareas = ptm.getTareasDeUsuario(log);
        pmm = new PooModuloModel();
        arrayModulos = pmm.getModulosDeUsuario(log);*/
        
        
        arrayTareas = new ArrayList<PooTarea>();
        PooTarea tarTest = new PooTarea();
        arrayTareas.add(tarTest);
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
        
        for (PooModulo m : arrayModulos){
            String idM = String.valueOf(m.getIdModulo());
            moduloList.add(idM);
        }
        ModuloComboBox.setItems(moduloList);
        
        for (int i=0; i<3; i++){
            String prio = String.valueOf(i+1);
            prioridadList.add(prio);
        }
        prioridadComboBox.setItems(prioridadList);
        
        for (int i=0; i<31; i++){
            String dia = String.valueOf(i+1);
            dayList.add(dia);
        }
        diaComboBox.setItems(dayList);
        
        for (int i=0; i<12; i++){
            String mes = String.valueOf(i+1);
            monthList.add(mes);
        }
        mesComboBox.setItems(monthList);
        
        for (int i=1999; i<2100; i++){
            String ano = String.valueOf(i+1);
            yearList.add(ano);
        }
        añoComboBox.setItems(yearList);
    }    

    @FXML
    private void handleCrearAction(ActionEvent event) {
        tarea.setIdTarea(arrayTareas.size()+1);
        
        tarea.setIdModulo(Integer.parseInt(ModuloComboBox.getValue().toString()));
        
        tarea.setTitulo(TituloTareaField.getText());
        
        tarea.setDescripcion(DescripTextArea.getText());
        
        tarea.setFecha(añoComboBox.getValue().toString() + "-" + mesComboBox.getValue().toString() +"-" + diaComboBox.getValue().toString());
        
        tarea.setRealizado(0);
        
        tarea.setPrioridad(Integer.parseInt(prioridadComboBox.getValue().toString()));
        /*
        ptm.editarTarea(tarea.getIdTarea(), tarea.getIdModulo(), tarea.getTitulo(), tarea.getDescripcion(), tarea.getFecha(), tarea.getPrioridad(), tarea.getRealizado());*/
        
        
        Alert alertaInfo = new Alert(Alert.AlertType.INFORMATION);
        alertaInfo.setHeaderText("TAREA CREADA");
        alertaInfo.setContentText("idTarea: " + tarea.getIdTarea() + "\nidModulo: " + tarea.getIdModulo() + "\nTitulo: " + tarea.getTitulo() + "\nDesc-: " + tarea.getDescripcion() + "\nFecha: " + tarea.getFecha() + "\nPrio: " + tarea.getPrioridad() + "\nNO REALIZADA");
        alertaInfo.showAndWait();
        
        
        try {
            Parent root = FXMLLoader.load(getClass().getResource("FXMLPantallaBase.fxml"));
        
            Scene scene = new Scene(root);
            Stage stage = new Stage();
        
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        
            Stage myStage = (Stage) this.buttonCrear.getScene().getWindow();
            myStage.close();
        } catch (IOException ex) {
            Logger.getLogger(FXMLPantallaLogInController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
