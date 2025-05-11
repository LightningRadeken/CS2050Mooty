import java.util.LinkedList;

public class LinkedListAddTest 
{
	public static void main(String[] args)
	{
		Marker m1 = new Marker("black","wide",6,"1-1");
		Marker m2 = new Marker("blue","fine",7,"2-3");
		Marker m3 = new Marker("red","wide",4,"3-5");
		Marker m4 = new Marker("purple","standard",8,"2-3");
		Marker m5 = new Marker("yellow","fine",3,"3-1");
		LinkedList<Marker> box = new LinkedList<>();
		Marker[] mBox = {m1,m2,m3,m4,m5};
		for(Marker markers : mBox)
		{
			
			if(box == null)
			{
				box.add(markers);
			}
			if(box != null)
			{
				boolean contain = false;
				for(Marker m : box)
				{
					if(markers.getSpot() == m.getSpot())
					{
						contain = true;
					}
				}
				if(contain ==false)
				{
					box.add(markers);
				}
			}
		}
		
		for (Marker mark : box)
		{
			System.out.printf("%s %din %s %s marker\n",mark.getSpot(), mark.getSize(),mark.getWidth(), mark.getColor());
		}
		
	}
}
class Marker
{
	String c;
	String t;
	int size;
	String spot;
	public Marker(String color, String thickness, int length, String spot)
	{
		this.c = color;
		this.t = thickness;
		this.size = length;
		this.spot = spot;
	}
	public String getSpot()
	{
		return spot;
	}
	public String getColor()
	{
		return c;
	}
	public String getWidth()
	{
		return t;
	}
	public int getSize()
	{
		return size;
	}
}
