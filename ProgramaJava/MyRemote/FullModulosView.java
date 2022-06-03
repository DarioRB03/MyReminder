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
    
    private ArrayList<AnchorPane> allModulePanes = new ArrayList<AnchorPane>();
    private VBox mView;
    /*private PooModuloModel modelModulo = new PooModuloModel();
    private PooTareaModel modelTarea = new PooTareaModel();
    private PooEventoModel modelEvento = new PooEventoModel();*/
    
    
    public FullModulosView(PooUsuario usuarioActivo){
        
        /*ArrayList<PooModulo> arrayModulos = modelModulo.getModulosDeUsuario(usuarioActivo.getIdUsuario());*/
        /* */
        PooModulo modTest = new PooModulo(1,1,"a",2);
        PooModulo modTest2 = new PooModulo(2,1,"b",4);
        ArrayList<PooModulo> arrayModulos = new ArrayList<PooModulo>();
        arrayModulos.add(modTest);
        arrayModulos.add(modTest2);
        /* */
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
        listadoModulos.setPrefSize(1180,850);
        listadoModulos.setGridLinesVisible(true);
        
        for (int j = 0; j < numModulos; j++){
            for (int i = 0; i < 3; i++){
                AnchorPane ap = new AnchorPane();
                ap.setPrefSize(312, 260);
                listadoModulos.add(ap,j,i);
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
        for (int i=1; i < array.size(); i++){
            PooModulo m = array.get(i);
            AnchorPane ap = allModulePanes.get(i);
           /* ArrayList<PooTarea> arrayTareas = modelTarea.getTareasDeUsuario(array.get(i).getIdUsuario());
            ArrayList<PooEvento> arrayEventos = modelEvento.getEventosDeUsuario(array.get(i).getIdUsuario());
            */
           
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
