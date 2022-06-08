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
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Clase FXML Controller
 *
 * @author 1erDAM
 */
public class FXMLCrearEventoController implements Initializable {

    @FXML
    private AnchorPane pane;
    @FXML
    private Text tituloTxt;
    @FXML
    private TextField TituloEventoField;
    @FXML
    private Text DescripcionTxt;
    @FXML
    private TextArea DescripTextArea;
    @FXML
    private Text fechaTxt;
    @FXML
    private Button buttonVolver;
    @FXML
    private Text medioTxt;
    @FXML
    private ComboBox<?> prioridadComboBox;
    @FXML
    private Text nivelPrioridadTxt;
    @FXML
    private Text AltoTxt;
    @FXML
    private Text bajoTxt;
    @FXML
    private ComboBox<?> añoComboBox;
    @FXML
    private ComboBox<?> diaComboBox;
    @FXML
    private ComboBox<?> mesComboBox;
    @FXML
    private Text CrearEventoTxt;
    @FXML
    private Text ModuloTxt;
    @FXML
    private ComboBox<?> ModuloComboBox;
    @FXML
    private Button buttonCrear;

    
    private PooEventoModel pem;
    private PooModuloModel pmm;
    private ArrayList<PooEvento> arrayEventos;
    private ArrayList<PooModulo> arrayModulos;
    private PooEvento evento;
    private int log;
    
    private ObservableList yearList = FXCollections.observableArrayList();
    private ObservableList monthList = FXCollections.observableArrayList();
    private ObservableList dayList = FXCollections.observableArrayList();
    private ObservableList moduloList = FXCollections.observableArrayList();
    private ObservableList prioridadList = FXCollections.observableArrayList();
    
    /**
     * Initializa la clase controller
     * Se generan los comboBox
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //Obtener id de usuario y de evento a ver desde estáticas
        log = MyReminderApp.getLog();
        evento = new PooEvento();
        
        //Crear models y asignados los arrays a los respectivos de la base de datos
        pem = new PooEventoModel();
        arrayEventos = pem.getEventosDeUsuario(log);
        pmm = new PooModuloModel();
        arrayModulos = pmm.getModulosDeUsuario(log);
        
        
        //Añadir el array de módulos al ComboBox de IDs de módulos
        for (PooModulo m : arrayModulos){
            String idM = String.valueOf(m.getIdModulo());
            moduloList.add(idM);
        }
        ModuloComboBox.setItems(moduloList);
        
        //Añadir las 3 prioridades al ComboBox de prioridades
        for (int i=0; i<3; i++){
            String prio = String.valueOf(i+1);
            prioridadList.add(prio);
        }
        prioridadComboBox.setItems(prioridadList);
        
        //Añadir 31 días al ComboBox de días
        for (int i=0; i<31; i++){
            String dia = String.valueOf(i+1);
            dayList.add(dia);
        }
        diaComboBox.setItems(dayList);
        
        //Añadir 12 meses al ComboBox de meses
        for (int i=0; i<12; i++){
            String mes = String.valueOf(i+1);
            monthList.add(mes);
        }
        mesComboBox.setItems(monthList);
        
        //Añadidos desde el año 2000 al 2100 al ComboBox de años
        for (int i=1999; i<2100; i++){
            String ano = String.valueOf(i+1);
            yearList.add(ano);
        }
        añoComboBox.setItems(yearList);
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

    /**
     * Se leen todos los campos y se asignan al evento que luego asignamos a la base de datos como editado
     * @param event 
     */
    @FXML
    private void handleCrearAction(ActionEvent event) {
        
        evento.setIdEvento(arrayEventos.size()+1);
        
        evento.setIdModulo(Integer.parseInt(ModuloComboBox.getValue().toString()));
        
        evento.setTitulo(TituloEventoField.getText());
        
        evento.setDescripcion(DescripTextArea.getText());
        
        evento.setFechaEvento(añoComboBox.getValue().toString() + "-" + mesComboBox.getValue().toString() +"-" + diaComboBox.getValue().toString());
        
        evento.setPrioridad(Integer.parseInt(prioridadComboBox.getValue().toString()));
        
        pem.agregarEvento(evento.getIdModulo(), evento.getTitulo(), evento.getDescripcion(), evento.getFechaEvento(), evento.getPrioridad());
        
        
        Alert alertaInfo = new Alert(Alert.AlertType.INFORMATION);
        alertaInfo.setHeaderText("EVENTO CREADO");
        alertaInfo.setContentText("idEvento: " + evento.getIdEvento()+ "\nidModulo: " + evento.getIdModulo() + "\nTitulo: " + evento.getTitulo() + "\nDesc-: " + evento.getDescripcion() + "\nFecha: " + evento.getFechaEvento()+ "\nPrio: " + evento.getPrioridad());
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
    
}
