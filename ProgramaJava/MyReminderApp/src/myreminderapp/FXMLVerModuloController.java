/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package myreminderapp;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author 1erDAM
 */
public class FXMLVerModuloController implements Initializable {

    @FXML
    private Text IdTxt;
    @FXML
    private Text DescripTxt;
    @FXML
    private Text TituloTxt;
    @FXML
    private Text ModuloTxt;
    @FXML
    private Button buttonEditar;
    @FXML
    private Label IdLabel;
    @FXML
    private Label TituloLabel;
    @FXML
    private Button buttonVolver;
    @FXML
    private Text evaluacionesTxt;
    @FXML
    private Label evaluacionesLabel;
    @FXML
    private Text notaTxt;
    @FXML
    private Label notaLabel;
    @FXML
    private TableView<?> evTableView;
    @FXML
    private TableColumn<?, ?> NumColumn;
    @FXML
    private TableColumn<?, ?> porcColumn;
    @FXML
    private TableColumn<?, ?> NotaColumn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleEditarAction(ActionEvent event) {
    }

    @FXML
    private void handleVolverAction(ActionEvent event) {
    }
    
}
