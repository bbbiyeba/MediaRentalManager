package mediaRentalManager;

import java.util.ArrayList;

public class Customer implements Comparable <Customer> {

	ArrayList<String> rentedQueue = new ArrayList<>();
	ArrayList<String> interestedQueue = new ArrayList<>();
	private String name, address, plan;

	private int newPlan = 2;

	/* Constructors */
	public Customer(String name, String address, String plan) {
		this.name = name;
		this.address = address;
		this.plan = plan;
		// this.rentedQueue = rentedQueue;
		// this.interestedQueue = interestedQueue;
	}

	public Customer() {
		this("Null", "Null", "Null");
	}
	
	public Customer(Customer customer) {
		this(customer.name, customer.address, customer.plan);
	}

	/* Getters */
	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public String getPlan() {
		return plan;
	}

	public int getNewPlan() {
		return newPlan;
	}

	public ArrayList<String> getRentedQueue() {
		return rentedQueue;
	}

	public ArrayList<String> getInterestedQueue() {
		return interestedQueue;
	}

	/* Setters */
	public void setName(String name) {
		this.name = name;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setPlan(String plan) {
		this.plan = plan;
	}

	public void setNewPlan(int newPlan) {
		this.newPlan = newPlan;
	}

	/* toString */
	@Override
	public String toString() {
		return "Name: " + name + "," + " Address: " + address + "," + " Plan: " + plan + "\nRented: "
				+ rentedQueue + "\nQueue: " + interestedQueue;
	}

	/* equals */
	@Override
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;

		Customer customer = (Customer) obj;
		// makes sure it's the same person
		return name.equals(customer.name);
	}
	
	
	/* compareTo */
	public int compareTo(Customer o) {
		return this.name.compareTo(o.name);
	}
	

	public void addToRequestQueue(String mediaTitle) {
		rentedQueue.add(mediaTitle);
	}

	public boolean removeTheRequestQueue(String mediaTitle) {
		if (mediaTitle != null) {
			// removes mediaTitle from interestedQueue
			interestedQueue.remove(mediaTitle);
			return true;
		}
		return false;
	}
}
