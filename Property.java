/*
 * Class: CMSC203 
 * Instructor: Khandan Monshi
 * Description: Property represents a single property of a company. Each property
 * has a plot of land and can manipulate its data. Methods are used to change the 
 * property's data.
 * Due: 11/12/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
assignment independently. 
 * I have not copied the code from a student or any source. 
 * I have not given my code to any student.
 * Print your Name here: Nathaniel Schuknecht
*/


public class Property {

	private String propertyName;
	private String city;
	private double rentAmount;
	private String owner;
	private Plot plot;
	
	public Property() {
		
		propertyName = "";
		city = "";
		owner = "";
		plot = new Plot();
	}
	
	public Property(String propertyName, String city, double rentAmount, String owner) {
	
		this.propertyName = propertyName;
		this.city = city;
		this.rentAmount = rentAmount;
		this.owner = owner;
		plot = new Plot();
	}
	
	public Property(String propertyName, String city, double rentAmount, String owner, int x, int y, int width, int depth) {
		
		this.propertyName = propertyName;
		this.city = city;
		this.rentAmount = rentAmount;
		this.owner = owner;
		plot = new Plot(x, y, width, depth);
	}
	
	public Property(Property otherProperty) {
		this(otherProperty.propertyName, otherProperty.city, otherProperty.rentAmount, otherProperty.owner, otherProperty.plot.getX(), otherProperty.plot.getY(), otherProperty.plot.getWidth(), otherProperty.plot.getDepth());
	}
	
	public Plot getPlot() {
		return new Plot(plot);
	}
	
	public String getPropertyName() {
		return propertyName;
	}
	
	public String getCity() {
		return city;
	}
	
	public double getRentAmount() {
		return rentAmount;
	}
	
	public String getOwner() {
		return owner;
	}
	
	public String toString() {
		return propertyName + "," + city + "," + owner + "," + rentAmount;
	}
}
