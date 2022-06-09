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
 *
 * @author 1erDAM
 */
public class FullModulosView {
    private ArrayList<AnchorPane> allModulePanes = new ArrayList<AnchorPane>();
    private VBox mView;
    private int alongar;
    
    public FullModulosView(){
        
        alongar=0;
        

        PooModulo modTest = new PooModulo(1,1,"Titulo Largo",2);
        PooModulo modTest2 = new PooModulo(2,1,"b",4);
        PooModulo modTest3 = new PooModulo(3,1,"a",2);
        PooModulo modTest4 = new PooModulo(4,1,"b",4);
        PooModulo modTest5 = new PooModulo(5,1,"a",2);
        PooModulo modTest6 = new PooModulo(6,1,"b",4);
        PooModulo modTest7 = new PooModulo(7,1,"b",4);
        PooModulo modTest8 = new PooModulo(8,1,"a",2);
        PooModulo modTest9 = new PooModulo(9,1,"b",4);

        ArrayList<PooModulo> arrayModulos = new ArrayList<PooModulo>();
        arrayModulos.add(modTest);
        arrayModulos.add(modTest2);
        arrayModulos.add(modTest3);
        arrayModulos.add(modTest4);
        arrayModulos.add(modTest5);
        arrayModulos.add(modTest6);
        arrayModulos.add(modTest7);
        arrayModulos.add(modTest8);
        arrayModulos.add(modTest9);
        
        int numModulos = 1;
        if (arrayModulos.size()==2){
            numModulos = 1;
        } else if ((arrayModulos.size()%3) == 0) {
            numModulos = ((arrayModulos.size()/3)+1);
        } else if (((arrayModulos.size()-1)%3) == 0){
            numModulos = ((arrayModulos.size()/4)+1);
        } else if (((arrayModulos.size()-2)%3) == 0){
            numModulos = ((arrayModulos.size()/5)+1);
        } 
        
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
    
    public void popularModulos(ArrayList<PooModulo> array){
        
        /**/
        PooTarea tarTest = new PooTarea(1,1,"a","aaa","2022-6-12",2,0);
        PooTarea tarTest2 = new PooTarea(2,2,"b","bbb","2022-5-26",3,1);
        ArrayList<PooTarea> arrayTareas = new ArrayList<PooTarea>();
        arrayTareas.add(tarTest);
        arrayTareas.add(tarTest2);
            
        PooEvento eveTest = new PooEvento(1,1,"a","aaa","2022-6-12",2);
        PooEvento eveTest2 = new PooEvento(2,1,"b","bbb","2022-5-26",1);
        ArrayList<PooEvento> arrayEventos = new ArrayList<PooEvento>();
        arrayEventos.add(eveTest);
        arrayEventos.add(eveTest2);
        /**/
        
        for (int i=0; i < array.size(); i++){
            PooModulo m = array.get(i);
            AnchorPane ap = allModulePanes.get(i+1);
           /* ArrayList<PooTarea> arrayTareas = modelTarea.getTareasDeUsuario(array.get(i).getIdUsuario());
            ArrayList<PooEvento> arrayEventos = modelEvento.getEventosDeUsuario(array.get(i).getIdUsuario());
            */
           
           
           
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
            Text txt = new Text(arrayTareas.size() + " tareas pendientes\n" + arrayEventos.size() + " eventos pendientes");

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
    
    public int getAlongar(){
        return alongar;
    }
    
    public VBox getView(){
        return mView;
    }

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