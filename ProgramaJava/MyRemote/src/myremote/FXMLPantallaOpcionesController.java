/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package myremote;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
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
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;

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
    @FXML
    private AnchorPane pane;
    @FXML
    private Text TemaTxt;
    @FXML
    private Text TamañoletraTxt;
    @FXML
    private Text NotificacionesTxt;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleTemaClaro(ActionEvent event) {
        RadioButton selectedRadioButton = (RadioButton) radio.getSelectedToggle();
        
        System.out.println(selectedRadioButton.getText());
        
        Paint labelPaint = Paint.valueOf("#000");
        
        this.pane.setStyle("-fx-background-color: #FFF");
        this.TemaTxt.setFill(labelPaint);
        this.TamañoletraTxt.setFill(labelPaint);
        this.NotificacionesTxt.setFill(labelPaint);
        this.botonAcc.setTextFill(labelPaint);
        this.botonAcc.setStyle("-fx-border-color: #0090ff;");
        this.botonCon.setTextFill(labelPaint);
        this.radioClaro.setTextFill(labelPaint);
        this.radioOscuro.setTextFill(labelPaint);
        this.textField1.setStyle("-fx-background-color: #dddddd");
        this.textField2.setStyle("-fx-background-color: #dddddd");
        this.botonTam.setTextFill(labelPaint);
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
        Desktop browser = Desktop.getDesktop();
        try{
            browser.browse(new URI("http://www.google.com"));
        }
        catch(IOException err){
            
        }
        catch(URISyntaxException err){
            
        }
    }

    @FXML
    private void handleLinkSobreNosotros(ActionEvent event) {
        Desktop browser = Desktop.getDesktop();
        try{
            browser.browse(new URI("http://www.google.com"));
        }
        catch(IOException err){
            
        }
        catch(URISyntaxException err){
            
        }
    }

    @FXML
    private void handleReestablecerAction(ActionEvent event) {
    }

    @FXML
    private void handleLinkAyuda(ActionEvent event) {
        Desktop browser = Desktop.getDesktop();
        try{
            browser.browse(new URI("http://www.google.com"));
        }
        catch(IOException err){
            
        }
        catch(URISyntaxException err){
            
        }
    }
    
}
