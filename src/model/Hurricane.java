package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="hurricanes")
public class Hurricane {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="STORM_ID")
	private int stormId;
	@Column(name="STORMNAME")
	private String name;
	@Column(name="STORMYEAR")
	private int year;
	@Column(name="CATEGORY")
	private int category;
	
	public Hurricane() {
		
	}
	public Hurricane(String name, int year, int cat) {
		this.name = name;
		this.year = year;
		this.category = cat;
	}
	
	public int getId() {
		return this.stormId;
	}
	public void setId(int id) {
		this.stormId = id;
	}
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getYear() {
		return this.year;
	}
	public void setYear(int year) {
		this.year = year;
	}public int getCategory() {
		return this.category;
	}
	public void setCategory(int category) {
		this.category = category;
	}
	
	public String returnStormDetails() {
		return this.stormId + ": Hurricane " + this.name + " occurred in " + this.year + 
				" and was a Category " + this.category + " storm.";
	}
	public String toString() {
		return "Hurricane " + this.name + ", " + this.year + ", Cat " + this.category;
	}
	public String getAdded() {
		return "Thanks for adding Hurricane " + this.name + ", a Category " + this.category + " storm in " + this.year + "!";
	}
}
