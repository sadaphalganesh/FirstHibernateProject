package com.ganesh;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table(name="USER_DETAILS")
public class UserDetails {

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int userID;
	private String userName;
	
	/*@JoinTable(name="USER_VEHICLE",joinColumns=@JoinColumn(name="USER_ID"),
				inverseJoinColumns=@JoinColumn(name="VEHICLE_ID"))*/
	
    @ManyToMany
	private Collection<Vehicle> vehicles=new ArrayList<>();
	
	public Collection<Vehicle> getVehicles() {
		return vehicles;
	}
	public void setVehicles(Collection<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	

	
//TWO ADDRESSES FOR A SINGLE USER
	
/*	@Embedded
	@AttributeOverrides({
			@AttributeOverride(name="city",column=@Column(name="HOME_CITY")),
			@AttributeOverride(name="state",column=@Column(name="HOME_STATE")),
			@AttributeOverride(name="country",column=@Column(name="HOME_COUNTRY")),
			@AttributeOverride(name="pinCode",column=@Column(name="HOME_PINCODE"))
			
})
	private Address homeAddress;
	
	@Embedded
	private Address officeAddress;

	
	public Address getHomeAddress() {
		return homeAddress;
	}
	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}
	public Address getOfficeAddress() {
		return officeAddress;
	}
	public void setOfficeAddress(Address officeAddress) {
		this.officeAddress = officeAddress;
	}
	*/
	
	//USER IS HAVING MULTIPLE ADDRESSES.......THE FOLLOWING CREATES THE NEW ADRESS TABLE
		//BUT NOT ASSIGN A PRIMARY KEY ,,,SO INORDER TO HAVE IT WE HAVE TO USE ARRAYLIST

		/*@ElementCollection
		@JoinTable(name="USER_ADDRESS",
				joinColumns=@JoinColumn(name="USER_ID"))
		private Set<Address> listOfAddresses=new HashSet<>();
		
		public Set<Address> getListOfAddresses() {
			return listOfAddresses;
		}
		public void setListOfAddresses(Set<Address> listOfAddresses) {
			this.listOfAddresses = listOfAddresses;
		}*/
	
	//USING ARRAYLIST WE CAN CREATE THE PRIMARY KEY IN THE USER_ADDRESS TABLE
	//CHECK THE GENERIC GENERATOR STRATEGY FOR MYSQL DB .....
	
	/*@GenericGenerator(name="sequence",strategy="sequence")
	@CollectionId(columns = { @Column(name="ADDRESS_ID")}, generator = "sequence", type = @Type(type="long"))
	private Collection<Address> listOfAddresses=new ArrayList<Address>();
	
	
	public Collection<Address> getListOfAddresses() {
		return listOfAddresses;
	}
	public void setListOfAddresses(Collection<Address> listOfAddresses) {
		this.listOfAddresses = listOfAddresses;
	}*/

	//ONE TO ONE MAPPING
	/*@OneToOne
	@JoinColumn(name="VEHICLE_ID")
	private Vehicle vehicle;
	
	
	public Vehicle getVehicle() {
		return vehicle;
	}
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}*/
}
