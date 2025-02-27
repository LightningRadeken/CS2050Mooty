//Mooty GE01 2D Array(D&D multi-Character generator) //even though this is for GE02
//Malachi Mooty
//all imported classes used
import java.util.Arrays;
import java.util.Random;

// program that is run through
public class MootyGE012DArray 
{
	//main program to run through object creation and displaying each object full in the array
	public static void main(String[] args)
	{
		//variables for character generation
		int[] stats = new int[6];
		int HP = 0;
		int AC = 0;
		int SPD = 0;
		String name = "";
		String race = "";
		String background = "";
		String alignment = "";
		String Class = "";
		//2d array for holding character objects
		Character[][] chaList = new Character[3][3];
		//loop for each row in 2d array (object creation)
		for(int i = 0; i <chaList.length;i++)
		{
			//loop for each column in 2d array (object creation)
			for(int j = 0;j<chaList[i].length;j++)
			{
				//base setup for character object
				Character player = new Character(name,stats,race
						,Class,background,alignment,HP,SPD,AC);
				//establish each variable of the character object
				player.setStats();
				player.setClass();
				player.setRace();
				player.setBackground();
				player.setAlignment();
				player.setName();
				//assign object to the array
				chaList[i][j] = player;
			}
		}
		//loop for each row in 2d array (object info display)
		for(int x = 0; x< chaList.length; x++)
		{
			//loop for each column in 2d array (object info display)
			for(int y = 0; y<chaList[x].length; y++)
			{
				//Print statement to display all information of the object in current index
				System.out.println(chaList[x][y].getName()+ " a " +chaList[x][y].getAlignment()+
						" "+chaList[x][y].getChaClass()+ " " +chaList[x][y].getRace() + "\nHP: "
						+chaList[x][y].getHP()+"   AC: "+chaList[x][y].getArmor()+ "   SPD: "
						+chaList[x][y].getSPD()+"ft\nStr: "+chaList[x][y].getStr()+ "   Dex: "+
						chaList[x][y].getDex()+ "   Con: "+chaList[x][y].getCon()+"\nInt: "+
						chaList[x][y].getInt()+"   Wis: "+chaList[x][y].getWis()+ "   Cha: "+
						chaList[x][y].getCha()+"\n");
			}
		}
	}
}
//class for character object
class Character
{
	//establish empty variables to be filled
	String chaName;
	int[] stats;
	String race;
	String chaClass;
	String Background;
	String align;
	int health;
	int armor;
	int speed;
	//Character constructor using variables from main class
	public Character(String name, int[] attributes,String species,
			String Class, String background, String Alignment, 
			int HP,int SPD, int AC)
	{
		//assigns the values from main to each associated variable in character class
		this.chaName = name;
		this.chaClass = Class;
		this.Background = background;
		this.align = Alignment;
		this.race = species;
		this.stats = attributes;
		this.speed = SPD;
		this.health = HP;
		this.armor = AC;
	}
	//method for randomly establishing a race for the character
	public void setRace()
	{
		//Min and max for random generation of base race selection
		int mainMin = 1;
		int mainMax = 9;
		// selects a number between 1 and 9 for the race selection
		int selectMain = new Random().nextInt(mainMax - mainMin 
				+1) +mainMin;
		// dragonborn path
		if (selectMain == 1)
		{
			//min and max for dragonborn type
			int subMin = 1;
			int subMax = 10;
			//establish the random type of dragonborn the character will be
			int selectSub = new Random().nextInt(subMax - subMin
					+1) +subMin;
			//assign stats and speed that all dragon born have
			speed = 30;
			stats[0] = stats[0] + 2;
			stats[2]++;
			//if statements to change race to the specific dragonborn type
			if(selectSub == 1)
			{
				race = "Black Dragonborn";
			}
			if(selectSub == 2)
			{
				race = "Blue Dragonborn";
			}
			if(selectSub == 3)
			{
				race = "Brass Dragonborn";
			}
			if(selectSub == 4)
			{
				race = "Bronze Dragonborn";
			}
			if(selectSub == 5)
			{
				race = "Copper Dragonborn";
			}
			if(selectSub == 6)
			{
				race = "Gold Dragonborn";
			}
			if(selectSub == 7)
			{
				race = "Green Dragonborn";
			}
			if(selectSub == 8)
			{
				race = "Red Dragonborn";
			}
			if(selectSub == 9)
			{
				race = "Silver Dragonborn";
			}
			if(selectSub == 10)
			{
				race = "White Dragonborn";
			}
		}
		//dwarf path
		if (selectMain == 2)
		{
			//min and max for dwarf type
			int subMin = 1;
			int subMax = 2;
			// selects between the two dwarf types
			int selectSub = new Random().nextInt(subMax - subMin
					+1) +subMin;
			//establish the stat change and speed that all dwarfs have
			stats[2]=stats[2]+2;
			speed = 25;
			//if statement for selecting between the two dwarf types
			if(selectSub == 1)
			{
				race = "Hill Dwarf";
				stats[4]++;
			}
			if(selectSub == 2)
			{
				race = "Mountain Dwarf";
				stats[0]= stats[0]+2;
				//gets more hp
				health++;
			}
		}
		//Elf path
		if (selectMain == 3)
		{
			//min and max for elf sub type selection
			int subMin = 1;
			int subMax = 3;
			//picks between the 3 elf types
			int selectSub = new Random().nextInt(subMax - subMin
					+1) +subMin;
			//stat change and speed set that all elves have
			speed = 30;
			stats[1] = stats[1]+2;
			//changing other stats and race based off of random number
			if(selectSub == 1)
			{
				race = "Dark Elf";
				stats[5]++;
			}
			if(selectSub == 2)
			{
				race = "High Elf";
				stats[3]++;
			}
			if(selectSub == 3)
			{
				race = "Wood Elf";
				//speed increase for the wood elf
				speed = speed +5;
				stats[4]++;
			}
		}
		//gnome path
		if (selectMain == 4)
		{
			//min and max for the gnome selection subrace
			int subMin = 1;
			int subMax = 2;
			//picks between the two gnome types
			int selectSub = new Random().nextInt(subMax - subMin
					+1) +subMin;
			//changes to speed and stats that all elves have
			speed = 25;
			stats[3] = stats[3]++;
			//if statement to establish which gnome type the character is
			if(selectSub == 1)
			{
				stats[1]++;
				race = "Forest Gnome";
			}
			if(selectSub == 2)
			{
				stats[2]++;
				race = "Rock Gnome";
			}
		}
		//Half-Elf path
		if (selectMain == 5)
		{
			//min and max for stat change selection for 2 extra skill points
			int min = 0;
			int max = 4;
			//establishes speed and race name
			race = "Half-Elf";
			speed = 30;
			int statChange;
			int count =0;
			//while loop for stat changes
			while(count < 2)
			{
				//randomly selects stat that isnt Cha for stat boost
				statChange = new Random().nextInt(max - min +1) +min;
				stats[statChange]++;
				count++;
			}
		}
		//halfling path
		if (selectMain == 6)
		{
			//min and max for halfling subrace
			int subMin = 1;
			int subMax = 2;
			//selects the subrace number to assign to character
			int selectSub = new Random().nextInt(subMax - subMin
					+1) +subMin;
			//boost to stats and establishment of speed for all halflings
			stats[1] = stats[1]+2;
			speed = 25;
			//if statements to choose between the halflings
			if(selectSub == 1)
			{
				race = "Lightfoot Halfling";
				stats[5]++;
			}
			if(selectSub == 2)
			{
				race = "Stout Halfling";
				stats[2]++;
			}
		}
		//Half-Orc path
		if (selectMain == 7)
		{
			//Establishes the race for half orc, speed, and stat changes
			race = "Half-Orc";
			speed = 30;
			stats[0] = stats[0] +2;
			stats[2]++;
		}
		//Human path
		if (selectMain == 8)
		{
			//min and max for random number generator
			int subMin = 1;
			int subMax = 2;
			//generates a 1 or 2 for human subtypes
			int selectSub = new Random().nextInt(subMax - subMin
					+1) +subMin;
			speed = 30;
			//if statements to establish race type and change stats
			if(selectSub == 1)
			{
				race = "Human";
				for (int count = 0; count < 6; count++)
				{
					stats[count]++;
				}
			}
			if(selectSub == 2)
			{
				int min = 0;
				int max = 5;
				int statChange;
				int count = 0;
				System.out.println("");
				while(count < 2)
				{
					statChange = new Random().nextInt(max - min +1) +min;
					stats[statChange]++;
					count++;
				}
				race = "Human Varient";
			}
		}
		//tiefling path
		if (selectMain == 9)
		{
			//establishes character as a tiefling and gives them the benefits that come with that
			stats[5] = stats[5] +2;
			stats[3]++;
			speed = 30;
			race = "Tiefling of Asmodeus";
		}
	}
	//method for setting the random character name
	public void setName()
	{
		//List of first names for male characters
		String[] firstNameM = {"Olric","Amon","Fennic","Rowan","Petero","Magnus","Logan","Vincent","Xorni","Zilic","Noa",
				"Urryn","Gunther","Yohan","Khan"};
		//List of first names for female characters
		String[] firstNameF = {"Rose","Charruni","Maven","Balka","Searen","Juleya","Luna","Wistina","Quinette","Freddrica",
				"Ariel", "Vanya", "Guilda", "Erica", "Hydee"};
		//List of last names for all characters(One left blank for those without a family name)
		String[] lastName = {" Blackfoot"," Oakblood"," Von Everitt"," Nova",""," Mamon"," Tempest"," Gemic"," Swallow",
				" Yggdra", " Ashborn", " Lionheart", " Genuva"," Locke", " Bloodmoon"};
		//min and max index for selection of names from arrays
		int min = 0;
		int max = 14;
		//int to be randomized for gender selection
		int select;
		//ints to be randomized for first and last name selection
		int nameSelectFirst;
		int nameSelectLast;
		//place holder variables for last and first names
		String lName;
		String fName;
		//min and max for gender selection
		int minG = 1;
		int maxG = 2;
		//selects 1 for male characters or 2 for female characters
		select = new Random().nextInt(maxG-minG+1)+minG;
		//male name generation
		if(select == 1)
		{
			nameSelectFirst = new Random().nextInt(max - min +1) +min;
			nameSelectLast = new Random().nextInt(max - min +1) +min;
			fName = firstNameM[nameSelectFirst];
			lName = lastName[nameSelectLast];
			//combines names into one
			chaName = fName +lName;
		}
		//female name generation
		if(select == 2)
		{
			nameSelectFirst = new Random().nextInt(max - min +1) +min;
			nameSelectLast = new Random().nextInt(max - min +1) +min;
			fName = firstNameF[nameSelectFirst];
			lName = lastName[nameSelectLast];
			//combines names into one
			chaName = fName +lName;
		}
	}
	//method for class selection
	public void setClass()
	{
		//min and max for index of Jobs
		int min = 0;
		int max = 12;
		//array of all Jobs(classes)
		String[] Jobs = {"Artificer","Barbarian","Bard","Cleric","Druid",
				"Fighter","Monk","Paladin","Ranger","Rogue","Sorcerer",
				"Warlock","Wizard"};
		//Randomly generates a number for class selection
		int picker = new Random().nextInt(max - min +1) +min;
		//if statements to establish character objects class, health, and armor
		if(picker == 0)
		{
			chaClass = Jobs[picker];
			health = 8 +((stats[2]-10)/2);
			armor = 12+((stats[1]-10)/2);
		}
		if(picker == 1)
		{
			chaClass = Jobs[picker];
			health = 12 +((stats[2]-10)/2);
			armor = 10+((stats[1]-10)/2) +((stats[2]-10)/2);
		}
		if(picker == 2)
		{
			chaClass = Jobs[picker];
			health = 8 +((stats[2]-10)/2);
			armor = 11+((stats[1]-10)/2);
		}
		if(picker == 3)
		{
			chaClass = Jobs[picker];
			health = 8 +((stats[2]-10)/2);
			armor = 11+((stats[1]-10)/2)+2;
		}
		if(picker == 4)
		{
			chaClass = Jobs[picker];
			health = 8 +((stats[2]-10)/2);
			armor = 11+((stats[1]-10)/2);
		}
		if(picker == 5)
		{
			chaClass = Jobs[picker];
			health = 10 +((stats[2]-10)/2);
			armor = 11+((stats[1]-10)/2);
		}
		if(picker == 6)
		{
			chaClass = Jobs[picker];
			health = 8 +((stats[2]-10)/2);
			armor = 10+((stats[1]-10)/2)+((stats[4]-10)/2);
		}
		if(picker == 7)
		{
			chaClass = Jobs[picker];
			health = 10 +((stats[2]-10)/2);
			armor = 16;
		}
		if(picker == 8)
		{
			chaClass = Jobs[picker];
			health = 10 +((stats[2]-10)/2);
			armor = 11+((stats[1]-10)/2);
		}
		if(picker == 9)
		{
			chaClass = Jobs[picker];
			health = 8 +((stats[2]-10)/2);
			armor = 11+((stats[1]-10)/2);
		}
		if(picker == 10)
		{
			chaClass = Jobs[picker];
			health = 6 +((stats[2]-10)/2);
			armor = 10+((stats[1]-10)/2);
		}
		if(picker == 11)
		{
			chaClass = Jobs[picker];
			health = 8 +((stats[2]-10)/2);
			armor = 11+((stats[1]-10)/2);
		}
		if(picker == 12)
		{
			chaClass = Jobs[picker];
			health = 6 +((stats[2]-10)/2);
			armor = 10+((stats[1]-10)/2);
		}
	}
	//method for setting a background to object
	public void setBackground()
	{
		//min and max index for background selection
		int min = 0;
		int max = 15;
		//selects a number to correspond with in pasts array
		int select = new Random().nextInt(max - min +1) +min;
		//array of all backgrounds
		String[] pasts = {"Acolyte","Charlatan","Criminal","Entertainer",
				"Folk Hero","Gladiator","Guild Artisan","Hermit",
				"Knight","Noble","Outlander","Pirate","Sage","Sailor",
				"Soldier","Urchin"};
		//assigns the selected past to background
		Background =pasts[select];
	}
	//method to assign an alignment
	public void setAlignment()
	{
		// min and max alignment index numbers
		int min = 0;
		int max = 8;
		//picks a number between 0-8 to make the index of the alignment
		int select = new Random().nextInt(max - min +1) +min;
		String[] Align = {"Lawful Good","Neutral Good","Chaotic Good"
				,"Lawful Neutral","True Neutral","Chaotic Neutral",
				"Lawful Evil","Neutral Evil","Chaotic Evil"};
		//assigns selected alignment to align for object
		align = Align[select];
	}
	//method for rolling your stats and assigning them
	public void setStats()
	{
		//for loop to assign to all stats
		for(int index = 0; index < stats.length;index++)
		{
			//min and max values of the roll
			int min =1;
			int max = 6;
			//dice rolls to generate each stat
			int dice1 = new Random().nextInt(max -min+1) +min;
			int dice2 = new Random().nextInt(max -min+1) +min;
			int dice3 = new Random().nextInt(max -min+1) +min;
			int dice4 = new Random().nextInt(max -min+1) +min;
			//array of the roll values
			int[] rolls = {dice1,dice2,dice3,dice4};
			//sorts the array to put the lowest in the first slot
			Arrays.sort(rolls);
			//adds all rolls besides the lowest roll to current stat location
			stats[index] = rolls[1] +rolls[2] +rolls[3];
		}
	}
	//returns the objects name
	public String getName()
	{
		return chaName;
	}
	//returns the objects class
	public String getChaClass()
	{
		return chaClass;
	}
	//returns the objects background
	public String getBackground()
	{
		return Background;
	}
	//returns the objects Alignment
	public String getAlignment()
	{
		return align;
	}
	//returns the objects Race
	public String getRace()
	{
		return race;
	}
	//returns the objects Individual stats
	public int getStr()
	{
		return stats[0];
	}
	public int getDex()
	{
		return stats[1];
	}
	public int getCon()
	{
		return stats[2];
	}
	public int getInt()
	{
		return stats[3];
	}
	public int getWis()
	{
		return stats[4];
	}
	public int getCha()
	{
		return stats[5];
	}
	//returns the objects speed
	public int getSPD()
	{
		return speed;
	}
	//returns the objects armor rating
	public int getArmor()
	{
		return armor;
	}
	//returns the objects HP
	public int getHP()
	{
		return health;
	}
}
