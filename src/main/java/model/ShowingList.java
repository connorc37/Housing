
package model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class ShowingList {
	
	// Attributes	
	@Id
	@GeneratedValue
	private int id;
	private String showingName;
	private LocalDate showingDate;
	@ManyToOne (cascade=CascadeType.PERSIST)
	private Realtor realtor;
	@OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	private List<House> listOfShowings;

	// Constructors
	public ShowingList() {
		super();
	}
	
	public ShowingList(String showingName, LocalDate showingDate, Realtor realtor, List<House> listOfShowings) {
		super();
		this.showingName = showingName;
		this.showingDate = showingDate;
		this.realtor = realtor;
		this.listOfShowings = listOfShowings;
	}

	public ShowingList(int id, String showingName, LocalDate showingDate, Realtor realtor, List<House> listOfShowings) {
		super();
		this.id = id;
		this.showingName = showingName;
		this.showingDate = showingDate;
		this.realtor = realtor;
		this.listOfShowings = listOfShowings;
	}
	
	// Getters & setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getShowingName() {
		return showingName;
	}

	public void setShowingName(String showingName) {
		this.showingName = showingName;
	}

	public LocalDate getShowingDate() {
		return showingDate;
	}

	public void setShowingDate(LocalDate showingDate) {
		this.showingDate = showingDate;
	}

	public Realtor getRealtor() {
		return realtor;
	}

	public void setRealtor(Realtor realtor) {
		this.realtor = realtor;
	}

	public List<House> getListOfShowings() {
		return listOfShowings;
	}

	public void setListOfShowings(List<House> listOfShowings) {
		this.listOfShowings = listOfShowings;
	}
	
	// Methods
	@Override
	public String toString() {
		return "ShowingList [id=" + id + ", showingName=" + showingName + ", showingDate=" + showingDate + ", realtor="
				+ realtor + ", listOfShowings=" + listOfShowings + "]";
	}

}
