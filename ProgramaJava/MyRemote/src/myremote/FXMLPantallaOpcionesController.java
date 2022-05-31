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
import javafx.event.Event;
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
import javafx.scene.text.Font;
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
    @FXML
    private Text aTxt;
    @FXML
    private Text ATxt;
    @FXML
    private Button buttonAplicar;

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
        this.radioClaro.setTextFill(labelPaint);
        this.radioOscuro.setTextFill(labelPaint);
        this.choiceBoxNotificaciones.setStyle("-fx-background-color: #dddddd");
    }

    @FXML
    private void handleTemaOscuro(ActionEvent event) {
        RadioButton selectedRadioButton = (RadioButton) radio.getSelectedToggle();
        
        System.out.println(selectedRadioButton.getText());
        
        Paint labelPaint = Paint.valueOf("#ffffff");
        
        this.pane.setStyle("-fx-background-color: #404040");
        this.TemaTxt.setFill(labelPaint);
        this.TamañoletraTxt.setFill(labelPaint);
        this.NotificacionesTxt.setFill(labelPaint);
        this.aTxt.setFill(labelPaint);
        this.ATxt.setFill(labelPaint);
        this.radioClaro.setTextFill(labelPaint);
        this.radioOscuro.setTextFill(labelPaint);
        this.checkBoxNotificaciones.setTextFill(labelPaint);
        
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

    @FXML
    private void handleAplicarAction(ActionEvent event) {
        double valor = this.sliderTema.getValue();
        
        this.TemaTxt.setFont(Font.font(valor));
        this.TamañoletraTxt.setFont(Font.font(valor));
        this.NotificacionesTxt.setFont(Font.font(valor));
        this.checkBoxNotificaciones.setFont(Font.font(valor));
        this.linkAyuda.setFont(Font.font(valor));
        this.linkSobreNosotros.setFont(Font.font(valor));
        this.linkTyC.setFont(Font.font(valor));
        this.radioClaro.setFont(Font.font(valor));
        this.radioOscuro.setFont(Font.font(valor));
    }

    @FXML
    private void handleSliderTam() {
        double valor = this.sliderTema.getValue();
        
        if (valor==15 || valor==30 || valor==45){
            this.TemaTxt.setFont(Font.font(valor));
        this.TamañoletraTxt.setFont(Font.font(valor));
        this.NotificacionesTxt.setFont(Font.font(valor));
        this.checkBoxNotificaciones.setFont(Font.font(valor));
        this.linkAyuda.setFont(Font.font(valor));
        this.linkSobreNosotros.setFont(Font.font(valor));
        this.linkTyC.setFont(Font.font(valor));
        this.radioClaro.setFont(Font.font(valor));
        this.radioOscuro.setFont(Font.font(valor));
        }
        
    }
    
    
    
}
