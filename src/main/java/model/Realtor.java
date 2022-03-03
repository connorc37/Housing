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
	private String name;
	
	// Constructors
	public Realtor() {
		super();
	}
	
	public Realtor(String name) {
		super();
		this.name = name;
	}

	public Realtor(int id, String name) {
		super();
		this.id = id;
		this.name = name;
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

	// Methods
	@Override
	public String toString() {
		return "Realtor [id=" + id + ", name=" + name + "]";
	}

}
