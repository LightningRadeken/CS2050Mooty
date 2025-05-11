
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

//Main class to simulate the customer service queue system
public class L16LabCustomerServiceQueue
{
	public static void main(String[] args) 
	{
        Scanner scanner = new Scanner(System.in);
        CustomerQueue serviceQueue = new CustomerQueue();
        boolean running = true;

        while (running)
        {
            // Display menu options
            System.out.println("\n--- Customer Service Queue System ---");
            System.out.println("1. Add customer to queue");
            System.out.println("2. Serve next customer");
            System.out.println("3. View next customer");
            System.out.println("4. Display queue");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            if (scanner.hasNextInt()) 
            {
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) 
                {
                    case 1:
                        // Adding a customer to the queue
                        System.out.print("Enter customer name: ");
                        String name = scanner.next();
                        String issueType = selectIssueType(scanner);
                        serviceQueue.enqueue(new Customer(name, issueType));
                        break;

                    case 2:
                        // Serving the next customer
                        try {
                            Customer servedCustomer = (Customer) serviceQueue.dequeue();
                            System.out.println("Now serving: " + servedCustomer);
                        } catch (NoSuchElementException e) {
                            System.out.println(e.getMessage());
                        }
                        break;

                    case 3:
                        // Viewing the next customer in line
                        try {
                            System.out.println("Next in line: " + serviceQueue.peek());
                        } catch (NoSuchElementException e) {
                            System.out.println(e.getMessage());
                        }
                        break;

                    case 4:
                        // Displaying all customers in the queue
                        serviceQueue.displayQueue();
                        break;

                    case 5:
                        // Ending the program loop properly
                        running = false;
                        System.out.println("Customer Service System closing...");
                        break;

                    default:
                        System.out.println("Invalid choice! Please enter a number between 1-5.");
                }
            } else {
                System.out.println("Invalid input! Please enter a number between 1-5.");
                scanner.next(); // Clear invalid input
            }
        }

        scanner.close();
    }

    // Method to display an issue type menu and return selected issue type
    private static String selectIssueType(Scanner scanner) {
        System.out.println("\nSelect an issue type:");
        System.out.println("1. Billing");
        System.out.println("2. TechSupport");
        System.out.println("3. General");
        System.out.print("Enter your choice: ");

        int issueChoice = 0;
        boolean validInput = false;

        while (!validInput) {
            if (scanner.hasNextInt()) {
                issueChoice = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                if (issueChoice >= 1 && issueChoice <= 3) {
                    validInput = true;
                } else {
                    System.out.println("Invalid choice! Please enter 1, 2, or 3.");
                }
            } else {
                System.out.println("Invalid input! Please enter a number between 1-3.");
                scanner.next(); // Clear invalid input
            }
        }

        switch (issueChoice) {
            case 1:
                return "Billing";
            case 2:
                return "TechSupport";
            case 3:
                return "General";
            default:
                return "Unknown"; // Should never happen due to validation
        }
    }
}
class Customer
{
	private String name;
	private String issue;
	public Customer(String name, String issueType)
	{
		this.name = name;
		this.issue = issueType;
	}
	public String getName()
	{
		return name;
	}
	public String getIssue()
	{
		return issue;
	}
}
class CustomerQueue<T>
{
	private ArrayList<T> cusList;
	public CustomerQueue()
	{
		this.cusList = new ArrayList<>();
	}
	public boolean isEmpty() 
	{
        return this.cusList.isEmpty();
    }
	public void enqueue(T customer)
	{
		this.cusList.add(customer);
	}
	public T dequeue()
	{
		if (this.isEmpty()) 
		{
            throw new NoSuchElementException("Queue is empty.");
        }
        return this.cusList.remove(cusList.size() - 1);
	}
	public T peek()
	{
		if (this.isEmpty()) 
		{
            throw new NoSuchElementException("Queue is empty.");
        }
		Customer cus = (Customer) cusList.get(cusList.size() - 1);
        return (T) (cus.getName() + " for " + cus.getIssue());
	}
    public int size() 
    {
        return this.cusList.size();
    }

    public String displayQueue() 
    {
        if (!this.cusList.isEmpty()) 
        {
        	Customer cus = (Customer) cusList.get(0);
        	String display = cus.getName();
            for(int x = 1; x < cusList.size(); x++)
            {
            	cus = (Customer) cusList.get(x);
            	display = display + "," + cus.getName();
            }
            return display;
        } 
        else 
        {
            return "<<There is no one in Queue>>";
        }
    }
}

