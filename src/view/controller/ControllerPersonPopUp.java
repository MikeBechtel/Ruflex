package view.controller;

import model.Mitarbeiter;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ControllerPersonPopUp 
{
	@FXML
	private TextField fieldPersNr;
	@FXML
	private TextField fieldFirstName;
	@FXML
	private TextField fieldLastName;
	@FXML
	private TextField fieldStreet;
	@FXML
	private TextField fieldStreetNumber;
	@FXML
	private TextField fieldZipCode;
	@FXML
	private TextField fieldTown;
	@FXML
	private TextField fieldBirthDate;
	@FXML
	private TextField fieldBirthPlace;
	@FXML
	private TextField fieldBirthCountry;
	@FXML
	private TextField fieldSvNr;
	@FXML
	private TextField fieldNationality;
	@FXML
	private TextField fieldCurrWork;
	@FXML
	private TextArea areaAddInfo;
	
	private Stage popStage;
	
	private Mitarbeiter mitarbeiter;
	
	private boolean okClicked = false;
	
    @FXML
    private void initialize() 
    {

    }
    
    public void setPopUpStage(Stage dialogStage) 
    {
        this.popStage = dialogStage;
    }
    
    public boolean isOkClicked() 
    {
        return okClicked;
    }
    
    public void setMitarbeiter(Mitarbeiter mitarbeiter) 
    {
        this.mitarbeiter = mitarbeiter;

        fieldPersNr.setText(mitarbeiter.getPersNr());
        fieldFirstName.setText(mitarbeiter.getFirstName());
        fieldLastName.setText(mitarbeiter.getLastName());
        fieldStreet.setText(mitarbeiter.getStreet());
        fieldStreetNumber.setText(mitarbeiter.getStreetNumber());
        fieldZipCode.setText(mitarbeiter.getZipCode());
        fieldTown.setText(mitarbeiter.getTown());
        fieldBirthDate.setText(mitarbeiter.getBirthDate());
        fieldBirthPlace.setText(mitarbeiter.getBirthPlace());
        fieldBirthCountry.setText(mitarbeiter.getBirthCountry());
        fieldSvNr.setText(mitarbeiter.getSVNr());
        fieldNationality.setText(mitarbeiter.getNationality());
        fieldCurrWork.setText(mitarbeiter.getCurrWork());
        areaAddInfo.setText(mitarbeiter.getAddInfo());
    }
    
    @FXML
    private void handleOKClicked() 
    {
        if (true /*maybe some sort of validate check*/) 
        {
        	mitarbeiter.setPersNr(fieldPersNr.getText());
        	mitarbeiter.setFirstName(fieldFirstName.getText());
        	mitarbeiter.setLastName(fieldLastName.getText());
        	mitarbeiter.setStreet(fieldStreet.getText());
        	mitarbeiter.setStreetNumber(fieldStreetNumber.getText());
        	mitarbeiter.setZipCode(fieldZipCode.getText());
        	mitarbeiter.setTown(fieldTown.getText());
        	mitarbeiter.setBirthDate(fieldBirthDate.getText());
        	mitarbeiter.setBirthPlace(fieldBirthPlace.getText());
        	mitarbeiter.setBirthCountry(fieldBirthCountry.getText());
        	mitarbeiter.setSvNr(fieldSvNr.getText());
        	mitarbeiter.setNationality(fieldNationality.getText());
        	mitarbeiter.setCurrWork(fieldCurrWork.getText());
        	mitarbeiter.setAddInfo(areaAddInfo.getText());

            okClicked = true;
            popStage.close();
        }
    }
    
    @FXML
    private void handleCancelClicked() 
    {
        popStage.close();
    }
}
