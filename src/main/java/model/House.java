package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="house")
public class House {

	// Attributes
	@Id
	@GeneratedValue
	@Column(name="ID")
	private int id;
	@Column(name="NUMBER")
	int streetNumber;
	@Column(name="STREET")
	String streetName;
	@Column(name="CITY")
	String city;
	@Column(name="ZIP")
	int zip;

	// Constructors
	public House() {
		super();
	}
	
	public House(int id, int streetNumber, String streetName, String city, int zip) {
		super();
		this.id = id;
		this.streetNumber = streetNumber;
		this.streetName = streetName;
		this.city = city;
		this.zip = zip;
	}
	
	// Getters & setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(int streetNumber) {
		this.streetNumber = streetNumber;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getZip() {
		return zip;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}

	// Methods
	@Override
	public String toString() {
		return "House [id=" + id + ", streetNumber=" + streetNumber + ", streetName=" + streetName + ", city=" + city
				+ ", zip=" + zip + "]";
	}

}
