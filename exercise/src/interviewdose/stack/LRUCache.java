package interviewdose.stack;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Node {
	int key;
	int value;
	Node previous;
	Node next;
	
}
public class LRUCache {
 int capacity;
 Node front;
 Node end;
 Map<Integer,Node> cache;
 
	public static void main(String[] args) {
		//
		
		LRUCache cache = new LRUCache(1);
		cache.put(2, 1);
		
		cache.get(2);
		cache.put(3, 2);
		cache.get(3);
		

	}
	
public LRUCache(int capacity) {
		this.cache = new HashMap<Integer, Node>();
         this.capacity = capacity ;
         this.front = new Node();
         this.end = new Node();
         this.front.next = this.end;
         this.end.previous = this.front;
         
         
        
    }
    
    public int get(int key) {
    	//when we get we have to move the element to the end
    	if(!cache.containsKey(key)) {
    		return -1;
    	}else {
    		Node endNode = this.end.previous ;
    		Node lruNode = cache.get(key);
    		Node previousOfLru = lruNode.previous;
    		Node nextOfLru = lruNode.next;
    		previousOfLru.next = nextOfLru.previous;
        	endNode.next = lruNode;
        	lruNode.previous = endNode;
        	this.end.previous = lruNode;
        	return cache.get(key).value;
    	}
    	
        
    }
    
    public void put(int key, int value) {
        //when we put we have to check the capacity 
    	if(cache.size()==capacity) {
    		//remove lru 
    		int keyToBeRemoved = this.front.next.key;
    		this.front.next = front.next.next;
    		this.cache.remove(keyToBeRemoved);
    		
    	}
    	Node newNode = new Node();
    	newNode.key = key;
    	newNode.value = value;
    	
    	if(cache.size()==0) {
    		//this.front= newNode;
    		//this.end = newNode;
    		this.front.next= newNode;
    		this.end.previous = newNode;
    		
    		newNode.previous = this.front;
    		newNode.next = this.end;
    		this.cache.put(key, newNode);
    	}else {
    		Node previousEndNode = this.end.previous ;
    		newNode.previous = previousEndNode;
        	previousEndNode.next = newNode;
        	
        	//this.front.next = endNode.previous;
        	this.end.previous = newNode;
        	this.cache.put(key, newNode);
    	}
    	
    	
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
	


