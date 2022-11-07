/**
 *
 * Reads a file and loops through that file 


 * getting a value for address, price, area, bedroom
 * 
 * gets the houses that meets the correct criteria
 * and prints those houses
 * 
 * @author Corey Bright
 * @version October 4, 2022
 */


import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Random;
import java.util.Scanner;



public class HouseList {

	//----------------------------------------------------------------------
	// Resulting list of houses
	private ArrayList<House> houseList = new ArrayList<>();

	private ArrayList<String> housesPicked = new ArrayList<>();

	private Random random = new Random();

	// GUI Components
	private Stage myStage;

	private View HouseListView;
	private Scene currentScene;

	private String loginErrorMessage = "";
	private String transactionErrorMessage = "";
	private Boolean tryAgain = false;

	private int index;



	/**
	 *
	 * This reads a file and assigns
	 * variables to contents of file
	 *
	 * @param fileName: a String object
	 * @throws FileNotFoundException
	 */
	//-------------------------------------------------------------------
	public HouseList(String fileName) throws FileNotFoundException {

		// allows for reading of a file
		File theFile = new File(fileName);
		Scanner read = new Scanner(theFile);


		// declares a house object
		House house;

		// reads through the file and creates house objects
		// that are added to houseList
		while (read.hasNextLine()) {
			String address = read.next();
			int price = read.nextInt();
			int area = read.nextInt();
			int numOfBedrooms = read.nextInt();

			house = new House(address, price, area, numOfBedrooms);

			houseList.add(house);


			myStage = MainStageContainer.getInstance();


			createAndShowListingView();
		}

	}
	//-------------------------------------------------------------------	
	/**
	 *
	 * prints the houses from getHouses method
	 *
	 * @param c: a Criteria object
	 */
	public void printHouses(Criteria c) {
		//prints houses
			String houseString = getHouses(c);
			System.out.print(houseString);


	}

	/**
	 * gets the houses the meet the given criteria
	 *
	 * @param c : Criteria object
	 * @return
	 */
	//-------------------------------------------------------------------
	public String getHouses(Criteria c) {

		House house;
		String string = "";
		for (int i = 0 ; i < houseList.size(); i++) {
			house = houseList.get(i);
			if (house.satisfies(c)) {
				string += house + "\n";
			}
		}

		return string;


	}
	//----------------------------------------------------------
	public void processHouseList(Properties props) throws FileNotFoundException {
		String stringMinPrice = props.getProperty("MinimumPrice");
		String stringMaxPrice = props.getProperty("MaximumPrice");

		String stringMinArea = props.getProperty("MinimumArea");
		String stringMaxArea = props.getProperty("MaximumArea");

		String stringMinBed = props.getProperty("MinimumBed");
		String stringMaxBed = props.getProperty("MaximumBed");

		int minPrice = Integer.parseInt(stringMinPrice);
		int maxPrice = Integer.parseInt(stringMaxPrice);

		int minArea = Integer.parseInt(stringMinArea);
		int maxArea = Integer.parseInt(stringMaxArea);

		int minBed = Integer.parseInt(stringMinBed);
		int maxBed = Integer.parseInt(stringMaxBed);

		// creates criteria object from the user input
		Criteria criteria = new Criteria(minPrice, maxPrice, minArea, maxArea, minBed, maxBed);




		//System.out.println(criteria.toString());

		String houses = getHouses(criteria);

		//System.out.println(houses);


		String[] housesArray = houses.split("\\n");
		String houseChosen;

		String key = "ChosenHome";



		int upperBound = housesArray.length;


		if (upperBound == 0 || (upperBound == 1 && housesArray[0] == "")) {
			houseChosen = "No houses found!";
			HouseListView.updateState(key, "" + houseChosen);
			System.out.println("No houses");

		} else {

			System.out.println("houses");
			//gets the random house and format the string properly
			int randomNum = random.nextInt(upperBound);
			houseChosen = housesArray[randomNum];


			while(housesPicked.contains(houseChosen)) {


				randomNum = random.nextInt(upperBound);
				houseChosen = housesArray[randomNum];


//				for(int i = 0 ; i < housesPicked.size(); i ++) {
//					System.out.println(housesPicked.get(i));
//				}
//				for(int j = 0 ; j < housesArray.length; j ++ ) {
//					System.out.println(housesArray[j]);
//				}
				//System.out.println("House Array= " + housesArray.length);
				//System.out.println("House picked= " + housesPicked.size());

				if(housesPicked.size()  == housesArray.length) {
					System.out.println(("PLEASE STOP"));
					break;

				}

			}
			housesPicked.add(houseChosen);

			// changes key when the all houses have been chosen
			if(housesPicked.size()  == housesArray.length + 1) {
				houseChosen = "There are no more\nhomes to choose from!";
				key = "NoHomes";
				// resets the houses that have already been picked
				housesPicked.clear();

			}

//
//			System.out.println("houes picked " + housesPicked.size());
//			System.out.println("Houses avail " + housesArray.length);

			houseChosen = houseChosen.replace(", ", "\n");
			//System.out.println(houseChosen);

			// create an array of all previous house chosen
			HouseListView.updateState(key, "" + houseChosen);
		}

	}


	//------------------------------------------------------------

	public void processHouseListAgain() {
		System.out.println("TEST");
		int upperBound = houseList.size() -1;
		int newIndex = index;
		while(newIndex == index) {
			newIndex = random.nextInt(upperBound);
		}
		//chooses a house from that arrayList by random
		String houseChosen = houseList.get(newIndex).toString();
		//System.out.println(houseChosen);

		HouseListView.updateState("ChosenHome" ,"" + houseChosen);
	}

	//----------------------------------------------------------
	public void resetView()
	{
		createAndShowListingView();
	}



	//------------------------------------------------------------
	private void createAndShowListingView()
	{
		// create our initial view
		HouseListView = new HouseListView(this);
		// CREATE A SCENE WITH OUR NEW VIEW
		currentScene = new Scene(HouseListView);

// make the view visible by installing it into the stage
		swapToView(currentScene);
	}

	public void swapToView(Scene newScene)
	{
		if (newScene == null)
		{
			System.out.println
					("Listing.swapToView(): Missing view for display");
			return;
		}

		// SWAP THE SCENE ON THE STAGE
		myStage.setScene(newScene);
// RE-SIZE STAGE TO FIT NEW SCENE SIZE
		myStage.sizeToScene();
		//Place in center again
		WindowPosition.placeCenter(myStage);

	}

}


