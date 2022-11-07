/**
 * 
 * Takes in values from the user

 * and assings those values to a
 * variable
 * 
 * @author Corey Bright
 * @version October 04, 2022
 */

public class Criteria {
	

	//-------------------------------------------------------------------
	// input of minimum price
	private int minimumPrice;
	//-------------------------------------------------------------------
	// input of maximum price
	private int maximumPrice;
	//-------------------------------------------------------------------
	// input of minimum area
	private int minimumArea;
	//-------------------------------------------------------------------
	// input of minimum area
	private int maximumArea;
	//-------------------------------------------------------------------
	// input of minimum bed rooms
	private int minimumNumberOfBedrooms;
	//-------------------------------------------------------------------
	// input of maximum bed rooms
	private int maximumNumberOfBedrooms;
	
	//-------------------------------------------------------------------

	/**
	 * 
	 * The Constructor
	 * 
	 * @param minimumPrice : int object
	 * @param maximumPrice : int object
	 * @param minimumArea : int object
	 * @param maximumArea : int object
	 * @param minimumNumberOfBedrooms : int object
	 * @param maximumNumberOfBedrooms : int object
	 * 
	 */
	public Criteria(int minimumPrice,int maximumPrice,
			int minimumArea, int maximumArea,
			int minimumNumberOfBedrooms, int maximumNumberOfBedrooms) {
		
		this.minimumPrice = minimumPrice;
		this.maximumPrice = maximumPrice;
		this.minimumArea = minimumArea;
		this.maximumArea = maximumArea;
		this.minimumNumberOfBedrooms = minimumNumberOfBedrooms;
		this.maximumNumberOfBedrooms = maximumNumberOfBedrooms;
		
	
	}
	//-------------------------------------------------------------------
	/**
	 *  get method for minimum price
	 * @return
	 */
	public int getMinimumPrice() {
		return minimumPrice;
	}
	//-------------------------------------------------------------------
	/**
	 *  get method for maximum price
	 * @return
	 */
	public int getMaximumPrice() {
		return maximumPrice;
	}
	//-------------------------------------------------------------------
	/**
	 *  get method for minimum area
	 * @return
	 */
	public int getMinimumArea() {
		return minimumArea;
	}
	//-------------------------------------------------------------------
	/**
	 *  get method for maximum area
	 * @return
	 */
	public int getMaximumArea() {
		return maximumArea;
	}
	//-------------------------------------------------------------------
	/**
	 *  get method for minimum bed rooms
	 * @return
	 */
	public int getMinimumNumberOfBedrooms() {
		return minimumNumberOfBedrooms;
	}
	//-------------------------------------------------------------------
	/**
	 *  get method for maximum bed rooms
	 * @return
	 */
	public int getMaximumNumberOfBedrooms() {
		return maximumNumberOfBedrooms;
	}
	
}

