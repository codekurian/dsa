package interviewdose.stack;

import java.util.Iterator;
import java.util.Stack;

public class ImplementQueueUsingStacks232 {
	Stack<Integer> stack ;
	Stack<Integer> backup ;
	public static void main(String[] args) {
		ImplementQueueUsingStacks232 tezxs = new ImplementQueueUsingStacks232();
		tezxs.push(1);
		tezxs.push(2);
		tezxs.push(3);
		tezxs.push(4);
		System.out.println(tezxs.pop());
		
		System.out.println();

	}
	
	 public ImplementQueueUsingStacks232() {
		 stack = new Stack<>();
	    }

	 public void push(int x) {
		 stack.push(x);
	    }
	    
	    public int pop() {
	    	
	    	 backup = new Stack<>();
	    	int popped = -1;
	    	
	    	while(!stack.isEmpty()) {
	    		backup.push(stack.pop());
	    	}
	    	popped = backup.pop();
	    	while(!backup.isEmpty()) {
	    		stack.push(backup.pop());
	    	}
	        return popped;
	    }
	    
	    public int peek() {
	    	
	    	backup = new Stack<>();
	    	int peeked = -1;
	    	while(!stack.isEmpty()) {
	    		backup.push(stack.pop());
	    	}
	    	peeked = backup.peek();
	    	while(!backup.isEmpty()) {
	    		stack.push(backup.pop());
	    	}
	        return peeked;
	    }
	    
	    public boolean empty() {
	    	return stack.isEmpty();
	    }
}
