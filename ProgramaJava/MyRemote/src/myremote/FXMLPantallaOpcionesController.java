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
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class
 *
 * @author 1erDAM
 */
public class FXMLPantallaOpcionesController implements Initializable {

    @FXML
    private RadioButton radioClaro;
    @FXML
    private ToggleGroup radio;
    @FXML
    private RadioButton radioOscuro;
    @FXML
    private Slider sliderTema;
    @FXML
    private CheckBox checkBoxNotificaciones;
    @FXML
    private ChoiceBox<?> choiceBoxNotificaciones;
    @FXML
    private Button buttonSalir;
    @FXML
    private Hyperlink linkTyC;
    @FXML
    private Hyperlink linkSobreNosotros;
    @FXML
    private Button buttonReestablecer;
    @FXML
    private Hyperlink linkAyuda;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleTemaClaro(ActionEvent event) {
    }

    @FXML
    private void handleTemaOscuro(ActionEvent event) {
    }

    @FXML
    private void handleCheckNotificaciones(ActionEvent event) {
    }

    @FXML
    private void handleSalirAction(ActionEvent event) {
        
    }

    @FXML
    private void handleLinkTyC(ActionEvent event) {
    }

    @FXML
    private void handleLinkSobreNosotros(ActionEvent event) {
    }

    @FXML
    private void handleReestablecerAction(ActionEvent event) {
    }

    @FXML
    private void handleLinkAyuda(ActionEvent event) {
    }
    
}
