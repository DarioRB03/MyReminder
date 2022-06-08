/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML.java to edit this template
 */
package myreminderapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Clase <b>main</b>. 
 * <p>
 * Se declaran las variables estáticas.
 * Se inicializa el programa cargando en el escenario principal la pantalla de LogIn.
 * 
 * @author 1erDAM
 * 
 */
public class MyReminderApp extends Application {
    /**
     * Variable estática de usuario.
     * <p>
     * Identificará el id del usuario que esté activo durante la aplicación.
     * Se establece valor en el LogIn.
     * 
     * @see  FXMLPantallaLogInController.java
     */
    public static int log;
    /**
     * Variable estática de módulo.
     * <p>
     * Identificará el id del modulo que esté activo durante visualización.
     * Se establece valor al seleccionar un módulo.
     * 
     * @see  FXMLPantallaModulosController.java
     */
    public static int idModVer;
    /**
     * Variable estática de tarea.
     * <p>
     * Identificará el id de la tarea que esté activa durante visualización.
     * Se establece valor al seleccionar una tarea.
     * 
     * @see  FXMLPantallaTareasController.java
     */
    public static int idTarVer;
    /**
     * Variable estática de evento.
     * <p>
     * Identificará el id del evento que esté activo durante visualización.
     * Se establece valor al seleccionar un evento.
     * 
     * @see  FXMLPantallaEventosController.java
     */
    public static int idEveVer;

    public static int mostrarSegundoModulo;

    public static int getMostrarSegundoModulo() {
        return mostrarSegundoModulo;
    }

    public static void setMostrarSegundoModulo(int mostrarSegundoModulo) {
        MyReminderApp.mostrarSegundoModulo = mostrarSegundoModulo;
    }
    
    /**
     * Inicia el progarma cargando el LogIn en el escenario.
     * <p>
     * Bloquea que se pueda maximizar.
     * @param stage
     * @throws Exception 
     */
    @Override
    public void start(Stage stage) throws Exception {
        
        Parent root = FXMLLoader.load(getClass().getResource("FXMLPantallaLogIn.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    /**
     * Ejecuta los argumentos de inicio del programa
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    
    /**
     * Asigna un valor a la estática log desde parámetro.
     * @param logs 
     */
    public static void setLog(int logs){
        log = logs;
    }
    
    /**
     * Devuelve la estática log.
     * @return 
     */
    public static int getLog(){
        return log;
    }
    
    /**
     * Devuelve la estática idModVer.
     * @return 
     */
    public static int getIdModVer() {
        return idModVer;
    }
    
    /**
     * Asigna un valor a la estática idModVer desde parámetro.
     * @param idModVer 
     */
    public static void setIdModVer(int idModVer) {
        MyReminderApp.idModVer = idModVer;
    }
    
    /**
     * Devuelve la estática idTarVer.
     * @return 
     */
    public static int getIdTarVer() {
        return idTarVer;
    }
    
    /**
     * Asigna un valor a la estática idTarVer desde parámetro.
     * @param idTarVer 
     */
    public static void setIdTarVer(int idTarVer) {
        MyReminderApp.idTarVer = idTarVer;
    }
    
    /**
     * Devuelve la estática idEveVer.
     * @return 
     */
    public static int getIdEveVer() {
        return idEveVer;
    }
    
    /**
     * Asigna un valor a la estática idEveVer desde parámetro.
     * @param idEveVer 
     */
    public static void setIdEveVer(int idEveVer) {
        MyReminderApp.idEveVer = idEveVer;
    }
    


    
    
}
