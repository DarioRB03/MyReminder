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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author 1erDAM
 */
public class FXMLEditarTareaController implements Initializable {

    @FXML
    private Button buttonAplicar;
    @FXML
    private Button buttonEliminar;
    @FXML
    private ComboBox<?> idModuloComboBox;
    @FXML
    private TextArea DescripTextArea;
    @FXML
    private TextField fechaTxt;
    @FXML
    private Button buttonVolver;
    @FXML
    private ComboBox<?> prioridadComboBox;
    @FXML
    private TextField TituloTareaTxt;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void handleAplicarAction(ActionEvent event) {
    }

    @FXML
    private void handleEliminarAction(ActionEvent event) {
    }

    @FXML
    private void handleVolverAction(ActionEvent event) {
    }
    
}
