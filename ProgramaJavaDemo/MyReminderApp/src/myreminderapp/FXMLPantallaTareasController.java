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
public class FXMLPantallaTareasController implements Initializable {

    @FXML
    private TableView<PooTarea> tableViewTareas;
    @FXML
    private TableColumn<?, ?> columnaIdModulo;
    @FXML
    private TableColumn<?, ?> columnaIdTarea;
    @FXML
    private TableColumn<?, ?> columnaTitulo;
    @FXML
    private TableColumn<?, ?> columnaDescripcion;
    @FXML
    private TableColumn<?, ?> columnaFecha;
    @FXML
    private TableColumn<?, ?> columnaPrioridad;
    @FXML
    private TableColumn<?, ?> columnaRealizado;
    @FXML
    private Button buttonTareaCrear;
    
    
    private ObservableList<PooTarea> tareasObservable;
    private int log;
    private PooTareaModel tareaModel;
      
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    log = MyReminderApp.getLog();
    
/*
    tareaModel = new PooTareaModel();
    */
    tareasObservable = FXCollections.observableArrayList();/*
    tareasObservable = tareaModel.getTarea(log);*/
    
    PooTarea t1 = new PooTarea(1, 2, "", "", "", 1, 0);
    PooTarea t2 = new PooTarea(2, 2, "", "", "", 3, 1);
    tareasObservable.add(t1);
    tareasObservable.add(t2);
    
    this.columnaIdModulo.setCellValueFactory(new PropertyValueFactory("IdModulo"));   
    this.columnaIdTarea.setCellValueFactory(new PropertyValueFactory("IdTarea"));
    this.columnaTitulo.setCellValueFactory(new PropertyValueFactory("Titulo"));
    this.columnaDescripcion.setCellValueFactory(new PropertyValueFactory("Descripcion"));
    this.columnaFecha.setCellValueFactory(new PropertyValueFactory("Fecha"));
    this.columnaPrioridad.setCellValueFactory(new PropertyValueFactory("Prioridad"));
    this.columnaRealizado.setCellValueFactory(new PropertyValueFactory("Realizado"));
     
    this.tableViewTareas.setItems(tareasObservable);
        
        
        
    }    

    @FXML
    private void handleCrearTareaAction(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("FXMLCrearTarea.fxml"));
        
            Scene scene = new Scene(root);
            Stage stage = new Stage();
        
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        
            Stage myStage = (Stage) this.buttonTareaCrear.getScene().getWindow();
            myStage.close();
        } catch (IOException ex) {
            Logger.getLogger(FXMLPantallaLogInController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void handleVerTareaClick(MouseEvent event) {
        if (event.getButton().equals(MouseButton.PRIMARY) && event.getClickCount()==2){
            PooTarea t = this.tableViewTareas.getSelectionModel().getSelectedItem();
            MyReminderApp.setIdTarVer(t.getIdTarea());
            
            try {
                Parent root = FXMLLoader.load(getClass().getResource("FXMLVerTarea.fxml"));
        
                Scene scene = new Scene(root);
                Stage stage = new Stage();
        
                stage.setScene(scene);
                stage.setResizable(false);
                stage.show();
        
                Stage myStage = (Stage) this.tableViewTareas.getScene().getWindow();
                myStage.close();
            } catch (IOException ex) {
                Logger.getLogger(FXMLPantallaLogInController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
