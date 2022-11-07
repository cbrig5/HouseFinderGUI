/**
 * Takes in user input and


 * creates a criteria object from that input, and
 * creates a house object from the houses.txt file, than
 * prints the houses using the printHouses method
 * 
 * @author Corey Bright
 * @version October 04, 2022
 */

import java.io.FileNotFoundException;
import java.util.Scanner;


public class HouseListTester {
	
	
	/**
	 * 
	 * main method that allows user to input method
	 * and prints results
	 * 
	 * @param args : String[] object
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException {
		

		// declares minimum price
		int minPrice;

		// declares maximum price
		int maxPrice;
		// declares minimum area
		int minArea;
	
		// declares maximum area
		int maxArea;

		// declares minimum beds
		int minBeds;

		// declares maximum beds
		int maxBeds;

		// sets loop equal to 1 to start loops
		int loop = 1;

		// declares and initializes scanner object
		Scanner scanner = new Scanner(System.in);


	
		// starts loop while loop is equal to 1
		while (loop != 0) {
	
			System.out.println("Minimum price:");
			minPrice = scanner.nextInt(); // initializes minimum price
		
			System.out.println("Maximum price:");
			maxPrice = scanner.nextInt();  // initializes maximum price
			
			System.out.println("Minimum area:");
			minArea = scanner.nextInt();  // initializes minimum area
			
			System.out.println("Maximum area:");
			maxArea = scanner.nextInt(); // initializes maximum area
			
			System.out.println("Minimum beds:");
			minBeds = scanner.nextInt();  // initializes minimum beds
	
			System.out.println("Maximum beds:");
			maxBeds = scanner.nextInt(); // initializes maximum beds
			
			// creates criteria object from the user input
			Criteria criteria = new Criteria(minPrice, maxPrice, minArea, maxArea, minBeds, maxBeds);
			// declares and initializes houseList object
		//	HouseList houseList = new HouseList("houses.txt");

			
			// prints out houses that match the criteria
			//houseList.printHouses(criteria);
			
			
			System.out.println("Enter \"0\" to exit, else enter any other number to continue: ");
			loop = scanner.nextInt(); // allows user to exit or continue program 
		
		} 
	} 
	
	//-------------------------------------------------------------------

}
