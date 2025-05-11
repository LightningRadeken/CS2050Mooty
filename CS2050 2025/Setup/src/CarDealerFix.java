import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class CarDealerFix 
{
	public static void main(String [] args) throws IOException
	{
		int row = 0;
		int col = 0;
		int year =0;
		double price = 100.50;
		String make = "unmake";
		String model = "unmodel";
		File file = new File("cars1.txt");
		BufferedReader fRead = new BufferedReader(new FileReader(file));
		int count = 0;
		while(fRead.readLine() != null)
		{
			count++;
		}
		fRead.close();
		Scanner scan = new Scanner(file);
		int[] rows = new int[count];
		int[] cols = new int[count];
		Car addCar = new Car(year,price,make,model);
		Car[][] carlist = new Car[5][5];
		for(int x = 0; x < count; x++)
		{
			row = scan.nextInt();
			col = scan.nextInt();
			rows[x] = row;
			cols[x] = col;
			addCar.setYear(scan.nextInt());
			addCar.setPrice(scan.nextDouble());
			addCar.setMake(scan.next());
			addCar.setModel(scan.next());
			carlist[rows[x]][cols[x]] = addCar;
		}
		scan.close();
		for(int c = 0; c < 5;c++)
		{
			for(int r = 0; r < 5; r++)
			{
				if(carlist[c][r] != null)
				{
					System.out.printf("[%d][%d]\nPrice: $%.2f\nYear: %d\nMake: %s\nModel: %s\n----------------------------------\n",r,c,carlist[r][c].getPrice(),
							carlist[r][c].getYear(),carlist[r][c].getMake(),carlist[r][c].getModel());
				}
				else
				{
					System.out.printf("[%d][%d]\nEmpty\nSlot\n----------------------------------\n",r,c);
				}
			}
		}
	}
}
class Car
{
	static double price;
	static int year;
	static String make;
	static String model;
	public Car()
	{
		
	}
	public Car(int year, double price, String make, String model)
	{
		this.year = year;
		this.price = price;
		this.make = make;
		this.model = model;
	}
	public String getMake()
	{
		return make;
	}
	public String getModel()
	{
		return model;
	}
	public int getYear()
	{
		return year;
	}
	public double getPrice()
	{
		return price;
	}
	public void setPrice(double price)
	{
		this.price = price;
	}
	public void setYear(int year)
	{
		this.year = year;
	}
	public void setMake(String make)
	{
		this.make = make;
	}
	public void setModel(String model)
	{
		this.model = model;
	}
}
