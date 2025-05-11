/*
 * Stack Example
 * Add comments to explain the code
 */

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class StackTest {
    public static void main(String[] args) {

    	
        Stack<String> stack = new Stack<>();

        //can add as many elements as you wish but have equivalent pop methods called and peek
        System.out.println("Pushing elements: Williams, Smith, Blake, Johnson");
        stack.push("Williams");
        stack.push("Smith");
        stack.push("Blake");
        stack.push("Johnson");
        

        System.out.println("Stack after pushing: " + stack);


        String popped = stack.pop();
        System.out.println("Popped element: " + popped);
        System.out.println("Stack after popping: " + stack);


        String topElement = stack.peek();
        System.out.println("Top element: " + topElement);


        System.out.println("Is stack empty? " + stack.isEmpty());
        // set up size of the loop needed to empty stack
        int size = stack.size();
        
        for(int x = 0; x < size; x++)
        {
        	popped = stack.pop();
            System.out.println("Popped element: " + popped);
            System.out.println("Stack after popping: " + stack);
        }  
    }
}



class Stack<T> {
	

    private ArrayList<T> items; 


    public Stack() {
        this.items = new ArrayList<>();
    }


    public boolean isEmpty() {
        return this.items.isEmpty();
    }


    public void push(T item) {
        this.items.add(item);
    }


    public T pop() {
        if (this.isEmpty()) {
            throw new NoSuchElementException("Stack is empty.");
        }
        return this.items.remove(items.size() - 1);
    }


    public T peek() {
        if (this.isEmpty()) {
            throw new NoSuchElementException("Stack is empty.");
        }
        return this.items.get(items.size() - 1);
    }


    public int size() {
        return this.items.size();
    }


    @Override
    public String toString() {
        if (!this.items.isEmpty()) {
            return "bottom ->" + this.items.toString() + "<- top";
        } else {
            return "<<empty stack>>";
        }
    }
}
