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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Clase FXML Controller
 *
 * @author 1erDAM
 */
public class FXMLVerModuloController implements Initializable {

    @FXML
    private Text IdTxt;
    @FXML
    private Text DescripTxt;
    @FXML
    private Text TituloTxt;
    @FXML
    private Text ModuloTxt;
    @FXML
    private Button buttonEditar;
    @FXML
    private Label IdLabel;
    @FXML
    private Label TituloLabel;
    @FXML
    private Button buttonVolver;
    @FXML
    private Text evaluacionesTxt;
    @FXML
    private Label evaluacionesLabel;
    @FXML
    private Text notaTxt;
    @FXML
    private Label notaLabel;

    private ArrayList<PooModulo> arrayModulos;
    private ArrayList<PooEvaluacion> arrayEvaluaciones;
    private PooEvaluacionModel pem;
    private PooModuloModel pmm;
    private int idModulo;
    private int log;
    private PooModulo modulo;
    private int contEva;
    @FXML
    private TableView<PooEvaluacion> evTableView;
    @FXML
    private TableColumn<?, ?> NumColumn;
    @FXML
    private TableColumn<?, ?> porcColumn;
    @FXML
    private TableColumn<?, ?> NotaColumn;
    
    private ObservableList<PooEvaluacion> evaluaObservables;
    /**
     * Inicializa la clase controller
     * Nos muestra los datos del modulo seleccionado
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        contEva = 0;
        //Obtener id de usuario y de modulo a ver desde estáticas
        idModulo=MyReminderApp.getIdModVer();
        log=MyReminderApp.getLog();
        
        
        pem = new PooEvaluacionModel();
        pmm = new PooModuloModel();
        arrayModulos = pmm.getModulosDeUsuario(log);
        arrayEvaluaciones = pem.getEvaluacionDeModulo(idModulo);
        
        if (arrayModulos==null){
            arrayModulos = new ArrayList<PooModulo>(0);
        }
        if (arrayEvaluaciones==null){
            arrayEvaluaciones = new ArrayList<PooEvaluacion>(0);
        }
        
        evaluaObservables = FXCollections.observableArrayList();
        
        //Añadir el array de evaluaciones a la lista de evaluaciones observables
        for (PooEvaluacion e : arrayEvaluaciones){
            evaluaObservables.add(e);
        }

        
        this.NumColumn.setCellValueFactory(new PropertyValueFactory("numEvaluacion"));   
        this.porcColumn.setCellValueFactory(new PropertyValueFactory("porcentaje"));
        this.NotaColumn.setCellValueFactory(new PropertyValueFactory("nota"));
     
        //Se añade la lista de evaluaciones observables a la tabla
        this.evTableView.setItems(evaluaObservables);
        
        //Por cada evaluacio existente se añade 1 al contador
        for (PooEvaluacion e : arrayEvaluaciones){
            contEva+=1;
        }
        
        //Se obtienen los datos del módulo que coincide con el id de modulo seleccionado
        for (PooModulo m : arrayModulos){
            if(idModulo==m.getIdModulo()){
                modulo = m;
            }
        }
        
        //Se muestran los datos del modulo en la interfaz
        IdLabel.setText(String.valueOf(modulo.getIdModulo()));
        TituloLabel.setText(modulo.getTitulo());
        evaluacionesLabel.setText(String.valueOf(contEva));
        notaLabel.setText(String.valueOf(modulo.getNotaFinal()));
    }    

    /**
     * Nos lleva al editor de dicho modulo
     * @param event 
     */
    @FXML
    private void handleEditarAction(ActionEvent event) {
        
        try {
            Parent root = FXMLLoader.load(getClass().getResource("FXMLEditarModulo.fxml"));
        
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
     * Nos devuelve a la pantalla base
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
