package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "realtor")
public class Realtor {
	
	// Attributes
	@Id
	@GeneratedValue
	private int id;
	private String realtorName;
	
	// Constructors
	public Realtor() {
		super();
	}
	
	public Realtor(int id, String realtorName) {
		super();
		this.id = id;
		this.realtorName = realtorName;
	}
	
	// Getters & setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRealtorName() {
		return realtorName;
	}

	public void setRealtorName(String realtorName) {
		this.realtorName = realtorName;
	}
	
	// Methods
	@Override
	public String toString() {
		return "Realtor [id=" + id + ", realtorName=" + realtorName + "]";
	}

}
