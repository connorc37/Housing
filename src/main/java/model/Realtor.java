package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="realtor")
public class Realtor {
	
	// Attributes
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String company;
	
	// Constructors
	public Realtor() {
		super();
	}
	
	public Realtor(String name) {
		super();
		this.name = name;
	}
	
	public Realtor(String name, String company) {
		super();
		this.name = name;
		this.company = company;
	}

	public Realtor(int id, String name, String company) {
		super();
		this.id = id;
		this.name = name;
		this.company = company;
	}
	
	// Getters & setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	// Methods
	@Override
	public String toString() {
		return "Realtor [id=" + id + ", name=" + name + ", company=" + company + "]";
	}
}
