/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package myreminderapp;

import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * Clase FXML Controller
 *
 * @author 1erDAM
 */
public class FXMLPantallaEventosController implements Initializable {

    @FXML
    private TableView<PooEvento> tableViewEventos;
    @FXML
    private TableColumn<?, ?> columnaIdModulo;
    @FXML
    private TableColumn<?, ?> columnaIdEvento;
    @FXML
    private TableColumn<?, ?> columnaTitulo;
    @FXML
    private TableColumn<?, ?> columnaDescripcion;
    @FXML
    private TableColumn<?, ?> columnaFecha;
    @FXML
    private TableColumn<?, ?> columnaPrioridad;
    
    private int log;
    private ObservableList<PooEvento> eventosObservable;
    private PooEventoModel eventoModel;
    @FXML
    private Button buttonEventoCrear;
    /**
     * Inicializa la clase controller
     * Nos muestra una tabla con los eventos del usuario a los cuales se puede acceder
     * y un botón para crear un evento nuevo
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Recuper el ID de usuario activo de las estáticas
        log = MyReminderApp.getLog();
        
        //Crear el model y la lista observable para el tableview, se añaden los objetos del model a la lista
        eventoModel = new PooEventoModel();
        eventosObservable = FXCollections.observableArrayList();
        eventosObservable = eventoModel.getEvento(log);
        
       
        this.columnaIdModulo.setCellValueFactory(new PropertyValueFactory("IdModulo"));   
        this.columnaIdEvento.setCellValueFactory(new PropertyValueFactory("IdEvento"));
        this.columnaTitulo.setCellValueFactory(new PropertyValueFactory("Titulo"));
        this.columnaDescripcion.setCellValueFactory(new PropertyValueFactory("Descripcion"));
        this.columnaFecha.setCellValueFactory(new PropertyValueFactory("FechaEvento"));
        this.columnaPrioridad.setCellValueFactory(new PropertyValueFactory("Prioridad"));
        
        //Se añade la lista a la tabla
        this.tableViewEventos.setItems(eventosObservable);
        
    }    

    /**
     * Nos lleva a la página de creación de evento
     * @param event 
     */
    @FXML
    private void handleCrearEventoAction(ActionEvent event) {
        
        try {
            Parent root = FXMLLoader.load(getClass().getResource("FXMLCrearEvento.fxml"));
        
            Scene scene = new Scene(root);
            Stage stage = new Stage();
        
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        
            Stage myStage = (Stage) this.buttonEventoCrear.getScene().getWindow();
            myStage.close();
        } catch (IOException ex) {
            Logger.getLogger(FXMLPantallaLogInController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Al hacer doble click en un evento de la tabla, nos lleva a la página de ver dicho evento
     * @param event 
     */
    @FXML
    private void handleVerEventoClick(MouseEvent event) {
        
         if (event.getButton().equals(MouseButton.PRIMARY) && event.getClickCount()==2){
            PooEvento e = this.tableViewEventos.getSelectionModel().getSelectedItem();
            MyReminderApp.setIdEveVer(e.getIdEvento());
            
            try {
                Parent root = FXMLLoader.load(getClass().getResource("FXMLVerEvento.fxml"));
        
                Scene scene = new Scene(root);
                Stage stage = new Stage();
        
                stage.setScene(scene);
                stage.setResizable(false);
                stage.show();
        
                Stage myStage = (Stage) this.tableViewEventos.getScene().getWindow();
                myStage.close();
            } catch (IOException ex) {
                Logger.getLogger(FXMLPantallaLogInController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
