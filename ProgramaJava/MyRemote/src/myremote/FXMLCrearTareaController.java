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
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author 1erDAM
 */
public class FXMLCrearTareaController implements Initializable {

    @FXML
    private Text CrearTareaTxt;
    @FXML
    private Text TituloTxt;
    @FXML
    private TextField TituloTareaField;
    @FXML
    private Text DescripcionTxt;
    @FXML
    private TextArea DescripTextArea;
    @FXML
    private Text ModuloTxt;
    @FXML
    private ComboBox<?> ModuloComboBox;
    @FXML
    private Button buttonCrear;
    @FXML
    private Button buttonVolver;
    @FXML
    private Text MedioTxt;
    @FXML
    private ComboBox<?> prioridadComboBox;
    @FXML
    private Text PrioridadTxt;
    @FXML
    private Text AltoTxt;
    @FXML
    private Text BajoTxt;
    @FXML
    private Text fechaTxt;
    @FXML
    private ComboBox<?> añoComboBox;
    @FXML
    private ComboBox<?> diaComboBox;
    @FXML
    private ComboBox<?> mesComboBox;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleCrearAction(ActionEvent event) {
    }

    @FXML
    private void handleVolverAction(ActionEvent event) {
    }
    
}
