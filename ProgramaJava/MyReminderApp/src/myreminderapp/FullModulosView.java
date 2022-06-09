/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myreminderapp;


import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Clase de objeto vista de modulos
 * @author 1erDAM
 */
public class FullModulosView {
    private ArrayList<AnchorPane> allModulePanes = new ArrayList<AnchorPane>();
    private VBox mView;
    private int alongar;
    private ArrayList<PooModulo> arrayModulos;
    private ArrayList<PooTarea> arrayTareas;
    private ArrayList<PooEvento> arrayEventos;
    private PooModuloModel pmm;
    private PooTareaModel ptm;
    private PooEventoModel pem;
    private int log;
    
    /**
     * Crea un VBox de modulos
     */
    public FullModulosView(){
        
        alongar=0;
        log = MyReminderApp.getLog();
        
        pmm = new PooModuloModel();
        ptm = new PooTareaModel();
        pem = new PooEventoModel();
        arrayModulos = new ArrayList<PooModulo>();
        arrayTareas = new ArrayList<PooTarea>();
        arrayEventos = new ArrayList<PooEvento>();
        arrayModulos = pmm.getModulosDeUsuario(log);
        
        arrayTareas = ptm.getTareasDeUsuario(log);
        arrayEventos = pem.getEventosDeUsuario(log);
        
        if (arrayTareas==null){
            arrayTareas = new ArrayList<PooTarea>(0);
        }
        if (arrayEventos==null){
            arrayEventos = new ArrayList<PooEvento>(0);
        }
        
        
         
        int numModulos = arrayModulos.size();
        
        GridPane listadoModulos = new GridPane();
        listadoModulos.setPrefSize(620,450);
        listadoModulos.setGridLinesVisible(true);
        
        for (int i = 0; i < numModulos; i++){
            for (int j = 0; j < 3; j++){
                AnchorPane ap = new AnchorPane();
                ap.setPrefSize(240, 240);
                listadoModulos.add(ap,j,i);
                allModulePanes.add(ap);
                alongar += 140;
            }
        }
        
        popularModulos(arrayModulos);
        
        mView = new VBox(listadoModulos);
        mView.setAlignment(Pos.BOTTOM_CENTER);
    }
    
    /**
     * Asigna los modulos a los paneles para popular la VBox
     * @param array 
     */
    public void popularModulos(ArrayList<PooModulo> array){
        

        
        for (int i=0; i < array.size(); i++){
            PooModulo m = array.get(i);
            AnchorPane ap = allModulePanes.get(i+1);
           
           
            if(ap.getChildren().size()>0){
                ap.getChildren().remove(0);
            } 
            Paint labelPaint = Paint.valueOf("#0066ff");
            Font fontTit = new Font("Yu Gothic light",20);
            Text titulo = new Text(m.getTitulo());

            ap.setTopAnchor(titulo,10.0);
            ap.setLeftAnchor(titulo,10.0);
            titulo.setFill(labelPaint);
            titulo.setFont(fontTit);
            
            ap.getChildren().add(titulo);
            
            Font fontTxt = new Font("Yu Gothic light", 15);
            Text txt = new Text();
            
            if (arrayTareas==null&&arrayEventos==null){
                txt = new Text("0 tareas pendientes\n0 eventos pendientes");
            } else if (arrayEventos==null){
                txt = new Text(arrayTareas.size() + " tareas pendientes\n0 eventos pendientes");
            } else if (arrayTareas==null){
                txt = new Text("0 tareas pendientes\n" + arrayEventos.size() + " eventos pendientes");
            } else {
                txt = new Text(arrayTareas.size() + " tareas pendientes\n" + arrayEventos.size() + " eventos pendientes");
            }
            

            ap.setTopAnchor(txt, 40.0);
            ap.setLeftAnchor(txt, 10.0);

            ap.getChildren().add(txt);
            txt.setFont(fontTxt);
            
            Font fontButton = new Font("Yu Gothic light", 14);
            Button button = new Button();
            button.setOnAction((event) -> {
                handleButtonAction(event, m);
            });

            button.setText("Ver");
            button.setFont(fontButton);
            button.setTextFill(labelPaint);
            ap.setTopAnchor(button,82.0);
            ap.setLeftAnchor(button,10.0);
            ap.getChildren().add(button);
            
            
        }
        Button create = new Button();
        create.setOnAction((event) -> {
            handleCreateAction(event);
        });
        create.setPrefWidth(100);

        Font font = new Font(40);
        create.setFont(font);
        Paint pintura = Paint.valueOf("#c4c4c4");
        create.setTextFill(pintura);
        create.setStyle("-fx-background-color: white; -fx-border-color: white;");
        
        create.setText("+");
        allModulePanes.get(0).setTranslateX(50);
        allModulePanes.get(0).setTranslateY(10);
        allModulePanes.get(0).getChildren().add(create);
    }
    
    /**
     * Obtener valor de la variable alongar
     * @return 
     */
    public int getAlongar(){
        return alongar;
    }
    
    /**
     * Obtener VBox de los modulos
     * @return 
     */
    public VBox getView(){
        return mView;
    }

    /**
     * Evento que nos lleva a la pantalla de crear modulo
     * @param event 
     */
    private void handleCreateAction(ActionEvent event) {
        System.out.println("botonOk");
        try {
            Parent root = FXMLLoader.load(getClass().getResource("FXMLCrearModulo.fxml"));
        
            Scene scene = new Scene(root);
            Stage stage = new Stage();
        
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        
            Stage myStage = (Stage) this.mView.getScene().getWindow();
            myStage.close();
        } catch (IOException ex) {
            Logger.getLogger(FXMLPantallaLogInController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Evento que nos lleva a ver el contenido de un modulo
     * Asigna valor a la estatica de idModVer
     * @param event
     * @param m 
     */
    private void handleButtonAction(ActionEvent event, PooModulo m) {
        System.out.println("Boton " + m.getIdModulo() + " Ok");
        MyReminderApp.setIdModVer(m.getIdModulo());
        try {
            Parent root = FXMLLoader.load(getClass().getResource("FXMLVerModulo.fxml"));
        
            Scene scene = new Scene(root);
            Stage stage = new Stage();
        
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        
            Stage myStage = (Stage) this.mView.getScene().getWindow();
            myStage.close();
        } catch (IOException ex) {
            Logger.getLogger(FXMLPantallaLogInController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}