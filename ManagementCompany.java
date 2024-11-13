/*
 * Class: CMSC203 
 * Instructor: Khandan Monshi
 * Description: Management company runs a company that has a plot and an array of properties.
 * Methods are available to manipulate the information of the company.
 * Due: 11/12/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
assignment independently. 
 * I have not copied the code from a student or any source. 
 * I have not given my code to any student.
 * Print your Name here: Nathaniel Schuknecht
*/

public class ManagementCompany {

	public static final int MAX_PROPERTY = 5;
	public static final int MGMT_DEPTH = 10;
	public static final int MGMT_WIDTH = 10;
	
	private String name;
	private String taxID;
	private double mgmFee;
	private Property[] properties;
	private Plot plot;
	private int numberOfProperties;
	
	public ManagementCompany() {
		name = "";
		properties = new Property[MAX_PROPERTY];
		
		plot = new Plot();
		plot.setWidth(MGMT_WIDTH);
		plot.setDepth(MGMT_DEPTH);
	}
	
	public ManagementCompany(String name, String taxID, double mgmFee) {
		this.name = name;
		this.taxID = taxID;
		this.mgmFee = mgmFee;
		properties = new Property[MAX_PROPERTY];
		
		plot = new Plot();
		plot.setWidth(MGMT_WIDTH);
		plot.setDepth(MGMT_DEPTH);
	}
	
	public ManagementCompany(String name, String taxID, double mgmFee, int x, int y, int width, int depth) {
		this.name = name;
		this.taxID = taxID;
		this.mgmFee = mgmFee;
		
		properties = new Property[MAX_PROPERTY];
		plot = new Plot(x, y, width, depth);
	}
	
	public ManagementCompany(ManagementCompany otherCompany) {
		name = otherCompany.name;
		taxID = otherCompany.taxID;
		mgmFee = otherCompany.mgmFee;
		
		properties = new Property[MAX_PROPERTY];
		for(int i = 0; i < otherCompany.properties.length; i++)
			properties[i] = otherCompany.properties[i];
		
		plot = new Plot(otherCompany.plot);
		numberOfProperties = otherCompany.numberOfProperties;
	}
	
	public int addProperty(String name, String city, double rent, String owner) {
		return addProperty(new Property(name, city, rent, owner));
	}
	
	public int addProperty(String name, String city, double rent, String owner, int x, int y, int width, int depth) {
		return addProperty(new Property(name, city, rent, owner, x, y, width, depth));
	}
	
	public int addProperty(Property property) {
		
		//Check if property can be added
		if(isPropertiesFull())
			return -1;
		else if(property == null)
			return -2;
		else if(plot.encompases(property.getPlot()))
			return -3;
		
		for(int i = 0; i < numberOfProperties; i++) 
			if(!properties[i].getPlot().overlaps(property.getPlot()))
				return -4;
		
		//Add property
		properties[numberOfProperties] = property;
		return numberOfProperties++;
	}
	
	public Property getHighestRentProperty(){
		
		if(numberOfProperties == 0)
			return null;
		
		//Find the highest rent
		Property highestRent = properties[0];
		for(int i = 1; i < numberOfProperties; i++)
			if(properties[i].getRentAmount() > highestRent.getRentAmount())
				highestRent = properties[i];
		
		return highestRent;
	}
	
	public double getMgmFeePer() {
		return mgmFee;
	}
	
	public String getName() {
		return name;
	}
	
	public Plot getPlot() {
		return new Plot(plot);
	}
	
	public Property[] getProperties() {
		Property[] toRet = new Property[MAX_PROPERTY];
		
		for(int i = 0; i<properties.length; i++)
			toRet[i] = properties[i];
		
		return toRet;
	}
	
	public int getPropertiesCount() {
		return numberOfProperties;
	}
	
	public String getTaxID() {
		return taxID;
	}
	
	public double getTotalRent() {
		
		double total = 0;
		
		for(int i = 0; i < numberOfProperties; i++)
			total+= properties[i].getRentAmount();
		
		return total;
	}
	
	public boolean isManagementFeeValid() {
		return mgmFee > 0 && mgmFee < 100;
	}
	
	public boolean isPropertiesFull() {
		return numberOfProperties == MAX_PROPERTY;
	}
	
	public void removeLastProperty() {
		properties[numberOfProperties - 1] = null;
		numberOfProperties--;
	}
	
	public String toString() {
		String toRet = "List of the properties for " + name + ", taxID: " + taxID;
		toRet+= "\n______________________________________________________\n";
		
		for(int i = 0; i < numberOfProperties; i++)
			toRet+= properties[i].toString() + "\n";
		
		toRet+= "______________________________________________________\n\n total management Fee: " + (getTotalRent()*mgmFee)/100;
		return toRet;
	}
}
