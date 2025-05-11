import java.util.*;

/**
 * 
 */
public class CollectionSortBooksLinkedList
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{

		// Step 1: Create a LinkedList (dynamic)
		LinkedList<Book> bookInventory = new LinkedList<>();

		bookInventory.add(new Book("Unmasking AI", "Dr. Joy Buolamwini", 2023));
		bookInventory.add(new Book("Hello World", "Hannah Fry", 2018));
		bookInventory.add(new Book("The Mathematics of Love", "Hannah Fry", 2015));
		bookInventory.add(new Book("Weapons of Math Destruction", "Cathy O’Neil", 2016));
		bookInventory.add(new Book("Race After Technology", "Ruha Benjamin", 2019));

		System.out.println("Original LinkedList of books:");
		for (Book currentBook : bookInventory)
		{
			System.out.println(currentBook);
		}

		System.out.println();

		// Step 2: Convert to ArrayList for sorting
		List<Book> books = new ArrayList<>(bookInventory);

		// Step 3: Sort by Title
		System.out.println("Books sorted by title:");
		books.sort(Comparator.comparing(Book::getTitle));
		for (Book currentBook : books)
		{
			System.out.println(currentBook);
		}

		System.out.println();

		// Step 4: Sort by year (newest to oldest)
		// add code
		System.out.println("Books sorted by Year:");
		books.sort(Comparator.comparing(Book::getYear));
		for (Book currentBook : books)
		{
			System.out.println(currentBook);
		}
		System.out.println();

		// Step 5: Sort by author then title
		// add code
		System.out.println("Books sorted by Author:");
		books.sort(Comparator.comparing(Book::getAuthor).thenComparing(Book::getTitle));
		for (Book currentBook : books)
		{
			System.out.println(currentBook);
		}
		System.out.println();
		System.out.println();
		
		// Step 6: Add Queue for signing out books
        Queue<Book> signOutQueue = new LinkedList<>();
        // Simulate students requesting to sign out books
        signOutQueue.add(bookInventory.get(0)); // Unmasking AI
        signOutQueue.add(bookInventory.get(2)); // Weapons of Math Destruction
        
        System.out.println(); 
        
        System.out.println("Sign-out queue:");
        for (Book currentBook : signOutQueue) 
        {
            System.out.println(currentBook);
        }
        System.out.println();
        // Step 7: Process the sign-out queue
        ArrayList<Book> signedOut = new ArrayList<>();
        System.out.println("Processing sign-outs:");
        
        for (Book currentBook : signOutQueue)
        {
        	System.out.println(currentBook + " is signed out.");
        	signedOut.add(currentBook);
        	bookInventory.remove(currentBook);
        }
        System.out.println("");
        System.out.println("Signed Out Books:");
        for(Book currentBook : signedOut)
        {
        	System.out.println(currentBook);
        }
        // add code
        System.out.println("");
        System.out.println("Signing books in:");
        Queue<Book> signInQueue = new LinkedList<>();
        
        signInQueue.add(signedOut.get(0));
        signInQueue.add(signedOut.get(1));
        System.out.println("");
        for(Book currentBook : signInQueue)
        {
        	System.out.println(currentBook + " is signed in.");
        	bookInventory.add(currentBook);
        	signedOut.remove(currentBook);
        }
        System.out.println("");
        
        //Step 8: Search by author
        System.out.println("\nSearching for books by Hannah Fry:");
        List<Book> searchBooksResult = findBooksByAuthor(bookInventory, "Hannah Fry");
        printBooks(searchBooksResult, "Hannah Fry", -1);
        
        //Step 9: search books by author and year
        //create a method that
        List<Book> foundBooks = findBooks(bookInventory, "Hannah Fry", 2018);
        //if their are books by author and year it adds displays it
        //Otherwise it says their is no books by that author during that year.
        printBooks(foundBooks, "Hannah Fry", 2018);
        
        System.out.println();
        
        // Step 10: Use HashMap to organize books by title
        System.out.println("\nStep 10 HashMap of books by title:");
        Map<String, Book> bookMapByTitle = new HashMap<>();
        //Using for loop to create hashmap quickly for book titles
        //Remember title must be unique
        Scanner userinput = new Scanner(System.in);
        addBook(bookInventory, userinput);
        for (Book book : bookInventory) 
        {
            bookMapByTitle.put(book.getTitle(), book);  // key = title, value = book
        }
        System.out.println();
        BookSearch(bookMapByTitle, userinput);
        userinput.close();

    }
	public static List<Book> findBooksByAuthor(List<Book> inventory, String author) 
	{
	    List<Book> results = new ArrayList<>();
	    for (Book currentBook : inventory) 
	    {
	        if (currentBook.getAuthor().equalsIgnoreCase(author)) 
	        {
	            results.add(currentBook);
	        }
	    }
	    return results;
	}
	public static LinkedList<Book> addBook(LinkedList<Book> bookInventory, Scanner input)
	{
		String title;
        String author;
        int year;
        System.out.println("Adding new Book:");
        System.out.println("What is the Title?");
        title = input.nextLine();
        System.out.println("What is the name of the Author?");
        author = input.nextLine();
        System.out.println("When did the book come out?");
        year = input.nextInt();
        bookInventory.add(new Book(title, author, year));
        return bookInventory;
	}
	public static void BookSearch(Map<String, Book> bookMapByTitle, Scanner input)
	{
		String title;
        System.out.println("Enter the Title of the book you are looking for: ");
        input.nextLine();
        title = input.nextLine();
        System.out.println();
        if(bookMapByTitle.containsKey(title))
        {
        	System.out.println("Found book: " + bookMapByTitle.get(title));
        }
        else 
        {
            System.out.println("Book not found: " + title);
        }
	}
	
	public static List<Book> findBooks(List<Book> inventory, String author, int year) 
	{
		//creates list for return statement
	    List<Book> results = new ArrayList<>();
	    //goes through the inventory for each book
	    for(Book currentBook : inventory)
	    {
	    	//checks to see if author matches
	    	if(currentBook.getAuthor() == author)
	    	{
	    		//checks to see if the year matches as well
	    		if(currentBook.getYear() == year)
	    		{
	    			//adds results to the list
	    			results.add(currentBook);
	    		}
	    	}
	    }

	    return results;
	}
	
	public static void printBooks(List<Book> books, String author, int year) 
	{
	    String label;
	    if (year != -1) 
	    {
	        label = " in " + year;
	    } 
	    else 
	    
	    {
	        label = "";
	    }

	    if (books.isEmpty()) 
	    {
	        System.out.println("\nNo books found by " + author + label + ".");
	    } 
	    else 
	    {
	        System.out.println("\nBooks by " + author + label + ":");
	        for (Book currentBook : books) {
	            System.out.println(currentBook);
	        }
	    }
	}


	
	
}

class Book
{
	private String title;
	private String author;
	private int year;

	public Book(String title, String author, int year)
	{
		this.title = title;
		this.author = author;
		this.year = year;
	}

	public String getTitle()
	{
		return title;
	}

	public String getAuthor()
	{
		return author;
	}

	public int getYear()
	{
		return year;
	}

	public String toString()
	{
		return title + " by " + author + " (" + year + ")";
	}
}
