//Malachi Mooty
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MootyGE01Polymorphism 
{
	public static void main(String[] args) throws FileNotFoundException
	{
		//initializing variables to be used
		String name;
		String food;
		int weight;
		int sleep;
		String location;
		//creating a file to extract information from and a scanner that takes information from that file 
		File input =  new File("Animal.txt");
		Scanner file = new Scanner (input);
		// this is to take the first line from the document to figure out 
		int count = Integer.parseInt(file.next());
		//counter for while statement
		int counter = 0;
		while(counter < count)
		{
			//creates an area for the animals that is as big as the count
			String[] Animals = new String[count];
			String type = file.next();
			Animals[counter] = type;
			//send the program onto bear if type equals Bear
			if (type.equals("Bear"))
			{
				//inputs values for the variables from the document
				name = file.next();
				food = file.next();
				weight = Integer.parseInt(file.next());
				sleep = Integer.parseInt(file.next());
				location = file.next() + " " + file.next();
				//establishes a bear
				Animal Bear = new Bear(name,food,weight,sleep,location);
				System.out.println("Animals[" + counter + "] is a " + Animals[counter]);
				System.out.println("Bear Name: " + Bear.getName()+" - Weighs: " 
				+Bear.getWeight() + " lbs - Sleeps: " + Bear.getSleep() + 
				" hrs - Location: " + Bear.getLocation());
				Bear.eat();
				Bear.sleep();
				Bear.swim();
			}
			//send the program onto elephant if type equals Elephant
			if (type.equals("Elephant"))
			{
				//inputs values for the variables from the document
				name = file.next();
				food = file.next();
				weight = Integer.parseInt(file.next());
				sleep = Integer.parseInt(file.next());
				location = file.next() + " " + file.next();
				//establishes an elephant
				Animal Elephant = new Elephant(name,food,weight,sleep,location);
				System.out.println("Animals[" + counter + "] is a " + Animals[counter]);
				System.out.println("Elephant Name: " + Elephant.getName()+" - Weighs: " 
				+Elephant.getWeight() + " lbs - Sleeps: " + Elephant.getSleep() + 
				" hrs - Location: " + Elephant.getLocation());
				Elephant.eat();
				Elephant.sleep();
				Elephant.swim();
			}
			//send the program onto monkey if type equals Monkey
			if (type.equals("Monkey"))
			{
				//inputs values for the variables from the document
				name = file.next();
				food = file.next();
				weight = Integer.parseInt(file.next());
				sleep = Integer.parseInt(file.next());
				location = file.next() + " " + file.next();
				//establishes a Monkey
				Animal Monkey = new Monkey(name,food,weight,sleep,location);
				System.out.println("Animals[" + counter + "] is a " + Animals[counter]);
				System.out.println("Monkey Name: " + Monkey.getName()+" - Weighs: " 
				+Monkey.getWeight() + " lbs - Sleeps: " + Monkey.getSleep() + 
				" hrs - Location: " + Monkey.getLocation());
				Monkey.eat();
				Monkey.sleep();
				Monkey.swim();
			}
			//send the program onto sloth if type equals Sloth
			if (type.equals("Sloth"))
			{
				//inputs values for the variables from the document
				name = file.next();
				food = file.next();
				weight = Integer.parseInt(file.next());
				sleep = Integer.parseInt(file.next());
				location = file.next() + " " + file.next();
				//established the sloth
				Animal Sloth = new Sloth(name,food,weight,sleep,location);
				System.out.println("Animals[" + counter + "] is a " + Animals[counter]);
				System.out.println("Sloth Name: " + Sloth.getName()+" - Weighs: " 
				+Sloth.getWeight() + " lbs - Sleeps: " + Sloth.getSleep() + 
				" hrs - Location: " + Sloth.getLocation());
				Sloth.eat();
				Sloth.sleep();
				Sloth.swim();
			}
			//extra line used for visual formating
			System.out.println("");			
			//adds to counter to move to next animal
			counter++;
			
		}
		//closes the scanner 
		file.close();
	}
}
class Animal
{
	//protected variables to be used by sub-classes
	protected String name = "";
	protected String food = "";
	protected int weight = 0;
	protected int sleep = 0;
	protected String location = "";
	public Animal()
	{
		
	}
	//constructor for the animal class taking in values
	public Animal(String name, String food, int weight, int sleep, String location)
	{
		this.name = name;
		this.food = food;
		this.weight = weight;
		this.sleep = sleep;
		this.location = location;
	}
	//all of these getters are used to return values to the called method for output
	public String getName()
	{
		return name;
	}
	public String getFood()
	{
		return food;
	}
	public int getWeight()
	{
		return weight;
	}
	public int getSleep()
	{
		return sleep;
	}
	public String getLocation()
	{
		return location;
	}
	//called outputs that are inherited or overriden in the subclasses
	public void eat()
	{
		System.out.println("Animal is eatting");
	}
	public void sleep()
	{
		System.out.println("Animal is sleeping");
	}
	public void swim()
	{
		System.out.println("Animal is swimming");
	}
	
}
class Bear extends Animal
{
	//Constructor for the Bear subclass of the animal class
	public Bear(String name, String food, int weight, int sleep, String location)
	{
		this.name = name;
		this.food = food;
		this.weight = weight;
		this.sleep = sleep;
		this.location = location;
	}
	//Bear overrides eat, sleep, and swim methods from the parent class Animal
	@Override
	public void eat()
	{
		System.out.println("Bear is eatting some " + this.getFood());
	}
	@Override
	public void sleep()
	{
		System.out.println("Bear is asleep -KEEP QUIET-");
		System.out.println("sleeping for the next " + this.getSleep() + " Hrs");
	}
	@Override
	public void swim()
	{
		System.out.println("Bear is swimming around");
	}
}
class Elephant extends Animal
{
	//Constructor for the Elephant subclass of the animal class
	public Elephant(String name, String food, int weight, int sleep, String location)
	{
		this.name = name;
		this.food = food;
		this.weight = weight;
		this.sleep = sleep;
		this.location = location;
	}
	//Elephant class overides the sleep class inherited from the super class Animal
	@Override
	public void sleep()
	{
		System.out.println("Elephant is taking a nap -KEEP IT DOWN-");
		System.out.println("sleeping for the next " + this.getSleep() + " Hrs");
	}
}
class Monkey extends Animal
{
	//Constructor for the Monkey subclass of the animal class
	public Monkey(String name, String food, int weight, int sleep, String location)
	{
		this.name = name;
		this.food = food;
		this.weight = weight;
		this.sleep = sleep;
		this.location = location;
	}
	//Monkey overides the eat and swin methods from super class Animal
	@Override
	public void eat()
	{
		System.out.println("Monkey is eatting some " + this.getFood() );
	}
	@Override
	public void swim()
	{
		System.out.println("Monkey is going for a swim");
	}
}
class Sloth extends Animal
{
	//Constructor for the Sloth subclass of the animal class
	public Sloth(String name, String food, int weight, int sleep, String location)
	{
		this.name = name;
		this.food = food;
		this.weight = weight;
		this.sleep = sleep;
		this.location = location;
	}
	//Sloth gets no overrides to the output of Animal super class
}
