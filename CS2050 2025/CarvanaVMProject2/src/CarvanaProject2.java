/*
 * Malachi Mooty
 * Car Vending Machine Project Iteration 2
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class CarvanaProject2 
{
	public static void main(String[] args) throws FileNotFoundException
	{
		/*
		 * This is the main section of code to run. 
		 * here we add out scanner for the rest of the program.
		 * After that we set up the vending machine so that we 
		 * can add the base files provided to the vending machine.
		 */
		Scanner input = new Scanner(System.in);
		File file = new File("cars1_02.txt");
		
		LinkedList<Car> carList = new LinkedList<>();
		VendingMachine VM = new VendingMachine(carList);
		/*
		 * Here we add the files provided with the assignment
		 * to the Vending Machine to run the car Emporium
		 */
		VM.LoadShipment(file, input);
		file = new File("cars2_02.txt");
		VM.LoadShipment(file, input);
		/*
		 * This is the beginning of the menu for the user.
		 * From here they can navigate to the different options
		 * and only leave once they choose the exit option
		 */
		System.out.println("\n\nWelcome to Mooty's Car Emporium\n");
		boolean running = true;
		while(running == true)
		{
			/*
			 * Here we swap the input scanner from files to
			 * System.in. from here we can choose the options
			 * moving forward and change the scanner in the
			 * other class methods.
			 */
			input = new Scanner(System.in);
			int usernum = 0;
			System.out.println("\n===Car Vending Machine Menu===\n1. Load a Car\n2. Display Inventory\n3. Retrieve a Car \n4. Print Sorted Inventory (Price)\n"
					+ "5. Print Sorted Inventory (Year)\n6. Search for Cars\n7. Add Car to Wash Queue\n8. Wash a Car\n9. Sell a Car\n10. Exit");
			usernum = input.nextInt();
			/*
			 * using usernum as a place holder we can navigate
			 * all of the options provided
			 */
			if(usernum == 1)
			{
				System.out.println("\nDo you want to:\n1. Load from file\n2.Enter Manually");
				int choice;
				choice = input.nextInt();
				if(choice == 1)
				{
					System.out.println("Enter full file info(example: cars1.txt):\n");
					String filename = input.next();
					file = new File(filename);
					VM.LoadShipment(file, input);
				}
				if(choice == 2)
				{
					System.out.println("Is your vehicle Premium or Basic");
					String option = input.next();
					option = option.toLowerCase();
					System.out.println("\nWhat floor do you want to store it on:\n");
					int floor = input.nextInt();
					System.out.println("\nWhat spot do you want:\n");
					int spot = input.nextInt();
					System.out.println("\nWhat is the year:\n");
					int year = input.nextInt();
					System.out.println("\nWhat is the price:\n");
					double price = input.nextDouble();
					System.out.println("\nWhat is the make:\n");
					String make = input.next();
					System.out.println("\nWhat is the model:\n");
					String model = input.next();
					if(option.equals("basic"))
					{
						Car newCar = new BasicCar(make,model,price,year,floor,spot);
						VM.addCar(newCar.getLocation(), newCar);
					}
					if(option.equals("premium"))
					{
						Car newCar = new PremiumCar(make,model,price,year,floor,spot);
						VM.addCar(newCar.getLocation(), newCar);
					}
					else
					{
						System.out.println("You entered something incorrectly. Now going back to the menu.");
					}
				}
				VM.PrintInventory();
			}
			/*
			 * This option follows story 2 where an employee is
			 * trying to display information about the inventory
			 * to a customer
			 */
			if(usernum == 2)
			{
				VM.DisplayInventory();
			}
			if(usernum == 3)
			{
				System.out.println("\nWhat floor is your vehicle located on:\n");
				int floor = input.nextInt();
				System.out.println("\nWhat spot is your vehicle located at:\n");
				int spot = input.nextInt();
				String locate = floor +"-"+spot;
				try 
				{
					VM.Retrieve(locate);
				} 
				catch (InterruptedException e) 
				{
					e.printStackTrace();
				}
			}
			/*
			 * Options 4 and 5 here run story number 4's options 
			 * where a dealer is trying to sort their inventory by
			 * either price or year
			 */
			if(usernum == 4)
			{
				String sort = "Price";
				VM.Sorting(sort);
			}
			if(usernum == 5)
			{
				String sort = "Year";
				VM.Sorting(sort);
			}
			/*
			 * Option 6 here is user story 6 where you have to take 
			 * user input for car type and manufacturer so that you
			 * can just display vehicles that match those inputs
			 */
			if(usernum == 6)
			{
				System.out.println("\nAre you looking for Premium or Basic?\n");
				String type = input.next();
				System.out.println("\nWhat manufacturer are you looking for?\n");
				String make = input.next();
				VM.searchMnT(type, make);
			}
			/*
			 * Options 7 and 8 follow the story 7 path where you
			 * ask the user to add a vehicle to the line for the car
			 * wash. Then in option 8 you can process one car at a time
			 */
			if(usernum == 7)
			{
				System.out.println("\nWhat floor is your vehicle located on:\n");
				int floor = input.nextInt();
				System.out.println("\nWhat spot is your vehicle located at:\n");
				int spot = input.nextInt();
				String locate = floor +"-"+spot;
				VM.washAdd(locate);
			}
			if(usernum == 8)
			{
				try 
				{
					VM.washProcess();
				} 
				catch (InterruptedException e) 
				{
					e.printStackTrace();
				}
			}
			/*
			 * Option 9 is the last story we needed to develop,
			 * In this option you remove a vehicle form the 
			 * dealership by selling it to a customer.
			 */
			if(usernum == 9)
			{
				System.out.println("\nWhat floor is your vehicle located on:\n");
				int floor = input.nextInt();
				System.out.println("\nWhat spot is your vehicle located at:\n");
				int spot = input.nextInt();
				String locate = floor +"-"+spot;
				VM.sellCar(locate);
			}
			/*
			 * Option 10 is used to break the loop and 
			 * allow the program to end.
			 */
			if(usernum == 10)
			{
				System.out.println("\nThank you for visiting!\n");
				running = false;
			}
		}
		input.close();
	}
}
abstract class Car
{
	/*
	 * Car is a abstract class object used to be the basis for
	 * premium and basic cars. Within this class we are able to 
	 * set up the methods to be used by the other car classes.
	 */
	private String location;
	private String make;
	private String model;
	private double price;
	private int year;
	private int floor;
	private int spot;
	public Car()
	{
		
	}
	public Car(String make, String model,double price,int year, int floor, int spot)
	{
		/*
		 * this section is for the construction of a car. These 
		 * variables get passed down to the subclasses of basic and
		 * premium cars.
		 */
		this.make = make;
		this.model = model;
		this.price = price;
		this.year = year;
		this.floor =floor;
		this.spot = spot;
		this.location = floor +"-"+spot;
	}
	/*
	 * Here are a bunch of getters to return values as need and an
	 * Abstract method for getting the type for each subclass.
	 */
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
	public String getLocation()
	{
		return location;
	}
	public int getFloor()
	{
		return floor;
	}
	public int getSpot()
	{
		return spot;
	}
	public abstract String getType();
}
class BasicCar extends Car
{
	/*
	 * The BasicCar object class used for construction of a Basic Car
	 * for the program.
	 */
	private String type;
	public BasicCar(String make, String model,double price,int year, int floor, int spot)
	{
		super(make,model,price,year,floor,spot);
		type = "Basic";
	}
	@Override
	public String getType()
	{
		return type;
	}
}
class PremiumCar extends Car
{
	/*
	 * The Premium Car object class used for construction of a 
	 * Premium Car for the program.
	 */
	private String type;
	public PremiumCar(String make, String model,double price,int year, int floor, int spot)
	{
		super(make,model,price,year,floor,spot);
		type = "Premium";
	}
	@Override
	public String getType()
	{
		return type;
	}
}
class VendingMachine
{
	/*
	 * This is the class where most of the program happens.
	 * We start with creation of our linked list that gets initalized
	 * by the main program. We also construct the queue for later
	 * in this class.
	 */
	Queue<Car> wash = new LinkedList<>();
	LinkedList<Car> VM = new LinkedList<>();
	public VendingMachine(LinkedList<Car> inventory)
	{
		VM=inventory;
	}
	/*
	 * Besides the constructor, this sorting method is the first method
	 * in the vending machine class. It takes user input from the main
	 * class and uses that to decide how to sort the Vending 
	 * Machine. This is done through an ArrayList and the sort
	 * method in the ArrayList class.
	 */
	public void Sorting(String sort)
	{
		List<Car> Cars = new ArrayList<>(VM);
		System.out.println();
		System.out.println("-----------------------------------------");
		if(sort =="Year")
		{
			Cars.sort(Comparator.comparing(Car::getYear));
			System.out.println("Sorting by Year:");
			
		}
		if(sort =="Price")
		{
			Cars.sort(Comparator.comparing(Car::getPrice));
			System.out.println("Sorting by Price:");
		}
		/*
		 * After sorting it prints out each individual vehicle in the
		 * order asked for.
		 */
		for(Car currentCar : Cars)
		{
			System.out.printf("\n[%s] %d %s %s $%.2f",currentCar.getLocation(),currentCar.getYear(),currentCar.getMake(),currentCar.getModel(),currentCar.getPrice());
		}
		System.out.println("\n-----------------------------------------");
	}
	/*
	 * This method is used to add user inputted vehicles from scanner
	 * inputs. It also is called by the LoadShipment to add the cars
	 * from a file source. This is how we populate the Vending 
	 * machine and our dealership.
	 */
	public void addCar(String location, Car car)
	{
		String locate = location;
		Car newCar = car;
		/*
		 * We are using a if statement to check for zeros in the
		 * floor and spot locations as their is no floor 0 or spot 0
		 * in our dealership.
		 */
		if(newCar.getFloor() == 0 || newCar.getSpot() == 0)
		{
			System.out.println("Car could not be added as the floor or spot was listed a 0.");
		}
		if(newCar.getFloor() != 0 && newCar.getSpot() != 0)
		{
			/*
			 * After verifying that our floor and spot aren't
			 * 0 we go into checking if the vending machine
			 * is empty. If it is we add the vehicle. If not
			 * we have to check to make sure that the location
			 * is available to store a vehicle. if not the car is not
			 * added to the vending machine.
			 */
			boolean empty = VM.isEmpty();
			if(empty == true)
			{
				VM.add(newCar);
			}
			if(empty == false)
			{
				boolean contain = false;
				for(Car cars : VM)
				{
					if(cars.getLocation().equals(locate))
					{
						contain = true;
					}
				}
				if(contain == false)
				{
					VM.add(newCar);
				}
			}
		}
		/*
		 * Finally we call the printinventory command so that we can 
		 * view inventory when we are not in the program. This isn't
		 * recalled when the program starts so if you reboot you will
		 * start from scratch.
		 */
		PrintInventory();
	}
	/*
	 * As stated before, LoadShipment is the file adding method that 
	 * sends each vehicle created to the addCar method for actual
	 * addition to vending machine.
	 */
	public void LoadShipment(File input,Scanner scan) throws FileNotFoundException
	{
		scan = new Scanner(input);
		/*
		 * This is the while loop for going through the file to add 
		 * cars to the vending machine linkedlist.
		 */
		while(scan.hasNext())
		{
			/*
			 * From scanner inputs we create the variables need for 
			 * the car classes construction. Hold is used for the
			 * transition into character for car type decision.
			 */
			String hold = scan.next();
			hold = hold.toLowerCase();
			char type = hold.charAt(0);
			int floor = scan.nextInt();
			int spot = scan.nextInt();
			int year = scan.nextInt();
			double price = scan.nextDouble();
			String make = scan.next();
			String model = scan.next();
			/*
			 * These if statements are used for deciding the type of
			 * car to be created. This is case insensitive do to hold
			 * being changed to lowercase.
			 */
			if(type == 'b')
			{
				Car newCar = new BasicCar(make,model,price,year,floor,spot);
				addCar(newCar.getLocation(), newCar);
			}
			if(type == 'p')
			{
				Car newCar = new PremiumCar(make,model,price,year,floor,spot);
				addCar(newCar.getLocation(), newCar);
			}
		}
	}
	/*
	 * This is a quick method used for listing out each of the cars
	 * within the vending machine and displaying them on the console.
	 */
	public void DisplayInventory()
	{
		System.out.println("");
		System.out.println("\n-----------------------------------------");
		for(Car cars : VM)
		{
			System.out.printf("\n[%s] %d %s %s $%.2f\n-----------------------------------------",cars.getLocation(),cars.getYear(),cars.getMake(),cars.getModel(),cars.getPrice());
		}
	}
	/*
	 * The retrieve method is to look up a specific locations vehicle
	 * and displaying it to the user via the console. In this method
	 * we added the cars from a linkedlist(VM) to a hashMap 
	 * in order to have the key location be able to pick only one
	 * vehicle.
	 */
	public void Retrieve(String locate) throws InterruptedException
	{
		Map<String, Car> carVM = new HashMap<>();
		for(Car cars : VM)
		{
			carVM.put(cars.getLocation(), cars);
		}
		if(carVM.containsKey(locate))
		{
			System.out.println("\nRetrieving Car");
			System.out.println("Car found!");
			Car foundCar = carVM.get(locate);
			System.out.printf("%d %s %s $%.3f",foundCar.getYear(),foundCar.getMake(),foundCar.getModel(),foundCar.getPrice());
		}
	}
	/*
	 * This search method is a more in depth search where the user
	 * is looking for specific car manufactures and car types to be 
	 * displayed.
	 */
	public void searchMnT(String type, String Make)
	{
		for(Car car: VM)
		{
			if(car.getType().toLowerCase().equals(type.toLowerCase()))
			{
				if(car.getMake().toLowerCase().equals(Make.toLowerCase()))
				{
					System.out.printf("\n%d %s %s $%.2f",car.getYear(),car.getMake(),car.getModel(),car.getPrice());
				}
			}
		}
		System.out.println("\n");
	}
	/*
	 * This is the queue addition method. With this method the user
	 * can add cars to the car wash queue and if they already are 
	 * in queue it will let them know. It also checks to see if a slot
	 * even has a car to add to the queue.
	 */
	public void washAdd(String Location)
	{
		boolean added=false;
		for(Car car:VM)
		{
			boolean listed = false;
			/*
			 * If statement to check for a car in the location
			 */
			if(car.getLocation().equals(Location))
			{
				boolean onQueue = false;
				/*
				 * Checks to see if a car is already in the queue
				 * based off of their location.
				 */
				for(Car cars : wash)
				{
					/*
					 * If the vehicle is already is wash queue
					 * this triggers to stop adding more and to 
					 * break from the loops.
					 */
					if(cars.getLocation().equals(Location))
					{
						onQueue = true;
						System.out.println("Car is already waiting in line.\n");
						added = true;
					}
				}
				/*
				 * If the car was found but was not in the queue
				 * this adds it to the queue.
				 */
				if(onQueue == false)
				{
					System.out.println("\n\nCar has been added to the washing line.");
					wash.add(car);
					added = true;
				}
			}
		}
		/*
		 * If there was no vehicle in the location this will trigger to
		 * let the user know.
		 */
		if(added==false)
		{
			System.out.println("\nWe can't seem to find the car you wanted to wash.");
		}
		/*
		 * method called to view the queue
		 */
		DisplayQueue();
	}
	/*
	 * This is a helpful method for the user to see what cars are 
	 * in the car wash queue.
	 */
	public void DisplayQueue()
	{
		System.out.println("\nWash Queue:\n-----------------------------------------------");
		for(Car car: wash)
		{
			System.out.printf("\n%d %s %s", car.getYear(),car.getMake(),car.getModel());
		}
		System.out.println("\n-----------------------------------------------");
	}
	/*
	 * This method is used for washing cars and removing them from
	 * the queue allowing them to be added again later,
	 */
	public void washProcess() throws InterruptedException
	{
		System.out.println("\n");
		/*
		 * If statement to check if the queue is empty and if not
		 * process the first vehicle added to the queue.
		 */
		if(wash.isEmpty())
		{
			System.out.println("No vehicles in car wash line.");
		}
		else
		{
			System.out.println("Washing car now!");
			System.out.println("Car has been washed");
			wash.remove();
		}
		DisplayQueue();
	}
	/*
	 * Method for printing the inventory to a file for viewing outside 
	 * of the program. This method doesn't get used when you restart 
	 * the program but does get over written at the start of the 
	 * program by the files provided with the assignment.
	 */
	public void PrintInventory()
	{
		File out = new File("VMinventory.txt");
		try 
		{
			PrintWriter write = new PrintWriter(out);
			for(Car cars : VM)
			{
				write.printf("[%s] %d %s %s $%.2f\n-------------------------------",cars.getLocation(),cars.getYear(),cars.getMake(),cars.getModel(),cars.getPrice());
			}
			write.close();
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
	}
	/*
	 * This is the final method used in the program. Its job is to 
	 * remove purchased cars from the vending machine allowing new 
	 * cars to be added to their location. It takes user input for 
	 * location and if a vehicle exist their it sells it to them. If 
	 * they enter an invalid location then the program lets them 
	 * know that the spot they are looking for seems to be empty.
	 */
	public void sellCar(String location)
	{
		boolean sold = true;
		for(Car car : VM)
		{
			/*
			 * Removes the vehicle if the location in question has 
			 * a vehicle stored in it.
			 */
			if(car.getLocation().equals(location))
			{
				
				Car carSold = car;
				System.out.printf("\nThe %d %s %s located at %s has been sold.", carSold.getYear(),carSold.getMake(), carSold.getModel(), carSold.getLocation());
				VM.remove(carSold);
				sold = false;
			}
		}
		/*
		 * If no vehicle was in the location it runs this section to 
		 * let the user know that the spot is empty.
		 */
		if (sold == true)
		{
			System.out.println("\nSeems like we couldn't find the car you were looking to purchase.");
		}
		PrintInventory();
	}
}
