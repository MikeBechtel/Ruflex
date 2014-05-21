package application;

import java.io.IOException;

import view.controller.MainController;
import model.Mitarbeiter;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;


public class Main extends Application 
{
	private Stage primaryStage;
	private BorderPane rootPane;
	
	private MainController mainControl;
	
	private ObservableList<Mitarbeiter> stammData = FXCollections.observableArrayList();
	
	@Override
	public void start(Stage primaryStage) 
	{
		this.primaryStage = primaryStage;
		rootPane = new BorderPane();
		
		Scene scene = new Scene(rootPane);
		
		try
		{
	    FXMLLoader loader = new FXMLLoader(Main.class.getResource("../view/MainPane.fxml"));
	    AnchorPane menuPage = (AnchorPane) loader.load();
	    rootPane.setCenter(menuPage);
	    
	    mainControl = loader.getController();
	    mainControl.setMainApp(this);
	    mainControl.initControllers();
	    
		}
		catch(IOException ex)
		{
			System.out.print("Error loading the .fxml file '../view/MainPane.fxml'");
			ex.printStackTrace();
			System.exit(404);
		}
		this.primaryStage.setTitle("Ruflex Verwaltung");
		this.primaryStage.getIcons().add(new Image(Main.class.getResourceAsStream("../images/icons/ruflex.png")));
		this.primaryStage.setResizable(false);
		this.primaryStage.setScene(scene);
		this.primaryStage.show();
	}
	
	public ObservableList<Mitarbeiter> getStammData()
	{
		return stammData;
	}
	
	public Stage getPrimaryStage()
	{
		return primaryStage;
	}
	
	public static void main(String[] args) 
	{
		launch(args);
	}
}
