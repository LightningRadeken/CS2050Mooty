import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Lecture15Lab 
{
	public static void main (String[] args) throws FileNotFoundException
	{
		String species;
		String name;
		int swimSpeed;
		File input = new File("bird.txt");
		Scanner entry = new Scanner(input);
		int animalCount = entry.nextInt();
		ArrayList<Bird> birdlist = new ArrayList<>();
		for(int birds = 0; birds< animalCount; birds++)
		{
			species = entry.next();
			name = entry.next();
			swimSpeed = entry.nextInt();
			if(species == "penguin")
			{
				Penguin penguin = new Penguin(species,name,swimSpeed);
				birdlist.add(penguin);
			}
			if(species == "duck")
			{
				Duck duck = new Duck(species,name,swimSpeed);
				birdlist.add(duck);
			}
			if(species == "sootytern")
			{
				SootyTern sootytern = new SootyTern(species,name,swimSpeed);
				birdlist.add(sootytern);
			}
			if(species == "ostrich")
			{
				Ostrich ostrich = new Ostrich(species,name,swimSpeed);
				birdlist.add(ostrich);
			}
		}
		for( int count = 0; count < birdlist.size(); count++)
		{
			if(birdlist.get(count).getSpecies() == "penguin")
			{
				System.out.println(birdlist.get(count).getName() + " is an " + birdlist.get(count).getSpecies());
				birdlist.get(count).funFact();
			}
			if(birdlist.get(count).getSpecies() == "duck")
			{
				System.out.println(birdlist.get(count).getName() + " is an " + birdlist.get(count).getSpecies());
				birdlist.get(count).funFact();
			}
			if(birdlist.get(count).getSpecies() == "sootytern")
			{
				System.out.println(birdlist.get(count).getName() + " is an " + birdlist.get(count).getSpecies());
				birdlist.get(count).funFact();
			}
			if(birdlist.get(count).getSpecies() == "ostrich")
			{
				System.out.println(birdlist.get(count).getName() + " is an " + birdlist.get(count).getSpecies());
				birdlist.get(count).funFact();
			}
		}
		ArrayList<Swimmer> Swimmers = new ArrayList<>();
		for(Bird birds : birdlist)
		{
			if (birds instanceof Swimmer)
			{
				Swimmers.add((Swimmer) birds);
			}
		}
		for(int num = 0; num < Swimmers.size(); num++)
		{
			
		}
	}
}
abstract class Bird
{
	private String species;
	private String name;
	private int swimSpeed;
	
	public Bird(String speices, String name, int swimSpeed)
	{
		this.species = speices;
		this.name = name;
		this.swimSpeed = swimSpeed;
	}
	public abstract void funFact();
	public String getSpecies()
	{
		return species;
	}
	public String getName()
	{
		return name;
	}
	public int getSwimSpeed()
	{
		return swimSpeed;
	}
}
interface Swimmer
{
	void Swim();
}
interface NonSwimmer
{
	void Drown();
}
class Penguin extends Bird implements Swimmer
{
	public Penguin(String spieces, String name, int swimSpeed)
	{
		super(spieces,name,swimSpeed);
	}

	@Override
	public void Swim() 
	{
		System.out.println(getName() +" is swimming.");
	}

	@Override
	public void funFact() 
	{
		System.out.println("I can't fly but I'm the fastest swimmer and deepest diver.");
	}
}
class Duck extends Bird implements Swimmer
{
	public Duck(String spieces, String name, int swimSpeed)
	{
		super(spieces,name,swimSpeed);
	}

	@Override
	public void Swim() 
	{
		System.out.println(getName() +" is swimming.");
	}

	@Override
	public void funFact() 
	{
		System.out.println("My highest documented flight was at 21,000 feet.");
	}
}
class SootyTern extends Bird implements NonSwimmer
{
	public SootyTern(String spieces, String name, int swimSpeed)
	{
		super(spieces,name,swimSpeed);
	}

	@Override
	public void Drown() 
	{
		System.out.println(getName() +" can't swim and will drown.");
	}

	@Override
	public void funFact() 
	{
		System.out.println("I spend most of my life at sea but can't swim.");
	}
}
class Ostrich extends Bird implements NonSwimmer
{
	public Ostrich(String spieces, String name, int swimSpeed)
	{
		super(spieces,name,swimSpeed);
	}

	@Override
	public void Drown() 
	{
		System.out.println(getName() +" can't swim and would drown.");
	}

	@Override
	public void funFact() 
	{
		System.out.println("Who needs flying when you're the biggest bird on earth.");
	}
}