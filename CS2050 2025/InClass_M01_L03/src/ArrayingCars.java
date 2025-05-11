import java.util.Random;

public class ArrayingCars 
{
	static public void main(String[] args)
	{
		//list of makes
		String[] Makes = {"Ford","Nissan","Cheverolt","Bentley", "Dodge", "Toyota"};
		//min and max for random number generator
		int min = 0;
		int max = 5;
		//2d array of cars
		Car[][] carList = new Car[3][3];
		//loop start for populating the 2d array
		for(int r = 0; r < carList.length; r++)
		{
			for(int c = 0; c < carList[0].length;c++)
			{
				//selects a number for the makes array
				int num = new Random().nextInt(max-min+1)+min;
				//make a car object with the number from makes array
				Car newCar = new Car(Makes[num]);
				//add object to 2d array
				carList[r][c] = newCar;
			}
		}
		for(int r = 0; r < carList.length; r++)
		{
			for(int c = 0; c < carList[0].length;c++)
			{
				carList[r][c].printMake();
				System.out.print(", ");
			}
			System.out.println("");
		}
		
	}
}
class Car
{
	private String make;
	// constructor for the car
	public Car() 
	{ 
		this.make = "Unknown"; 
	}
	// constructor taking in a make for the car
	public Car(String make) 
	{
 	   	this.make = make;
	}
	//if need prints the make of the specific car
	public void printMake() 
	{
		System.out.print(this.make + " ");
	}
}

