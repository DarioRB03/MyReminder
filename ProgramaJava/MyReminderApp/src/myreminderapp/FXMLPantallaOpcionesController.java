/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package myreminderapp;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author 1erDAM
 */
public class FXMLPantallaOpcionesController implements Initializable {

    @FXML
    private Hyperlink linkTyC;
    @FXML
    private Hyperlink linkSobreNosotros;
    @FXML
    private Hyperlink linkAyuda;
    @FXML
    private AnchorPane pane;
    @FXML
    private Button buttonCerrarSesion;
    @FXML
    private Button buttonSalir;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO 
        
    }    

    @FXML
    private void handleSalirAction(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    private void handelCerrarSesion(ActionEvent event) {
        try {
                Parent root = FXMLLoader.load(getClass().getResource("FXMLPantallaLogIn.fxml"));
        
                Scene scene = new Scene(root);
                Stage stage = new Stage();
        
                stage.setScene(scene);
                stage.setResizable(false);
                stage.show();
            
                Stage myStage = (Stage) this.buttonCerrarSesion.getScene().getWindow();
                myStage.close();
            } catch (IOException ex) {
                Logger.getLogger(FXMLPantallaLogInController.class.getName()).log(Level.SEVERE, null, ex);
            }
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
    private void handlelinkLogo(MouseEvent event) {
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
