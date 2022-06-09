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
 * FXML Controller class
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
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        contEva = 0;
        idModulo=MyReminderApp.getIdModVer();
        log=MyReminderApp.getLog();
        System.out.println(idModulo + " - " + log);
        
        
        
        
        arrayModulos = new ArrayList<PooModulo>();
        PooModulo modTest = new PooModulo(1,1,"Titulo Largo",2);
        PooModulo modTest2 = new PooModulo(2,1,"b",4);
        PooModulo modTest3 = new PooModulo(3,1,"a",2);
        PooModulo modTest4 = new PooModulo(4,1,"b",4);
        PooModulo modTest5 = new PooModulo(5,1,"a",2);
        PooModulo modTest6 = new PooModulo(6,1,"b",4);
        PooModulo modTest7 = new PooModulo(7,1,"b",4);
        PooModulo modTest8 = new PooModulo(8,1,"a",2);
        PooModulo modTest9 = new PooModulo(9,1,"b",4);
        arrayModulos.add(modTest);
        arrayModulos.add(modTest2);
        arrayModulos.add(modTest3);
        arrayModulos.add(modTest4);
        arrayModulos.add(modTest5);
        arrayModulos.add(modTest6);
        arrayModulos.add(modTest7);
        arrayModulos.add(modTest8);
        arrayModulos.add(modTest9);
        
        
        /*
        pem = new PooEvaluacionModel();
        pmm = new PooModuloModel();
        arrayModulos = pmm.getModulosDeUsuario(log);
        arrayEvaluaciones = pem.getEvaluacionDeModulo(idModulo);*/
        arrayEvaluaciones = new ArrayList<PooEvaluacion>();
        
        PooEvaluacion evaTest = new PooEvaluacion(1,1,30,5);
        PooEvaluacion evaTest2 = new PooEvaluacion(1,2,30,3);
        PooEvaluacion evaTest3 = new PooEvaluacion(1,3,40,6);
        arrayEvaluaciones.add(evaTest);
        arrayEvaluaciones.add(evaTest2);
        arrayEvaluaciones.add(evaTest3);
        
        evaluaObservables = FXCollections.observableArrayList();
        
        for (PooEvaluacion e : arrayEvaluaciones){
            evaluaObservables.add(e);
        }
        
        this.NumColumn.setCellValueFactory(new PropertyValueFactory("numEvaluacion"));   
        this.porcColumn.setCellValueFactory(new PropertyValueFactory("porcentaje"));
        this.NotaColumn.setCellValueFactory(new PropertyValueFactory("nota"));
     
        this.evTableView.setItems(evaluaObservables);
        
        for (PooEvaluacion e : arrayEvaluaciones){
            contEva+=1;
        }
        
        for (PooModulo m : arrayModulos){
            if(idModulo==m.getIdModulo()){
                modulo = m;
            }
        }
        
        IdLabel.setText(String.valueOf(modulo.getIdModulo()));
        TituloLabel.setText(modulo.getTitulo());
        evaluacionesLabel.setText(String.valueOf(contEva));
        notaLabel.setText(String.valueOf(modulo.getNotaFinal()));
    }    

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
