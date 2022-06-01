/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myremote;

import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 *
 * @author 1erDAM
 */
public class FullModulosView {
    
    private ArrayList<AnchorPane> allModulePanes = new ArrayList<>();
    private VBox mView;
    private PooModuloModel modelModulo = new PooModuloModel();
    private PooTareaModel modelTarea = new PooTareaModel();
    private PooEventoModel modelEvento = new PooEventoModel();
    
    
    public FullModulosView(PooUsuario usuarioActivo){
        
        ArrayList<PooModulo> arrayModulos = modelModulo.getModulos(usuarioActivo.getIdUsuario());
        int numModulos = arrayModulos.size();
        
        GridPane listadoModulos = new GridPane();
        listadoModulos.setPrefSize(1180,850);
        listadoModulos.setGridLinesVisible(false);
        
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < numModulos; j++){
                AnchorPane ap = new AnchorPane();
                ap.setPrefSize(312, 260);
                listadoModulos.add(ap,i,j);
                allModulePanes.add(ap);
            }
        }
        
        Font font = new Font("System", 200);
        Paint paintFill = Paint.valueOf("#a4a4a4");
        BorderPane bp = new BorderPane();
        bp.setStyle("border-style: dotted;");
        Button create = new Button();
        create.setOnAction((event) -> {
            handleCreateAction(event);
        });
        create.setText("+");
        create.setFont(font);
        create.setTextFill(paintFill);
        create.setStyle("padding: -20; background-color: white; border-color: white;");
        bp.getChildren().add(create);
        allModulePanes.get(0).getChildren().add(bp);
        
        popularModulos(arrayModulos);
        
        mView = new VBox(listadoModulos);
    }
    
    public void popularModulos(ArrayList<PooModulo> array){
        for (int i=0; i < allModulePanes.size(); i++){
            PooModulo m = array.get(i);
            AnchorPane ap = allModulePanes.get(i);
            ArrayList<PooTarea> arrayTareas = modelTarea.getTareasDeUsuario(array.get(i).getIdUsuario());
            ArrayList<PooEvento> arrayEventos = modelEvento.getEventosDeUsuario(array.get(i).getIdUsuario());
            
            if(ap.getChildren().size()>0){
                ap.getChildren().remove(0);
            }
            
            AnchorPane tp = new AnchorPane();
            tp.setPrefSize(312, 260);
            Text titulo = new Text(m.getTitulo());
            tp.setTopAnchor(titulo,5.0);
            tp.setLeftAnchor(titulo,5.0);
            
            AnchorPane aNew = new AnchorPane();
            Text txt = new Text(arrayTareas.size() + " tareas pendientes\n" + arrayEventos.size() + " eventos pendientes");
            aNew.setTopAnchor(txt, 5.0);
            aNew.setLeftAnchor(txt, 5.0);
            aNew.getChildren().add(aNew);
            
            Button button = new Button();
            //Setting text to the button
            button.setOnAction((event) -> {
                handleButtonAction(event, m, arrayTareas, arrayEventos);
            });
            button.setText(">");
            button.setTranslateY(30);
            ap.getChildren().add(button);
            
            tp.setBottomAnchor(aNew,5.0);
            tp.getChildren().add(aNew);
        }
    }
    
    public VBox getView(){
        return mView;
    }

    private void handleButtonAction(ActionEvent event, PooModulo mod, ArrayList<PooTarea> arrTar, ArrayList<PooEvento> arrEve) {
        System.out.println("Funciona El Boton: " + mod.getIdModulo()); 
        String tareas = "";
        String eventos = "";
        for (PooTarea t : arrTar){
            tareas += (t.getTitulo() + " - " + t.getDescripcion() + "\n");
        }
        for (PooEvento e : arrEve){
            eventos += (e.getTitulo() + " - " + e.getDescripcion() + "\n");
        }
        
        Alert alertaInfo = new Alert(Alert.AlertType.INFORMATION);
        alertaInfo.setHeaderText(mod.getTitulo());
        alertaInfo.setContentText("Tareas\n" + tareas + "\n\nEventos\n" + eventos);
        alertaInfo.showAndWait();
    }
    
    private void handleCreateAction(ActionEvent event){
        
    }
}
