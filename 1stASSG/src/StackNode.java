import java.io.PrintStream;
import java.util.NoSuchElementException;

public class StackNode implements StringStack {
	
	Node top = null;

	
	public StackNode(){	}
	
	public boolean isEmpty() {
		return (top==null);
	}

	
	public void push(String item) {

		Node node = new Node(item, null);
		if (isEmpty()) {
			 top = node;
		}
		else{
			node.next = top;
			top = node;}
	}
	public String pop() throws NoSuchElementException{
		String removed="No word was removed";
		if(isEmpty()){
			throw new  NoSuchElementException("Stack");}
		else{
			removed=top.item;
			top=top.next;
			
		}
		
		return removed;
		}
	
	public String peek() throws NoSuchElementException{
		if(isEmpty()){
			throw new NoSuchElementException("Stack");
		}
		else{
		return top.item;
		}	
	}
	
	public void printStack(PrintStream stream){
		System.out.println("Stack starting from top :");
		Node curr=top;
		while(curr!=null){
			System.out.println(curr.item);
			curr=curr.next;
		}
		}
	
	public int size(){
		if(isEmpty()){
			return 0;
		}
		Node curr=top;
		int size=0;
		while(curr!=null){
			
			size++;
			curr=curr.next;
		}
	
		return size;
	
	}
	
	
	
}