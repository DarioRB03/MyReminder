/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package myreminderapp;

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
 * Clase FXML Controller
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
    @FXML
    private ScrollPane scrollPanel;
    
    
    private FullModulosView fmv;
    private int log;

    private PooTareaModel ptm;
    private PooEventoModel pem;
    private ArrayList<PooTarea> arrayTareas;
    private ArrayList<PooEvento> arrayEventos;
    
    
    /**
     * Nos muestra un grid panel con modulos scrolleable, se pueden crear nuevos modulos y ver los ya creados
     * Podemos elegir si ver entre tareas o eventos cercanos
     * Inicializa la clase controller
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //Obterner el ID de usuario de las estáticas
        log=MyReminderApp.getLog();
        
        //Se crean los models
        ptm = new PooTareaModel();
        pem = new PooEventoModel();
        
        //Se crea el VBox de modulos, se ajusta al tamaño y se añade al panel dentro del scroll panel
        fmv = new FullModulosView();
        this.modulosPane.setPrefHeight(this.scrollPanel.getPrefHeight() -600 + fmv.getAlongar());
        this.modulosPane.getChildren().add(fmv.getView());
        
        //Vaciamos los campos del listado de tareas y eventos cercanos
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

    /**
     * Muestra las tareas cercanas
     * @param event 
     */
    @FXML
    private void handleTareasCercanasAction(ActionEvent event) {
        //Obtener el array de tareas cercanas de la base de datos
        arrayTareas=ptm.getTareasCerca(log);
        
        //Dependiendo del tamaño del array, se añaden las tareas a el listado
        if (arrayTareas.size()==1){
        
            nombrePanel1.setText(arrayTareas.get(0).getTitulo());
            textFieldDescripcion1.setText(arrayTareas.get(0).getDescripcion());
            labelFecha1.setText(arrayTareas.get(0).getFecha());
        } else if (arrayTareas.size()==2){
            
            nombrePanel1.setText(arrayTareas.get(0).getTitulo());
            textFieldDescripcion1.setText(arrayTareas.get(0).getDescripcion());
            labelFecha1.setText(arrayTareas.get(0).getFecha());
            
            nombrePanel2.setText(arrayTareas.get(1).getTitulo());
            textFieldDescripcion2.setText(arrayTareas.get(1).getDescripcion());
            labelFecha2.setText(arrayTareas.get(1).getFecha());
        } else if (arrayTareas.size()==3){
            
            nombrePanel1.setText(arrayTareas.get(0).getTitulo());
            textFieldDescripcion1.setText(arrayTareas.get(0).getDescripcion());
            labelFecha1.setText(arrayTareas.get(0).getFecha());
            
            nombrePanel2.setText(arrayTareas.get(1).getTitulo());
            textFieldDescripcion2.setText(arrayTareas.get(1).getDescripcion());
            labelFecha2.setText(arrayTareas.get(1).getFecha());
            
            nombrePanel3.setText(arrayTareas.get(2).getTitulo());
            textFieldDescripcion3.setText(arrayTareas.get(2).getDescripcion());
            labelFecha3.setText(arrayTareas.get(2).getFecha());
        }
    }

    /**
     * Muestra los eventos cercanos
     * @param event 
     */
    @FXML
    private void handleEventosCercanosAction(ActionEvent event) {
        //Obtener el array de eventos cercanos de la base de datos
        arrayEventos=pem.getEventosCerca(log);
        
        //Dependiendo del tamaño del array, se añaden los eventos a el listado
        if(arrayEventos.size()==1){
        
            nombrePanel1.setText(arrayEventos.get(0).getTitulo());
            textFieldDescripcion1.setText(arrayEventos.get(0).getDescripcion());
            labelFecha1.setText(arrayEventos.get(0).getFechaEvento());
        } else if(arrayEventos.size()==2){
        
            nombrePanel1.setText(arrayEventos.get(0).getTitulo());
            textFieldDescripcion1.setText(arrayEventos.get(0).getDescripcion());
            labelFecha1.setText(arrayEventos.get(0).getFechaEvento());
            
            nombrePanel2.setText(arrayEventos.get(1).getTitulo());
            textFieldDescripcion2.setText(arrayEventos.get(1).getDescripcion());
            labelFecha2.setText(arrayEventos.get(1).getFechaEvento());
        }else if(arrayEventos.size()==3){
        
            nombrePanel1.setText(arrayEventos.get(0).getTitulo());
            textFieldDescripcion1.setText(arrayEventos.get(0).getDescripcion());
            labelFecha1.setText(arrayEventos.get(0).getFechaEvento());
            
            nombrePanel2.setText(arrayEventos.get(1).getTitulo());
            textFieldDescripcion2.setText(arrayEventos.get(1).getDescripcion());
            labelFecha2.setText(arrayEventos.get(1).getFechaEvento());
            
            nombrePanel3.setText(arrayEventos.get(2).getTitulo());
            textFieldDescripcion3.setText(arrayEventos.get(2).getDescripcion());
            labelFecha3.setText(arrayEventos.get(2).getFechaEvento());
        }
    }

    
}
