package ui;

import java.text.SimpleDateFormat;
import java.util.Date;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.StageStyle;
import model.Flight;
import model.Simulation;
import model.Time;

public class FlightController {
	@FXML
    private GridPane gp;
	
	private Simulation s;
	@FXML
    private Pagination pagination;
	@FXML
    private BorderPane borderPane;

    @FXML
    private TextField nFlight;
    @FXML
    private Label time;

    @FXML
    private Label clock;

    private TableView<Flight> table;
    private ObservableList<Flight> data;
    private final static int rowsPerPage = 14;
    @FXML
    public void generateSimulation(ActionEvent event) {
    	try {
    		long start = System.currentTimeMillis();
    		int n= Integer.parseInt(nFlight.getText());
        	s= new Simulation(n);
        	s.generateSimulation();
        	long endTime = (System.currentTimeMillis() - start)/1000;
           	time.setText("Time: "+endTime);
        	table =createTable();
        	borderPane.setCenter(table);
        	pagination.setPageFactory(this::createPage);
    	}catch(NumberFormatException e) {
    		Alert info = new Alert(AlertType.ERROR);
        	info.setTitle("Simulation");
        	info.setHeaderText(null);
        	info.initStyle(StageStyle.UTILITY);
        	info.setContentText("Please introduce a number");
        	info.show();
    	} 
    }
 

    @FXML
    public void airlineUp(ActionEvent event) {
    	long start = System.currentTimeMillis();
    	s.bubbleSort();
    	long endTime = (System.currentTimeMillis() - start)/1000;
       	time.setText("Time: "+endTime);
    	table =createTable();
    	pagination.setPageFactory(this::createPage);
    }

    @FXML
    public void cityUp(ActionEvent event) {
    	long start = System.currentTimeMillis();
    	s.sortByDestination();
    	long endTime = (System.currentTimeMillis() - start)/1000;
       	time.setText("Time: "+endTime);
    	table =createTable();
    	pagination.setPageFactory(this::createPage);
    }


    @FXML
    public void dateUp(ActionEvent event) {
    	long start = System.currentTimeMillis();
    	s.sortByDate2();
    	long endTime = (System.currentTimeMillis() - start)/1000;
       	time.setText("Time: "+endTime);
    	table =createTable();
    	pagination.setPageFactory(this::createPage);
    }


    @FXML
    public void flightUp(ActionEvent event) {
    	long start = System.currentTimeMillis();
    	s.sortByCode();
    	long endTime = (System.currentTimeMillis() - start)/1000;
       	time.setText("Time: "+endTime);
    	table =createTable();
    	pagination.setPageFactory(this::createPage);
    }

    @FXML
    public void gateUp(ActionEvent event) {
    	long start = System.currentTimeMillis();
    	s.sortByGate();
    	long endTime = (System.currentTimeMillis() - start)/1000;
       	time.setText("Time: "+endTime);
    	table =createTable();
    	pagination.setPageFactory(this::createPage);
    }


    @FXML
    public void timeUp(ActionEvent event) {
    	long start = System.currentTimeMillis();
    	s.sortByTime2();
    	long endTime = (System.currentTimeMillis() - start)/1000;
       	time.setText("Time: "+endTime);
    	table =createTable();
    	pagination.setPageFactory(this::createPage);
    }

    public void clokGenerate() {
    	Date objDate = new Date(); 
        String strDateFormat = "hh:mm a"; 
        SimpleDateFormat objSDF = new SimpleDateFormat(strDateFormat); 
        clock.setText(objSDF.format(objDate));
     }
    
    private TableView<Flight> createTable(){
    	table = new TableView<Flight>();
    	data = createData();
    	table.setEditable(true);
    	TableColumn<Flight, Date> date = new TableColumn<Flight, Date>("DATE");
    	date.setCellValueFactory(new PropertyValueFactory<Flight, Date>("date"));
    	
    	TableColumn<Flight, Time> schedule = new TableColumn<Flight, Time>("TIME");
    	schedule.setCellValueFactory(new PropertyValueFactory<Flight, Time>("schedule"));
    	
    	TableColumn<Flight, String> nameAirline= new TableColumn<Flight, String>("AIRLINE");
    	nameAirline.setCellValueFactory(new PropertyValueFactory<Flight, String>("nameAirline"));
    	
    	TableColumn<Flight, String> idAirline= new TableColumn<Flight, String>("FLIGHT");
    	idAirline.setCellValueFactory(new PropertyValueFactory<Flight, String>("idAirline"));
    	
    	TableColumn<Flight, String> destinationCity= new TableColumn<Flight, String>("TO");
    	destinationCity.setCellValueFactory(new PropertyValueFactory<Flight, String>("destinationCity"));
    	
    	TableColumn<Flight, String> boardingGate= new TableColumn<Flight, String>("GATE");
    	boardingGate.setCellValueFactory(new PropertyValueFactory<Flight, String>("boardingGate"));
    	
    
    	table.setItems(data);
    	table.getColumns().addAll(date,schedule, nameAirline, idAirline, destinationCity, boardingGate);
    	table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    	
    	return table;
    }
    private ObservableList<Flight> createData(){//
    	
    	data = FXCollections.observableArrayList();
    	
    	data.addAll(s.getFlightsToArraylis());
    	return data;
    }
   
    private Node createPage(int pageIndex) {
        int fromIndex = pageIndex * rowsPerPage;
        int toIndex = Math.min(fromIndex + rowsPerPage, data.size());
        table.setItems(FXCollections.observableArrayList(data.subList(fromIndex, toIndex)));
        
        return table;
    }

	public void initialize() {
		clokGenerate();
		borderPane.setStyle("-fx-background-color: #10026d;");
	}
    
}