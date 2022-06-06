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
    private int log;
/*
    private PooTareaModel ptm;
    private PooEventoModel pem;*/
    private ArrayList<PooTarea> arrayTareas;
    private ArrayList<PooEvento> arrayEventos;
    @FXML
    private ScrollPane scrollPanel;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        log=MyReminderApp.getLog();
        /*
        ptm = new PooTareaModel();
        pem = new PooEventoModel();
        */
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
        arrayTareas=ptm.getTareasCerca(log);
        */
        arrayTareas = new ArrayList<PooTarea>();
        
        PooTarea t = new PooTarea(1,1,"a","aa","aa",1,0);
        PooTarea t2 = new PooTarea(2,1,"b","bb","bb",1,0);
        PooTarea t3 = new PooTarea(3,1,"c","cc","cc",1,0);
        
        arrayTareas.add(t);
        arrayTareas.add(t2);
        arrayTareas.add(t3);
        
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

    @FXML
    private void handleEventosCercanosAction(ActionEvent event) {
        /*
        arrayEventos=pem.getEventosCerca(log);*/
        arrayEventos = new ArrayList<PooEvento>();
        
        PooEvento e = new PooEvento();
        PooEvento e2 = new PooEvento();
        PooEvento e3 = new PooEvento();
        
        arrayEventos.add(e);
        arrayEventos.add(e2);
        arrayEventos.add(e3);
        
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
