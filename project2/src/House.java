/**
 * 
 * takes in values to creates a house object

 * and checks to see if that house object satisfies
 * the criteria
 * 
 * @author Corey Bright
 * @version October 04, 2022

 */

import java.text.DecimalFormat;
import java.util.ArrayList;

public class House {
	
	// ------------------------------------------------------------------
	// input String of address
	private String address;
	// ------------------------------------------------------------------
	// input int of price
	private int price;
	// ------------------------------------------------------------------
	// input int of area
	private int area;
	// ------------------------------------------------------------------
	// input int of bed rooms
	private int numBedrooms;
	
	
	/**
	 * The Constructor
	 * @param address : A string object
	 * @param price : A int object
	 * @param area : A int object
	 * @param numBedrooms : A int object
	 */
	public House(String address, int price, int area, int numBedrooms) {
		this.address = address;
		this.price = price;
		this.area = area;
		this.numBedrooms = numBedrooms;
	}

    public House() {

    }
    // ------------------------------------------------------------------
	/**
	 * 
	 * @param c : a criteria object
	 * @return boolean: result of if the criteria is meet or not
	 */
	public boolean satisfies(Criteria c) {
		int minPrice = c.getMinimumPrice();
		int maxPrice = c.getMaximumPrice();
		
		
		int minArea = c.getMinimumArea();
		int maxArea =  c.getMaximumArea();
		
		int minRooms  = c.getMinimumNumberOfBedrooms();
		int maxRooms  = c.getMaximumNumberOfBedrooms();
		
		if (minPrice > price || maxPrice < price 
				|| minArea > area || maxArea < area 
				|| minRooms > numBedrooms || maxRooms < numBedrooms) 
			return false;
					 
		return true;
			
	}
	// ------------------------------------------------------------------
	/**
	 * 
	 * makes a toString method
	 * that prints out a the address, price,area
	 * and number of bed rooms of a house
	 * 
	 * @return String: String of all the variables of a house object
	 * 
	 */
	public String toString() {
		DecimalFormat twoPlaces =new DecimalFormat("#,###.00");
		DecimalFormat zeroPlaces =new DecimalFormat("#,###");

		return "Address: " + address.replace('-', ' ') +
				", Price: $" + twoPlaces.format(price) +
				", Area: " + twoPlaces.format(area) + " sq. ft." +
				", Bedrooms: " + zeroPlaces.format(numBedrooms);
	}
	// ------------------------------------------------------------------
	
	/**
	 * get method for address
	 * @return
	 */
	public String getAddress() {
		return address;
	}
	// ------------------------------------------------------------------
	/**
	 * get method for price
	 * @return
	 */
	public int getPrice() {
		return price;
	}
	// ------------------------------------------------------------------
	/**
	 * get method for area
	 * @return
	 */
	public int getArea() {
		return area;
	}
	// ------------------------------------------------------------------
	/**
	 * get method for bed rooms
	 * @return
	 */
	public int getNumBedrooms() {
		return numBedrooms;
	}
	// ------------------------------------------------------------------



}
