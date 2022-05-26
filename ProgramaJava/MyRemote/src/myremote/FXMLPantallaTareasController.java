/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package myremote;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author 1erDAM
 */
public class FXMLPantallaTareasController implements Initializable {

    @FXML
    private TableView<?> tableViewTareas;
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleEditarTareaAction(ActionEvent event) {
    }
    
}
