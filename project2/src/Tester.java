import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Tester {
	
	
	public static void main(String[] args) throws FileNotFoundException {
	

		File theFile = new File("houses.txt");
	
		Scanner read = new Scanner(theFile);
		ArrayList<House> houseList = new ArrayList<>();
		
		
		// declares a house object
		
		
		// reads through the file and creates house objects
		// that are added to houseList
		while (read.hasNextLine()) {
			String address = read.next();
			int price = read.nextInt();
			int area = read.nextInt();
			int numOfBedrooms = read.nextInt();
			House house = new House(address, price, area, numOfBedrooms);
			houseList.add(house);
		
			
		}
		String addressString = houseList.get(0).getAddress();
		System.out.println(addressString);

		
		//System.out.println(houseList);
	}
}

