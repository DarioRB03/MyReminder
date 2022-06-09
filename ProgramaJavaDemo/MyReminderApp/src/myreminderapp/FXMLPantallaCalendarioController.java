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
 * FXML Controller class
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
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        fcv = new FullCalendarView(YearMonth.now());
        this.calenPane.getChildren().add(fcv.getView());
        
    }    
    
}
