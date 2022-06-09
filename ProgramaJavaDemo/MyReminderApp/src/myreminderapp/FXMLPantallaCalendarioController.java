/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package myreminderapp;

import java.net.URL;
import java.time.YearMonth;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * Clase FXML Controller
 *
 * @author 1erDAM
 */
public class FXMLPantallaCalendarioController implements Initializable {

    @FXML
    private AnchorPane calenAnchor;
    @FXML
    private Pane calenPane;
    
    private FullCalendarView fcv;

    /**
     * Inicializa la clase controller
     * Se muestra un calendario funcional autogenerado a través de la clase FullCalendarView
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //Crea el calendario y lo añade al panel de calendario
        fcv = new FullCalendarView(YearMonth.now());
        this.calenPane.getChildren().add(fcv.getView());
        
    }    
    
}
