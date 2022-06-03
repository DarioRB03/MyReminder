/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package myremote;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author 1erDAM
 */
public class FXMLPantallaTareasController implements Initializable {

    @FXML
    private TableView<PooTarea> tableViewTareas;
    @FXML
    private TextField fieldTextId;
    @FXML
    private Button buttonTareaEditar;
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

    private ObservableList<PooTarea> tareasObservable;
   /* private PooTareaModel tareaModel;
    */    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    int log = MyRemote.getLog();
/*
    tareaModel = new PooTareaModel();
    */
    tareasObservable = FXCollections.observableArrayList();
    /*tareasObservable = tareaModel.getTarea(log);*/
        
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
    private void handleEditarTareaAction(ActionEvent event) {
    }
    
}
