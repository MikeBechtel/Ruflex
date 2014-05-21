package model;

import javafx.beans.property.SimpleStringProperty;

public class Mitarbeiter 
{
	private SimpleStringProperty persNr, lastName, firstName;
	private SimpleStringProperty street, town, streetNumber, zipCode;
	private SimpleStringProperty birthDate, birthPlace, birthCountry;
	private SimpleStringProperty svNr, nationality, currWork, addInfo;
	
	public Mitarbeiter()
	{
		this.persNr = new SimpleStringProperty("");
		this.lastName = new SimpleStringProperty("");
		this.firstName = new SimpleStringProperty("");
		this.street = new SimpleStringProperty("");
		this.town = new SimpleStringProperty("");
		this.streetNumber = new SimpleStringProperty("");
		this.zipCode = new SimpleStringProperty("");
		this.birthDate = new SimpleStringProperty("");
		this.birthPlace = new SimpleStringProperty("");
		this.birthCountry = new SimpleStringProperty("");
		this.svNr = new SimpleStringProperty("");
		this.nationality = new SimpleStringProperty("");
		this.currWork = new SimpleStringProperty("");
		this.addInfo = new SimpleStringProperty("");
	}
	
	public Mitarbeiter(String persNr, String lastName, String firstName)
	{
		this.persNr = new SimpleStringProperty(persNr);
		this.lastName = new SimpleStringProperty(lastName);
		this.firstName = new SimpleStringProperty(firstName);
		this.street = new SimpleStringProperty("");
		this.town = new SimpleStringProperty("");
		this.streetNumber = new SimpleStringProperty("");
		this.zipCode = new SimpleStringProperty("");
		this.birthDate = new SimpleStringProperty("");
		this.birthPlace = new SimpleStringProperty("");
		this.birthCountry = new SimpleStringProperty("");
		this.svNr = new SimpleStringProperty("");
		this.nationality = new SimpleStringProperty("");
		this.currWork = new SimpleStringProperty("");
		this.addInfo = new SimpleStringProperty("");
	}
	
	public Mitarbeiter(String persNr, String lastName, String firstName, String street, String streetNumber, String zipCode, String town)
	{
		this.persNr = new SimpleStringProperty(persNr);
		this.lastName = new SimpleStringProperty(lastName);
		this.firstName = new SimpleStringProperty(firstName);
		this.street = new SimpleStringProperty(street);
		this.town = new SimpleStringProperty(town);
		this.streetNumber = new SimpleStringProperty(streetNumber);
		this.zipCode = new SimpleStringProperty(zipCode);
		this.birthDate = new SimpleStringProperty("");
		this.birthPlace = new SimpleStringProperty("");
		this.birthCountry = new SimpleStringProperty("");
		this.svNr = new SimpleStringProperty("");
		this.nationality = new SimpleStringProperty("");
		this.currWork = new SimpleStringProperty("");
		this.addInfo = new SimpleStringProperty("");
	}
	
	public Mitarbeiter(String persNr, String lastName, String firstName, String street, String streetNumber, String zipCode, String town,
					   String birthDate, String birthPlace, String birthCountry, String svNr, String nationality, String currWork, String addInfo)
	{
		this.persNr = new SimpleStringProperty(persNr);
		this.lastName = new SimpleStringProperty(lastName);
		this.firstName = new SimpleStringProperty(firstName);
		this.street = new SimpleStringProperty(street);
		this.town = new SimpleStringProperty(town);
		this.streetNumber = new SimpleStringProperty(streetNumber);
		this.zipCode = new SimpleStringProperty(zipCode);
		this.birthDate = new SimpleStringProperty(birthDate);
		this.birthPlace = new SimpleStringProperty(birthPlace);
		this.birthCountry = new SimpleStringProperty(birthCountry);
		this.svNr = new SimpleStringProperty(svNr);
		this.nationality = new SimpleStringProperty(nationality);
		this.currWork = new SimpleStringProperty(currWork);
		this.addInfo = new SimpleStringProperty(addInfo);
	}
	
	public String getPersNr()
	{
		return persNr.get();
	}
	
	public String getLastName()
	{
		return lastName.get();
	}
	
	public String getFirstName()
	{
		return firstName.get();
	}
	
	public String getStreet()
	{
		return street.get();
	}
	
	public String getStreetNumber()
	{
		return streetNumber.get();
	}
	
	public String getZipCode()
	{
		return zipCode.get();
	}
	
	public String getTown()
	{
		return town.get();
	}
	
	public String getBirthDate()
	{
		return birthDate.get();
	}
	
	public String getBirthPlace()
	{
		return birthPlace.get();
	}
	
	public String getBirthCountry()
	{
		return birthCountry.get();
	}
	
	public String getSVNr()
	{
		return svNr.get();
	}
	
	public String getNationality()
	{
		return nationality.get();
	}
	
	public String getCurrWork()
	{
		return currWork.get();
	}
	
	public String getAddInfo()
	{
		return addInfo.get();
	}
	
	public void setPersNr(String persNr)
	{
		this.persNr.set(persNr);
	}
	
	public void setLastName(String lastName)
	{
		this.lastName.set(lastName);
	}
	
	public void setFirstName(String firstName)
	{
		this.firstName.set(firstName);
	}
	
	public void setStreet(String street)
	{
		this.street.set(street);
	}
	
	public void setStreetNumber(String streetNumber)
	{
		this.streetNumber.set(streetNumber);
	}
	
	public void setZipCode(String zipCode)
	{
		this.zipCode.set(zipCode);
	}
	
	public void setTown(String town)
	{
		this.town.set(town);
	}
	
	public void setBirthDate(String birthDate)
	{
		this.birthDate.set(birthDate);
	}
	
	public void setBirthPlace(String birthPlace)
	{
		this.birthPlace.set(birthPlace);
	}
	
	public void setBirthCountry(String birthCountry)
	{
		this.birthCountry.set(birthCountry);
	}
	
	public void setSvNr(String svNr)
	{
		this.svNr.set(svNr);
	}
	
	public void setNationality(String nationality)
	{
		this.nationality.set(nationality);
	}
	
	public void setCurrWork(String currWork)
	{
		this.currWork.set(currWork);
	}
	
	public void setAddInfo(String addInfo)
	{
		this.addInfo.set(addInfo);
	}
}
