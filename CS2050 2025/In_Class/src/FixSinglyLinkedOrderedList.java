/**
 * 
 */

/**
 * 
 */
// Malachi Mooty
public class FixSinglyLinkedOrderedList
{

	// Test the Singly Linked List
	public static void main(String[] args)
	{


		SinglyLinkedListFix list = new SinglyLinkedListFix();
		list.insertNode(4);
		list.insertNode(2);
		list.insertNode(8);
		list.insertNode(3);

		list.printList();
		list.deleteNode(0);
		list.deleteNode(3);
		list.printList();

	}

}


class NodeFix 
{
    int data;
    NodeFix next;

    public NodeFix(int data) 
    {
        this.data = data;
        this.next = null;
    }
}

class SinglyLinkedListFix 
{
	NodeFix head;

    // BUGGY insertNode method
    public void insertNode(int number) 
    {
    	NodeFix newNode = new NodeFix(number);
    	//add Temp to hold front of linkedlist
    	NodeFix Temp = head;
    	NodeFix current = head;
    	NodeFix previous = null;
    	//loop is for counter on list
    	int loop = 0;
        while (current != null && current.data < number) 
        {
        	//loops only for inital as that is all the code currently needs.
        	//Will need change if adding more out of order
        	if(loop == 0&& head != null)
        	{
        		Temp.data= head.data;
        	}
        	previous = current;
            current = current.next;
            //add loop increaser for if statement loops are add more than inital.
            loop++;
        }
        if (previous == null) 
        {
            newNode.next = head;
            head = newNode;
        }
        //changed else into this new if statement to catch reorganizing of LinkedList
        if (previous != null)
        {
        	//adds what is past the node to the end of new node and then adds that new node to the end
        	//of the temp node before adding it to the head.
        	if(previous.next != null)
        	{
        		newNode.next = current;
            	Temp.next = newNode;
            	head = Temp;
        	}
        	//original else statement
        	else 
            {
                previous.next = newNode;
            }
        } 
        
    }

    // BUGGY deleteNode method
    public void deleteNode(int number) 
    {
    	//Method based around head having values already in it.
    	//added to make it remove first element if it is equal and just send back to main
    	if(head.data == number) 
    	{
    		head = head.next;
    		return;
    	}
    	NodeFix current = head;
    	NodeFix previous = null;
        while (current != null && current.data != number) 
        { // Bug #3: Incorrect loop termination
            previous = current;
            current = current.next;
        }
        //original if statement changed to current != null
        //original changes from if statement changed to the changes of the else statement
        if(current != null)
        {
            //changed null to current.next
        	//previous.next = null; // Bug #5: Should be previous.next = current.next
        	previous.next = current.next;
        }
    }

    public void printList() 
    {
    	NodeFix current = head;
        while (current != null) 
        {
            System.out.print(current.data + " → ");
            current = current.next;
        }
        System.out.println("null");
    }
}