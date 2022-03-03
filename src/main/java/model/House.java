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
	int number;
	@Column(name="STREET")
	String street;
	@Column(name="CITY")
	String city;
	@Column(name="ZIP")
	int zip;
	
	// Constructors
	public House() {
		super();
	}
	
	public House(int number, String street, String city, int zip) {
		super();
		this.number = number;
		this.street = street;
		this.city = city;
		this.zip = zip;
	}

	public House(int id, int number, String street, String city, int zip) {
		super();
		this.id = id;
		this.number = number;
		this.street = street;
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

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
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
		return "House [id=" + id + ", number=" + number + ", street=" + street + ", city=" + city + ", zip=" + zip
				+ "]";
	}

}
