/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package myreminderapp;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Clase FXML Controller 
 *
 * @author 1erDAM
 */
public class FXMLVerEventoController implements Initializable {

    @FXML
    private Button buttonEditar;
    @FXML
    private TextArea DescripLabel;
    @FXML
    private Text IdTxt;
    @FXML
    private Text PrioridadTxt;
    @FXML
    private Text DescripTxt;
    @FXML
    private Text FechaTxt;
    @FXML
    private Text TituloTxt;
    @FXML
    private Text ModuloTxt;
    @FXML
    private Text EventoTxt;
    @FXML
    private Label IdLabel;
    @FXML
    private Label TituloLabel;
    @FXML
    private Label ModuloLabel;
    @FXML
    private Label FechaLabel;
    @FXML
    private Label PrioridadLabel;
    @FXML
    private Button buttonVolver;

    private int idEvVer;
    private int log;
    private PooEventoModel eventoModel;
    private ArrayList<PooEvento> arrayEventos;
    private PooEvento evento;
    private PooModuloModel moduloModel;
    private ArrayList<PooModulo> arrayModulos;
    private PooModulo modulo;
    
    /**
     * Muestra los datos del evento seleccionado
     * Inicializar la clase controller
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Obtener id de usuario y de evento a ver desde estáticas, se crean un evento y un modulo bases
        log=MyReminderApp.getLog();
        idEvVer=MyReminderApp.getIdEveVer();
        
        evento = new PooEvento();
        modulo = new PooModulo();
        
        //Se establecen los models y se obtienen los arrays
        eventoModel = new PooEventoModel();
        arrayEventos = eventoModel.getEventosDeUsuario(log);
        moduloModel = new PooModuloModel();
        arrayModulos = moduloModel.getModulosDeUsuario(log);
        
        
        //Asigna el evento coincidente con el id de evento al ya creado
        for (PooEvento e : arrayEventos){
            if (e.getIdEvento()==idEvVer){
                evento = e;
            }
        }
        
        //Asigna el modulo coincidente con el id de modulo al ya creado
        for (PooModulo m : arrayModulos){
            if (m.getIdModulo()==evento.getIdModulo()){
                modulo = m;
            }
        }
        
        //Se establecen  los datos del evento y su respectivo modulo en la interfaz
        IdLabel.setText(String.valueOf(evento.getIdEvento()));
        
        TituloLabel.setText(evento.getTitulo());
        
        ModuloLabel.setText(modulo.getTitulo());
        
        FechaLabel.setText(evento.getFechaEvento());
        
        String prio="NULL";
        if (evento.getPrioridad()==1){
            prio="Baja";
        } else if (evento.getPrioridad()==2){
            prio="Media";
        } else if (evento.getPrioridad()==3){
            prio="Alta";
        }
        PrioridadLabel.setText(prio);
        
        DescripLabel.setText(evento.getDescripcion());
    }    

    /**
     * Nos lleva al editor de dicho evento
     * @param event 
     */
    @FXML
    private void handleEditarAction(ActionEvent event) {
       
        try {
            Parent root = FXMLLoader.load(getClass().getResource("FXMLEditarEvento.fxml"));
        
            Scene scene = new Scene(root);
            Stage stage = new Stage();
        
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        
            Stage myStage = (Stage) this.buttonEditar.getScene().getWindow();
            myStage.close();
        } catch (IOException ex) {
            Logger.getLogger(FXMLPantallaLogInController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Nos devuelve a la página base
     * @param event 
     */
    @FXML
    private void handleVolverAction(ActionEvent event) {
        
        try {
            Parent root = FXMLLoader.load(getClass().getResource("FXMLPantallaBase.fxml"));
        
            Scene scene = new Scene(root);
            Stage stage = new Stage();
        
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        
            Stage myStage = (Stage) this.buttonVolver.getScene().getWindow();
            myStage.close();
        } catch (IOException ex) {
            Logger.getLogger(FXMLPantallaLogInController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
