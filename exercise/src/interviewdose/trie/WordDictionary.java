package interviewdose.trie;

public class WordDictionary {
	TrieNode rootNode = new TrieNode();
	//https://leetcode.com/problems/design-add-and-search-words-data-structure/
	public class TrieNode{
		int wordEnd = 0 ;
		int wordCount =1;
		Character alphabet ;
		TrieNode[] charArray = new TrieNode[26];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 public WordDictionary() {
	        
	        rootNode.alphabet = '/';
	        
	    }
	    
	    public void addWord(String word) {
	       char[] charArray = word.toCharArray();
	       TrieNode currentNode = rootNode;
	       
	       for (int i = 0; i < charArray.length; i++) {
			Character c = charArray[i];
			TrieNode[] alphabetArray = currentNode.charArray;
			System.out.println(c-'a'+i);
			if(alphabetArray[c-'a'+i]==null) {
				TrieNode newNode = getNode(c);
				alphabetArray[c-'a'+i] = newNode;
				
				
				
			}else {
				TrieNode existingNode =	alphabetArray[c-'a'+i];
				existingNode.wordCount++;
			}
			
			if(i==charArray.length-1) {
				//we increase the count of the words ending with the character
				alphabetArray[c-'a'+i].wordEnd++;
			}
			//moving the currentNode to the n
			currentNode = alphabetArray[c-'a'+i];
			
			
		}
	    }
	    
	    public boolean search(String word) {
	    	 char[] charArray = word.toCharArray();
	    	 boolean found = false;
	    	 TrieNode currentNode = rootNode;
	    	 for (int i = 0; i < charArray.length; i++) {
				char c = charArray[i];
				System.out.println("seacrghing--->"+c);
				TrieNode[] alphabetArray = currentNode.charArray;
				if(c != '.') {
					
					TrieNode node = alphabetArray[c-'a'+i];
					if(null!= node && !node.alphabet.equals(c)) {
						System.out.println(node.alphabet);
						return false;
					}else if(null!= node  && node.alphabet.equals(c)){
						currentNode = alphabetArray[c-'a'+i];
					}
					if(i==charArray.length-1 && node.alphabet.equals(c) && node.wordEnd>0) {
						return true;
					}
					
				}else {
					// we need to match all the characters since it is .
					for (int j = 0; j < alphabetArray.length; j++) {
						TrieNode trieNode = alphabetArray[j];
						if(null!= trieNode && trieNode.wordCount>0) {
						Character alphabet = trieNode.alphabet;
						if(alphabet.equals(c)) {
							//
							currentNode = trieNode;
						}else {
							
						}
						}
						
						
					}
					
				}
				
				
				
				
			}
	    	 return found;
	    }
	    
/*	    boolean searchRecursive(TrieNode currentNode , Character tobeSearched,int charIndex,int wordEndIndex,boolean isFound) {
	    	if(currentNode == null || charIndex>wordEndIndex) {
	    		return false;
	    	}else {
	    		if(isFound) {
	    			TrieNode[] alphabetArray = currentNode.charArray;
	    			TrieNode nextNode = alphabetArray[tobeSearched-'a'+charIndex];
	    			if(nextNode.alphabet.equals(tobeSearched)) {
	    				isFound = true;
	    				searchRecursive(nextNode, tobeSearched,charIndex++,wordEndIndex,isFound);
	    			}else {
	    				isFound = false;
	    			}
	    			
	    		}else {
	    			return isFound;
	    		}
	    	}
			
	    }
	    */
	    public TrieNode getNode (Character alphabet) {
	    	TrieNode node = null ;
	    	if(null!= alphabet) {
	    		 node = new TrieNode();
	    		 node.alphabet = alphabet;
	    		 
	    		
	    	}
	    	System.out.println("node created -->"+node.alphabet);
			return node;
	    }
	   

}
