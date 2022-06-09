package myreminderapp;

import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;

import java.time.LocalDate;

/**
 * Crea un anchor pane que almacena datos adicionales.
 * @author 1erDAM
 * 
 */
public class AnchorPaneNode extends AnchorPane {

    /**
     * Fecha asociada con el panel
     */
    private LocalDate date;

    /**
     * Crea un nodo de anchor pane. La fecha no se asigna en el constructor.
     * Añade al panel un evento para cuando se hace click sobre éste.
     * @param children children of the anchor pane
     * 
     */
    public AnchorPaneNode(Node... children) {
        super(children);
        
        //Añade al panel un evento para cuando se hace click sobre éste.
        this.setOnMouseClicked(e -> System.out.println("La fecha de éste panel es: " + date));
    }

    /**
     * Devuelve la fecha del nodo.
     * @return 
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * Asigna una fecha al nodo.
     * @param date 
     */
    public void setDate(LocalDate date) {
        this.date = date;
    }
}
