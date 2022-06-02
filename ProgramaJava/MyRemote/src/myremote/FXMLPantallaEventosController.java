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
    @FXML
    private TextField fieldTextId;
    @FXML
    private Button buttonEventoEditar;
    
    private PooUsuario usuarioActivo;
    private ObservableList<PooEvento> eventosObservable;
   /* private PooEventoModel eventoModel;*/
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        usuarioActivo = new PooUsuario();/*
        eventoModel = new PooEventoModel();*/
        eventosObservable = FXCollections.observableArrayList();
       /*eventosObservable = eventoModel.getEvento(usuarioActivo.getIdUsuario());*/
        
        this.columnaIdModulo.setCellValueFactory(new PropertyValueFactory("IdModulo"));   
        this.columnaIdEvento.setCellValueFactory(new PropertyValueFactory("IdEvento"));
        this.columnaTitulo.setCellValueFactory(new PropertyValueFactory("Titulo"));
        this.columnaDescripcion.setCellValueFactory(new PropertyValueFactory("Descripcion"));
        this.columnaFecha.setCellValueFactory(new PropertyValueFactory("FechaEvento"));
        this.columnaPrioridad.setCellValueFactory(new PropertyValueFactory("Prioridad"));
        
        this.tableViewEventos.setItems(eventosObservable);
        
    }    

    @FXML
    private void handleEditarEventoAction(ActionEvent event) {
    }
    
}
