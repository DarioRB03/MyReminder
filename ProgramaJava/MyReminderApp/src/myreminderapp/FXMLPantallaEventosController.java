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
 * FXML Controller class
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
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        log = MyReminderApp.getLog();
        /*
        eventoModel = new PooEventoModel();*/
        eventosObservable = FXCollections.observableArrayList();
       /*eventosObservable = eventoModel.getEvento(log);*/
        
        PooEvento e1 = new PooEvento(1,1,"a","bb","2022-05-05",1);
        PooEvento e2 = new PooEvento(2,1,"b","bb","2022-08-08",1);
        eventosObservable.add(e1);
        eventosObservable.add(e2);
       
        this.columnaIdModulo.setCellValueFactory(new PropertyValueFactory("IdModulo"));   
        this.columnaIdEvento.setCellValueFactory(new PropertyValueFactory("IdEvento"));
        this.columnaTitulo.setCellValueFactory(new PropertyValueFactory("Titulo"));
        this.columnaDescripcion.setCellValueFactory(new PropertyValueFactory("Descripcion"));
        this.columnaFecha.setCellValueFactory(new PropertyValueFactory("FechaEvento"));
        this.columnaPrioridad.setCellValueFactory(new PropertyValueFactory("Prioridad"));
        
        this.tableViewEventos.setItems(eventosObservable);
        
    }    

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
