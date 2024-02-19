package interviewdose.stack;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;

//https://leetcode.com/problems/implement-stack-using-queues/
public class ImplementStackUsingQueue225 {
	static Queue<Integer> queue = new LinkedList();
	/*
	 * Implement a last-in-first-out (LIFO) stack using only two queues. The
	 * implemented stack should support all the functions of a normal stack (push,
	 * top, pop, and empty).
	 * 
	 * Implement the MyStack class:
	 * 
	 * void push(int x) Pushes element x to the top of the stack. int pop() Removes
	 * the element on the top of the stack and returns it. int top() Returns the
	 * element on the top of the stack. boolean empty() Returns true if the stack is
	 * empty, false otherwise. Notes:
	 * 
	 * You must use only standard operations of a queue, which means that only push
	 * to back, peek/pop from front, size and is empty operations are valid.
	 * Depending on your language, the queue may not be supported natively. You may
	 * simulate a queue using a list or deque (double-ended queue) as long as you
	 * use only a queue's standard operations.
	 * 
	 * 
	 * Example 1:
	 * 
	 * Input ["MyStack", "push", "push", "top", "pop", "empty"] [[], [1], [2], [],
	 * [], []] Output [null, null, null, 2, 2, false]
	 * 
	 * Explanation MyStack myStack = new MyStack(); myStack.push(1);
	 * myStack.push(2); myStack.top(); // return 2 myStack.pop(); // return 2
	 * myStack.empty(); // return False
	 * 
	 * 
	 * Constraints:
	 * 
	 * 1 <= x <= 9 At most 100 calls will be made to push, pop, top, and empty. All
	 * the calls to pop and top are valid.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 public ImplementStackUsingQueue225() {
         
	        
	    }
	    
	  
	  public void push(int x) {
		  queue.add(x);
	    }
	    
	    public int pop() {
	    
	    	int size = queue.size();
	    	for (int i = 1; i <= size; i++) {
	    		if(i==size) {
	    			return queue.poll();
	    		}else {
	    			queue.add(queue.poll());
	    		}
	    		
				
			}
	    return -1;
	    }
	    
	    public int top() {
	    	int peeked = -1;
	    	int size = queue.size();
	    	for (int i = 1; i <= size; i++) {
	    		if(i==size) {
	    			 peeked =  queue.peek();
	    			queue.add(queue.poll());
	    		}else {
	    			queue.add(queue.poll());
	    		}
	    		
				
			}
	    return peeked;
	    }
	    
	    public boolean empty() {
	        return queue.isEmpty();
	    }
}

