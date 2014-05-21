package view.controller;

import application.Main;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

public class MainController
{
	@FXML
	private AnchorPane tabStammdaten;
	@FXML
	private ControllerStammdaten tabStammdatenController;
	
	private Main mainApp;
	
	@FXML
	private void initialize()
	{

	}
	
	public void setMainApp(Main mainApp)
	{
		this.mainApp = mainApp;
	}
	
	public void initControllers()
	{
		tabStammdatenController.setMainApp(mainApp);
	}
}
