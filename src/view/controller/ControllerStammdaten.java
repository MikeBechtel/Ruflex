package view.controller;

import java.io.IOException;

import application.Main;
import model.Mitarbeiter;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ControllerStammdaten 
{
	@FXML
	private TableView<Mitarbeiter> stammdatenTable;

	@FXML
	private TableColumn<Mitarbeiter,String> persNr;
	@FXML
	private TableColumn<Mitarbeiter,String> lastName;
	@FXML
	private TableColumn<Mitarbeiter,String> firstName;
	@FXML
	private TableColumn<Mitarbeiter,String> street;
	@FXML
	private TableColumn<Mitarbeiter,String> streetNumber;
	@FXML
	private TableColumn<Mitarbeiter,String> zipCode;
	@FXML
	private TableColumn<Mitarbeiter,String> town;

	@FXML
	private Label labelFirstName;
	@FXML
	private Label labelLastName;
	@FXML
	private Label labelStreet;
	@FXML
	private Label labelStreetNumber;
	@FXML
	private Label labelZipCode;
	@FXML
	private Label labelTown;
	@FXML
	private Label labelBirthDate;
	@FXML
	private Label labelBirthPlace;
	@FXML
	private Label labelBirthCountry;
	@FXML
	private Label labelSvNr;
	@FXML
	private Label labelNationality;
	@FXML
	private Label labelCurrWork;
	@FXML
	private TextArea areaAddInfo;
	
	@FXML
	private Button buttonDelete;
	@FXML
	private Button buttonEdit;
	
	private Main mainApp;
	
	public ControllerStammdaten() { }
	
	@FXML
	private void initialize()
	{
		persNr.setCellValueFactory(new PropertyValueFactory<Mitarbeiter, String>("persNr"));
		lastName.setCellValueFactory(new PropertyValueFactory<Mitarbeiter, String>("lastName"));
		firstName.setCellValueFactory(new PropertyValueFactory<Mitarbeiter, String>("firstName"));
		street.setCellValueFactory(new PropertyValueFactory<Mitarbeiter, String>("street"));
		streetNumber.setCellValueFactory(new PropertyValueFactory<Mitarbeiter, String>("streetNumber"));
		zipCode.setCellValueFactory(new PropertyValueFactory<Mitarbeiter, String>("zipCode"));
		town.setCellValueFactory(new PropertyValueFactory<Mitarbeiter, String>("town"));
		
		showMitarbeiterDetails(null);
		buttonDelete.setDisable(true);
		buttonEdit.setDisable(true);
		
		stammdatenTable.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Mitarbeiter>() 
				{
					@Override
					public void changed(ObservableValue<? extends Mitarbeiter> observable, Mitarbeiter oldValue, Mitarbeiter newValue) 
					{
						showMitarbeiterDetails(newValue);
						
						if(stammdatenTable.getSelectionModel().getSelectedIndex() == (-1))
						{
							buttonDelete.setDisable(true);
							buttonEdit.setDisable(true);
						}
						else
						{
							buttonDelete.setDisable(false);
							buttonEdit.setDisable(false);
						}
					}
				});
	}
	
	@FXML
	private void handleNewButton()
	{
		Mitarbeiter tempMitarbeiter = new Mitarbeiter();
		boolean okClicked = showMitarbeiterEditDialog(tempMitarbeiter);
		
		if (okClicked) 
		{
		    mainApp.getStammData().add(tempMitarbeiter);
		}
	}
	
	@FXML
	private void handleEditButton()
	{
		Mitarbeiter selectedMitarbeiter = stammdatenTable.getSelectionModel().getSelectedItem();
		boolean okClicked = showMitarbeiterEditDialog(selectedMitarbeiter);
		
		if (okClicked) 
		{
		    refreshPersonTable();
		    showMitarbeiterDetails(selectedMitarbeiter);
		}
	}
	
	@FXML
	private void handleDeleteButton()
	{
		int selectedIndex = stammdatenTable.getSelectionModel().getSelectedIndex();
		stammdatenTable.getItems().remove(selectedIndex);
	}
	
	private void showMitarbeiterDetails(Mitarbeiter mitarbeiter) 
	{
		if (mitarbeiter != null) 
		{
			labelFirstName.setText(mitarbeiter.getFirstName());
			labelLastName.setText(mitarbeiter.getLastName());
			labelStreet.setText(mitarbeiter.getStreet());
			labelStreetNumber.setText(mitarbeiter.getStreetNumber());
			labelZipCode.setText(mitarbeiter.getZipCode());
			labelTown.setText(mitarbeiter.getTown());
			labelBirthDate.setText(mitarbeiter.getBirthDate());
			labelBirthPlace.setText(mitarbeiter.getBirthPlace());
			labelBirthCountry.setText(mitarbeiter.getBirthCountry());
			labelSvNr.setText(mitarbeiter.getSVNr());
			labelNationality.setText(mitarbeiter.getNationality());
			labelCurrWork.setText(mitarbeiter.getCurrWork());
			areaAddInfo.setText(mitarbeiter.getAddInfo());
		} 
		else 
		{
			labelFirstName.setText("");
			labelLastName.setText("");
			labelStreet.setText("");
			labelStreetNumber.setText("");
			labelZipCode.setText("");
			labelTown.setText("");
			labelBirthDate.setText("");
			labelBirthPlace.setText("");
			labelBirthCountry.setText("");
			labelSvNr.setText("");
			labelNationality.setText("");
			labelCurrWork.setText("");
			areaAddInfo.setText("");
		}
	}
	
	public boolean showMitarbeiterEditDialog(Mitarbeiter mitarbeiter) 
	{
		try 
		{
		    FXMLLoader loader = new FXMLLoader(Main.class.getResource("../view/PopUpMitarbeiter.fxml"));
		    AnchorPane page = (AnchorPane) loader.load();
		    
		    Stage dialogStage = new Stage();
		    
		    Scene scene = new Scene(page);
		    
		    dialogStage.setTitle("Mitarbeiter erstellen / bearbeiten");
		    dialogStage.initModality(Modality.WINDOW_MODAL);
		    dialogStage.initOwner(mainApp.getPrimaryStage());
		    dialogStage.setScene(scene);

		    ControllerPersonPopUp controller = loader.getController();
		    
		    controller.setPopUpStage(dialogStage);
		    controller.setMitarbeiter(mitarbeiter);

		    dialogStage.showAndWait();

		    return controller.isOkClicked();
		} 
		catch (IOException e) 
		{
		    e.printStackTrace();
		    return false;
		}
    }
	
	private void refreshPersonTable() 
	{
		int selectedIndex = stammdatenTable.getSelectionModel().getSelectedIndex();
		
		stammdatenTable.setItems(null);
		stammdatenTable.layout();
		stammdatenTable.setItems(mainApp.getStammData());

		stammdatenTable.getSelectionModel().select(selectedIndex);
		}
	
	public void setMainApp(Main mainApp)
	{
		this.mainApp = mainApp;
		stammdatenTable.setItems(this.mainApp.getStammData());
	}
}
