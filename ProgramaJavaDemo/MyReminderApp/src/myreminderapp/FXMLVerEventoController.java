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
 * FXML Controller class
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
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        log=MyReminderApp.getLog();
        idEvVer=MyReminderApp.getIdEveVer();
        evento = new PooEvento();
        modulo = new PooModulo();/*
        eventoModel = new PooEventoModel();
        arrayEventos = eventoModel.getEventosDeUsuario(log);
        moduloModel = new PooModuloModel();
        arrayModulos = moduloModel.getModulosDeUsuario(log);*/
        
        arrayEventos = new ArrayList<PooEvento>();
        PooEvento e1 = new PooEvento(1,2,"a","bb","2022-05-05",1);
        PooEvento e2 = new PooEvento(2,2,"b","bb","2022-08-08",1);
        arrayEventos.add(e1);
        arrayEventos.add(e2);
        arrayModulos = new ArrayList<PooModulo>();
        PooModulo m1 = new PooModulo(2,1,"Titulo de modulo",5);
        arrayModulos.add(m1);
        
        for (PooEvento e : arrayEventos){
            if (e.getIdEvento()==idEvVer){
                evento = e;
            }
        }
        
        for (PooModulo m : arrayModulos){
            if (m.getIdModulo()==evento.getIdModulo()){
                modulo = m;
            }
        }
        
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
