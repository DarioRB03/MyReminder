package myreminderapp;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;



public class FullCalendarView {

    private ArrayList<AnchorPaneNode> allCalendarDays = new ArrayList<>(35);
    private PooTareaModel ptm;
    private PooEventoModel pem;
    private VBox view;
    private Text calendarTitle;
    private YearMonth currentYearMonth;

    private boolean temaOscuro;
    /**
     * Create a calendar view
     * @param yearMonth year month to create the calendar of
     */
    public FullCalendarView(YearMonth yearMonth) {
        
        
        currentYearMonth = yearMonth;
        // Create the calendar grid pane
        GridPane calendar = new GridPane();
        calendar.setPrefSize(960, 490);
        calendar.setGridLinesVisible(true);
        // Create rows and columns with anchor panes for the calendar
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 7; j++) {
                AnchorPaneNode ap = new AnchorPaneNode();
                ap.setPrefSize(130,90);
                calendar.add(ap,j,i);
                allCalendarDays.add(ap);
            }
        }
        // Days of the week labels
        Text[] dayNames = new Text[]{ new Text("Lunes"), new Text("Martes"), new Text("Miércoles"),
                                        new Text("Jueves"), new Text("Viernes"), new Text("Sábado"),
                                        new Text("Domingo") };
        GridPane dayLabels = new GridPane();
        dayLabels.setPrefWidth(960);
        Integer col = 0;
        for (Text txt : dayNames) {
            AnchorPane ap = new AnchorPane();
            ap.setPrefSize(400, 10);
            ap.setBottomAnchor(txt, 5.0);
            ap.getChildren().add(txt);
            dayLabels.add(ap, col++, 0);
        }
        // Create calendarTitle and buttons to change current month
        calendarTitle = new Text();
        Button previousMonth = new Button("<<");
        previousMonth.setOnAction(e -> previousMonth());
        Button nextMonth = new Button(">>");
        nextMonth.setOnAction(e -> nextMonth());
        HBox titleBar = new HBox(previousMonth, calendarTitle, nextMonth);
        titleBar.setAlignment(Pos.BASELINE_CENTER);
        // Populate calendar with the appropriate day numbers
        populateCalendar(yearMonth);
        // Create the calendar view
        dayLabels.setTranslateX(30);
        calendar.setTranslateX(30);
        view = new VBox(titleBar, dayLabels, calendar);
    }

    /**
     * Set the days of the calendar to correspond to the appropriate date
     * @param yearMonth year and month of month to render
     */
    public void populateCalendar(YearMonth yearMonth) {
        // Get the date we want to start with on the calendar
        LocalDate calendarDate = LocalDate.of(yearMonth.getYear(), yearMonth.getMonthValue(), 1);
        LocalDate actualDate = LocalDate.now();
        System.out.println(actualDate);
        
        /**/
            ArrayList<PooTarea> arrayTareas = new ArrayList<PooTarea>();
            ArrayList<PooEvento> arrayEventos = new ArrayList<PooEvento>();
            /*
            ptm = new PooTareaModel();
            pem = new PooEventoModel();*/
            int log = MyReminderApp.getLog();/*
            ArrayList<PooTarea> arrayTareas = ptm.getTareasDeUsuario(log);
            ArrayList<PooEvento> arrayEventos = pem.getEventosDeUsuario(log);
            */
            PooTarea tarTest = new PooTarea(1,1,"a","aaa","2022-06-12",2,0);
            PooTarea tarTest2 = new PooTarea(2,2,"b","bbb","2022-05-30",3,0);
            PooTarea tarTest3 = new PooTarea(3,2,"c","bbb","2022-05-26",1,0);
            PooTarea tarTest4 = new PooTarea(4,1,"d","xd","2022-06-12",1,0);
            arrayTareas.add(tarTest);
            arrayTareas.add(tarTest2);
            arrayTareas.add(tarTest3);
            arrayTareas.add(tarTest4);
        /**/
        
        // Dial back the day until it is MONDAY (unless the month starts on a monday)
        while (!calendarDate.getDayOfWeek().toString().equals("MONDAY") ) {
            calendarDate = calendarDate.minusDays(1);
        }
        // Populate the calendar with day numbers
        for (AnchorPaneNode ap : allCalendarDays) {
            if (ap.getChildren().size() != 0) {
                ap.getChildren().remove(0);
            }
            Text txt = new Text(String.valueOf(calendarDate.getDayOfMonth()));
            ap.setDate(calendarDate);
            if (ap.getDate().equals(actualDate)){
                Paint pintura = Paint.valueOf("0000ff");
                Paint pintura2 = Paint.valueOf("ffffff");/*
                if (temaOscuro){
                    pintura = Paint.valueOf("#0000ff");
                    pintura2 = Paint.valueOf("#ffffff");
                } else {
                    pintura = Paint.valueOf("#0000ff");
                    pintura2 = Paint.valueOf("#ffffff");
                }*/
                
                txt.setFill(pintura);
                Circle cir = new Circle(9);
                ap.setTopAnchor(cir, 6.0);
                ap.setLeftAnchor(cir, 0.0);
                cir.setStroke(pintura);
                cir.setFill(pintura2);
                ap.getChildren().add(cir);
            }
            Font font = new Font(15);
            txt.setFont(font);
            ap.setTopAnchor(txt, 5.0);
            ap.setLeftAnchor(txt, 5.0);
            ap.getChildren().add(txt);
            
            String fecha = calendarDate.toString();
            
            Button button = new Button();
            //Setting text to the button
            button.setOnAction((event) -> {
                handleButtonAction(event, button, arrayTareas, arrayEventos, fecha);
            });
            button.setId(calendarDate.toString());
            button.setText(">");
            button.setTranslateY(30);
            ap.getChildren().add(button);
            
            boolean prioridad1 = false;
            boolean prioridad2 = false;
            boolean prioridad3 = false;
            
            for (PooTarea t : arrayTareas){
                if (t.getRealizado()==0){
                    if (t.getFecha().equals(fecha)){
                        if (t.getPrioridad()==3){
                            prioridad3=true;
                        } else if (t.getPrioridad()==2){
                            prioridad2=true;
                        } else {
                            prioridad1=true;
                        }
                    }
                }
            }
            for (PooEvento e : arrayEventos){
                if (e.getFechaEvento().equals(fecha)){
                    if (e.getPrioridad()==3){
                        prioridad3=true;
                    } else if (e.getPrioridad()==2){
                        prioridad2=true;
                    } else {
                        prioridad1=true;
                    }
                }
            }
            if (prioridad3){
                Paint pinturaCir = Paint.valueOf("#ff0000");
                Circle cir = new Circle(10);
                cir.setTranslateX(110);
                cir.setTranslateY(15);
                cir.setFill(pinturaCir);
                ap.getChildren().add(cir);
            } else if (prioridad2){
                Paint pinturaCir = Paint.valueOf("#ffaa11");
                Circle cir = new Circle(10);
                cir.setTranslateX(110);
                cir.setTranslateY(15);
                cir.setFill(pinturaCir);
                ap.getChildren().add(cir);
            } else if (prioridad1){
                Paint pinturaCir = Paint.valueOf("#00ff00");
                Circle cir = new Circle(10);
                cir.setTranslateX(110);
                cir.setTranslateY(15);
                cir.setFill(pinturaCir);
                ap.getChildren().add(cir);
            }

            calendarDate = calendarDate.plusDays(1);
        }
        // Change the title of the calendar
        String mes = convertirMes(yearMonth.getMonth().toString());
        calendarTitle.setText(mes + " " + String.valueOf(yearMonth.getYear()));
    }

    /**
     * Move the month back by one. Repopulate the calendar with the correct dates.
     */
    private void previousMonth() {
        currentYearMonth = currentYearMonth.minusMonths(1);
        for (AnchorPaneNode ap : allCalendarDays){
            ap.getChildren().clear();
        }
        populateCalendar(currentYearMonth);
    }

    /**
     * Move the month forward by one. Repopulate the calendar with the correct dates.
     */
    private void nextMonth() {
        currentYearMonth = currentYearMonth.plusMonths(1);
        for (AnchorPaneNode ap : allCalendarDays){
            ap.getChildren().clear();
        }
        populateCalendar(currentYearMonth);
    }

    public VBox getView() {
        return view;
    }

    public ArrayList<AnchorPaneNode> getAllCalendarDays() {
        return allCalendarDays;
    }

    public void setAllCalendarDays(ArrayList<AnchorPaneNode> allCalendarDays) {
        this.allCalendarDays = allCalendarDays;
    }
    
    private void handleButtonAction(ActionEvent e, Button button, ArrayList<PooTarea> arrayTareas, ArrayList<PooEvento> arrayEventos, String fecha) {
        System.out.println("Funciona El Boton: " + button.getId()); 
        
        String contenidoTareas = "";
        String contenidoEventos = "";
        
        
        for(PooTarea t : arrayTareas){
            if (t.getRealizado()==0){
                if (t.getFecha().equals(fecha)){
                contenidoTareas += ("\n" + t.toString());
                }
            }
        }
        for(PooEvento ev : arrayEventos){
            if (ev.getFechaEvento().equals(fecha)){
                contenidoEventos += ("\n" + ev.toString());
            }
        }
        
        Alert alertaInfo = new Alert(Alert.AlertType.INFORMATION);
        alertaInfo.setHeaderText(button.getId());
        alertaInfo.setContentText("Tareas" + contenidoTareas + "\n\nEventos" + contenidoEventos);
        alertaInfo.showAndWait();
    }
    
    
    public String convertirMes(String mes){
        String mesConvertido;
        
        if (mes.equalsIgnoreCase("JANUARY")){
            mesConvertido="ENERO";
        } else if (mes.equalsIgnoreCase("FEBRUARY")){
            mesConvertido="FEBRERO";
        } else if (mes.equalsIgnoreCase("MARCH")){
            mesConvertido="MARZO";
        } else if (mes.equalsIgnoreCase("APRIL")){
            mesConvertido="ABRIL";
        } else if (mes.equalsIgnoreCase("MAY")){
            mesConvertido="MAYO";
        } else if (mes.equalsIgnoreCase("JUNE")){
            mesConvertido="JUNIO";
        } else if (mes.equalsIgnoreCase("JULY")){
            mesConvertido="JULIO";
        } else if (mes.equalsIgnoreCase("AUGUST")){
            mesConvertido="AGOSTO";
        } else if (mes.equalsIgnoreCase("SEPTEMBER")){
            mesConvertido="SETIEMBRE";
        } else if (mes.equalsIgnoreCase("OCTOBER")){
            mesConvertido="OCTUBRE";
        } else if (mes.equalsIgnoreCase("NOVEMBER")){
            mesConvertido="NOVIEMBRE";
        } else {
            mesConvertido="DICIEMBRE"; 
        }
        
        return mesConvertido;
    }
}
