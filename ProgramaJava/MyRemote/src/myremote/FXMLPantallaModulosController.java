/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package myremote;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
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
    private Pane modulosPane;
    
    private FullModulosView fmv;
    private testModulosView tmv;
    private PooUsuario usuarioActivo;/*
    private PooTareaModel ptm;
    private PooEventoModel pem;*/
    private ArrayList<PooTarea> arrayTareas;
    private ArrayList<PooEvento> arrayEventos;
    /* Identificar cual es el usuario activo?? */
    @FXML
    private ScrollPane scrollPanel;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        usuarioActivo = new PooUsuario();
        tmv = new testModulosView();
        this.modulosPane.setPrefHeight(this.scrollPanel.getPrefHeight() -600+ tmv.getAlongar());
        this.modulosPane.getChildren().add(tmv.getView());
        
        nombrePanel1.setText("...");
        textFieldDescripcion1.setText("...");
        labelFecha1.setText("...");
        nombrePanel2.setText("...");
        textFieldDescripcion2.setText("...");
        labelFecha2.setText("...");
        nombrePanel3.setText("...");
        textFieldDescripcion3.setText("...");
        labelFecha3.setText("...");
    }    

    @FXML
    private void handleTareasCercanasAction(ActionEvent event) {
        /*
        arrayTareas=ptm.getTareasCerca(usuarioActivo.getIdUsuario());
        
        PooTarea tarea1 = new PooTarea();
        tarea1 = arrayTareas.get(0);
        PooTarea tarea2 = new PooTarea();
        tarea2 = arrayTareas.get(1);
        PooTarea tarea3 = new PooTarea();
        tarea3 = arrayTareas.get(2);
        
        nombrePanel1.setText(tarea1.getTitulo());
        textFieldDescripcion1.setText(tarea1.getDescripcion());
        labelFecha1.setText(""/*tarea1.getFecha()*//*);
        
        nombrePanel2.setText(tarea2.getTitulo());
        textFieldDescripcion2.setText(tarea2.getDescripcion());
        labelFecha2.setText(""/*tarea1.getFecha()*//*);
        
        nombrePanel3.setText(tarea3.getTitulo());
        textFieldDescripcion3.setText(tarea3.getDescripcion());
        labelFecha3.setText(""/*tarea1.getFecha()*//*);*/
    }

    @FXML
    private void handleEventosCercanosAction(ActionEvent event) {
        /*
        arrayEventos=pem.getEventosCerca(usuarioActivo.getIdUsuario());
        
        PooEvento evento1 = new PooEvento();
        evento1 = arrayEventos.get(0);
        PooEvento evento2 = new PooEvento();
        evento2 = arrayEventos.get(1);
        PooEvento evento3 = new PooEvento();
        evento3 = arrayEventos.get(2);
        
        nombrePanel1.setText(evento1.getTitulo());
        textFieldDescripcion1.setText(evento1.getDescripcion());
        labelFecha1.setText(""/*evento1.getFecha()*//*);
        
        nombrePanel2.setText(evento2.getTitulo());
        textFieldDescripcion2.setText(evento2.getDescripcion());
        labelFecha2.setText(""/*evento2.getFecha()*//*);
        
        nombrePanel3.setText(evento3.getTitulo());
        textFieldDescripcion3.setText(evento3.getDescripcion());
        labelFecha3.setText(""/*evento3.getFecha()*//*);*/
    }

    
}
