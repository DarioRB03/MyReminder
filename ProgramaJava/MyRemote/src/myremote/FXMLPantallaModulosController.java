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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author 1erDAM
 */
public class FXMLPantallaModulosController implements Initializable {

    @FXML
    private Button botonTareasCercanas;
    @FXML
    private Button botonEventosCercanos;
    @FXML
    private Pane panel1;
    @FXML
    private Label nombrePanel1;
    @FXML
    private TextField textFieldDescripcion1;
    @FXML
    private Text labelFecha1;
    @FXML
    private Pane panel2;
    @FXML
    private Label nombrePanel2;
    @FXML
    private TextField textFieldDescripcion2;
    @FXML
    private Text labelFecha2;
    @FXML
    private Pane panel3;
    @FXML
    private Label nombrePanel3;
    @FXML
    private TextField textFieldDescripcion3;
    @FXML
    private Text labelFecha3;
    @FXML
    private Button buttonCrearModulo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleTareasCercanasAction(ActionEvent event) {
    }

    @FXML
    private void handleEventosCercanosAction(ActionEvent event) {
    }

    @FXML
    private void handleCrearModuloAction(ActionEvent event) {
    }
    
}
