//Malachi Mooty
//Project 1 Dealership Scenarios
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class CarVendingProject1 
{
	public static void main(String [] args) 
	{
		//empty 2d array for vending machine
		Car[][] myInv = new Car[5][5];
		//creation of vending machine
		VendingMachine VM = new VendingMachine(myInv);
		//Initial file for inventory of dealership
		File input = new File("cars1.txt");
		try 
		{
			//auto scanner for the file to populate the array
			Scanner entry = new Scanner(input);
			while(entry.hasNext())
			{
				//positions in 2d array for entry
				int row = entry.nextInt();
				int col = entry.nextInt();
				//creates a new car object for the array
				Car myCar = new Car(entry.nextInt(),entry.nextDouble(),entry.next(),entry.next());
				VM.addCar(row, col, myCar);	
			}
			entry.close();
		} 
		//statement that is run if file can't be found
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		//menu scanner titled after story 5 scenario
		Scanner Story5 = new Scanner(System.in);
		//loop break condition
		boolean loop = true;
		System.out.println("Welcome to the inventory system of Mooty Motors.\nHow may I assist you today?");
		//start of the loop
		while(loop == true)
		{
			System.out.println("\n\n1)Add a Car\n2)Display inventory\n3)Retrieve Vehicle\n4)Show Inventory(By Price)\n5)Show Inventory(By Year)"
					+ "\n6)Close System\n");
			int answer = Story5.nextInt();
			//option for adding cars to the vending machine of users choice
			if(answer == 1)
			{
				System.out.println("What is the make of your car?");
				String make = Story5.next();
				System.out.println("What is the model of your car?");
				String model = Story5.next();
				System.out.println("What is the year of your car?");
				int year = Story5.nextInt();
				System.out.println("What is the price of your car?");
				double price = Story5.nextDouble();
				Car newCar = new Car(year,price,make,model);
				System.out.println("Now look at the stock below: ");
				VM.DisplayInventory();
				System.out.println("\nWhat lot would you like to store vehicle in: ");
				int row = Story5.nextInt();
				System.out.println("What spot would you like to store vehicle in: ");
				int col = Story5.nextInt();
				if(VM.inventory[row][col] == null)
				{
					VM.addCar(row, col, newCar);
				}
				else
				{
					System.out.println("Car was not added. Now going back to beginning.");
				}
				
			}
			//retrieves and displays the inventory of the vending machine
			if(answer == 2)
			{
				VM.DisplayInventory();//Story 2 Scenario
			}
			//retrieve a vehicle for a customer
			if(answer == 3)
			{
				VM.Retrieve();//Story 4 Scenario
			}
			//sorts the actual inventory by price
			if(answer == 4)
			{
				System.out.print(VM.sortPrice());//Story 3 Scenario part 1
			}
			//sorts the actual inventory by year
			if(answer == 5)
			{
				System.out.print(VM.sortYear());//Story 3 Scenario part 2
			}
			//used to exit the loop
			if(answer == 6)
			{
				System.out.println("Have a good rest of your day.\n\n---Goodbye---");
				VM.PrintInventory();//Story 1 Scenario
				loop = false;
			}
		}
		Story5.close();
	}
}
class Car
{
	double price;
	int year;
	String make;
	String model;
	//Car constructor
	public Car(int year, double price, String make, String model)
	{
		this.year = year;
		this.price = price;
		this.make = make;
		this.model = model;
	}
	//getters for information display retrieval
	public int getYear()
	{
		return year;
	}
	public double getPrice()
	{
		return price;
	}
	public String getMake()
	{
		return make;
	}
	public String getModel()
	{
		return model;
	}
}
class VendingMachine
{
	//place holder 2d array for vending machine
	Car[][] inventory = new Car[5][5];
	//vending machine constructor
	public VendingMachine(Car[][] carlist)
	{
		inventory = carlist;
	}
	//sorting method for array by price
	public String sortPrice()
	{
		ArrayList<Car> list = new ArrayList<>();
		//loop for populating arrayList
		for(int r = 0; r < inventory.length; r++)
		{
			for(int c = 0; c< inventory[0].length; c++)
			{
				if (inventory[r][c] !=null)
				{
					list.add(inventory[r][c]);
				}
			}
		}
		Car[] carlist = new Car[list.size()];
		//loop for adding the objects from the array list into a 1d array for sorting
		for(int z = 0; z< list.size();z++)
		{
			carlist[z] = list.get(z);
		}
		//sorting method used in both sorts to list the cheapest price or later the oldest car first.
		int n = carlist.length;
		for(int x = 1; x < n;x++)
		{
			double key = carlist[x].getPrice();
			int y = x-1;
			while(y >=0 && carlist[y].getPrice() > key)
			{
				carlist[y+1].price = carlist[y].getPrice();
				y--;
			}
			carlist[y+1].price = key;
		}
		String sortedList = "";
		//populate the string accordingly for return to main.
		for(int car = 0; car < carlist.length; car++)
		{
			sortedList = sortedList+ "$"+carlist[car].getPrice()+" "+ carlist[car].getYear() + " " + carlist[car].getMake() + " "+carlist[car].getModel()+"\n";
		}
		System.out.println("");
		//returns a string format of the array
		return sortedList;
	}
	// sorts the array by year
	public String sortYear()
	{
		ArrayList<Car> list = new ArrayList<>();
		for(int r = 0; r < inventory.length; r++)
		{
			for(int c = 0; c< inventory[0].length; c++)
			{
				if (inventory[r][c] !=null)
				{
					list.add(inventory[r][c]);
				}
			}
		}
		Car[] carlist = new Car[list.size()];
		for(int z = 0; z< list.size();z++)
		{
			carlist[z] = list.get(z);
		}
		int n = carlist.length;
		for(int x = 1; x < n;x++)
		{
			int key = carlist[x].getYear();
			int y = x-1;
			while(y >=0 && carlist[y].getYear() > key)
			{
				carlist[y+1].year = carlist[y].getYear();
				y--;
			}
			carlist[y+1].year = key;
		}
		String sortedList = "";
		DecimalFormat money = new DecimalFormat("#.00");
		for(int car = 0; car < carlist.length; car++)
		{
			sortedList = sortedList+ ""+carlist[car].getYear()+" $"+ money.format(carlist[car].getPrice()) + " " + carlist[car].getMake() + " "+carlist[car].getModel()+"\n";
		}
		System.out.println("");
		return sortedList;
	}
	//method used for adding a car to the vending machine
	public void addCar(int row, int column, Car car)
	{
		//establishes the variables inputted
		Car vehicle = car;
		int r = row;
		int c = column;
		//adds the vehicle to the spot if able to
		if (inventory[r][c] == null)
		{
			inventory[r][c] = vehicle;
		}
		//message displayed if vehicle was added to an occupied spot.
		else
		{
			System.out.println("That spot is already taken. Car not added to inventory.");
		}
	}
	//method for displaying inventory to the user
	public void DisplayInventory()
	{
		//loop for formatted display
		for(int r = 0; r< inventory.length; r++)
		{
			for(int c = 0; c < inventory[0].length; c++)
			{
				if(inventory[r][c] == null)
				{
					System.out.printf("\n[%d][%d]\nEmpty\nSpot\n-----------------------------------",r,c);
				}
				else
				{
					System.out.printf("\n[%d][%d]\nPrice: $%.2f\nYear: %d\nMake: %s\nModel: %s\n-----------------------------------"
							,r,c,inventory[r][c].getPrice(),inventory[r][c].getYear(),inventory[r][c].getMake(),inventory[r][c].getModel());
				}
			}
		}
	}
	//method for looking at a specific spot to find a car
	public void Retrieve()
	{
		Scanner user = new Scanner(System.in);
		System.out.println("\n\nWhat lot is the car you are looking for?");
		int lot = user.nextInt();
		System.out.println("What spot is the car on this lot?");
		int spot = user.nextInt();
		if(inventory[lot][spot] != null)
		{
			System.out.println("Retrieving Car");
			try 
			{
				//timer for retrieval to act like a real system
				Thread.sleep(3000);
			} 
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
			System.out.printf("\n\n%d $%.2f %s %s\n",inventory[lot][spot].getYear(),inventory[lot][spot].getPrice(),
					inventory[lot][spot].getMake(),inventory[lot][spot].getModel());
		}
		else
		{
			System.out.println("The chosen spot seems to be empty.");
		}
	}
	//method for viewing inventory outside of program.
	public void PrintInventory()
	{
		File out = new File("inventory.txt");
		try 
		{
			PrintWriter writing = new PrintWriter(out);
			for(int r = 0; r< inventory.length; r++)
			{
				for(int c = 0; c < inventory[0].length; c++)
				{
					if(inventory[r][c] == null)
					{
						writing.printf("\n[%d][%d]\nEmpty\nSpot\n-----------------------------------",r,c);
					}
					else
					{
						writing.printf("\n[%d][%d]\nPrice: $%.2f\nYear: %d\nMake: %s\nModel: %s\n-----------------------------------"
								,r,c,inventory[r][c].getPrice(),inventory[r][c].getYear(),inventory[r][c].getMake(),inventory[r][c].getModel());
					}
				}
			}
			writing.close();
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		
	}
}
