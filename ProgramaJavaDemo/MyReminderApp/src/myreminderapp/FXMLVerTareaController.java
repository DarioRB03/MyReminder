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
public class FXMLVerTareaController implements Initializable {

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
    private Text TareaTxt;
    @FXML
    private Button buttonEditar;
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
    private TextArea DescripLabel;
    @FXML
    private Button buttonVolver;
    @FXML
    private Text RealizadoTxt;
    @FXML
    private Label RealizadoLabel;

    private int idTarVer;
    private int log;
    private PooTareaModel tareaModel;
    private ArrayList<PooTarea> arrayTareas;
    private PooTarea tarea;
    private PooModuloModel moduloModel;
    private ArrayList<PooModulo> arrayModulos;
    private PooModulo modulo;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        log=MyReminderApp.getLog();
        idTarVer=MyReminderApp.getIdTarVer();
        tarea = new PooTarea();
        modulo = new PooModulo();/*
        tareaModel = new PooTareaModel();
        arrayTareas = tareaModel.getTareasDeUsuario(log);
        moduloModel = new PooModuloModel();
        arrayModulos = moduloModel.getModulosDeUsuario(log);*/
        
        
        arrayTareas = new ArrayList<PooTarea>();
        PooTarea t1 = new PooTarea(1, 2, "Tarea 1", "AaBbCcDdEeFfGgHhIiJjKkLlMmNnÑñOoPpQqRrSsTtUuVvWwXxYyZz", "2022-05-03", 1, 0);
        PooTarea t2 = new PooTarea(2, 2, "Tarea 2", "Holis...", "2022-06-17", 3, 1);
        arrayTareas.add(t1);
        arrayTareas.add(t2);
        arrayModulos = new ArrayList<PooModulo>();
        PooModulo m1 = new PooModulo(2,1,"Titulo de modulo",5);
        arrayModulos.add(m1);
        
        
        for (PooTarea t : arrayTareas){
            if (t.getIdTarea() == idTarVer){
                tarea = t;
            }
        }
        
        for (PooModulo m : arrayModulos){
            if (m.getIdModulo()==tarea.getIdModulo()){
                modulo = m;
            }
        }
        
        IdLabel.setText(String.valueOf(tarea.getIdTarea()));
        
        TituloLabel.setText(tarea.getTitulo());
        
        ModuloLabel.setText(modulo.getTitulo());
        
        FechaLabel.setText(tarea.getFecha());
        
        String prio="NULL";
        if (tarea.getPrioridad()==1){
            prio="Baja";
        } else if (tarea.getPrioridad()==2){
            prio="Media";
        } else if (tarea.getPrioridad()==3){
            prio="Alta";
        }
        PrioridadLabel.setText(prio);
        
        DescripLabel.setText(tarea.getDescripcion());
        
        String rea = "NO";
        if (tarea.getRealizado()==1){
            rea="SI";
        }
        RealizadoLabel.setText(rea);
    }    

    @FXML
    private void handleEditarAction(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("FXMLEditarTarea.fxml"));
        
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
