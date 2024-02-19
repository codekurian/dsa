package interviewdose.backtracking;

public class wordSearch79 {

	 public boolean exist(char[][] board, String word) {
	       
		    int rowLength = board.length;
	        int columnLength = board[0].length;
	        boolean wordExists = false ;
	        char[] words  = word.toCharArray();
	        
	        for (int i = 0; i < words.length; i++) {
				
				wordExists =  dfsFindWord(board,words,i ,0, 0, rowLength, columnLength);
			}
	        
	        return wordExists;
	        
	    }
	 
	 public boolean dfsFindWord(char[][] board,char[] words,int currentIndexOfAlphabet,int r,int c,int rowLength,int columnLength) {
		 boolean result = false;
		 
		 if(currentIndexOfAlphabet == words.length-1) {
			 return true;
		 }
		 
		 if(r>rowLength-1 || c>columnLength-1 || currentIndexOfAlphabet>words.length-1) {
			 return false ;
		 }else {
			 if(c<columnLength-1 && r<rowLength-1 ) {
				 result =  dfsFindWord(board,words, currentIndexOfAlphabet, r, c-1, rowLength, columnLength) ||
				 dfsFindWord(board,words, currentIndexOfAlphabet, r, c+1, rowLength, columnLength) ||
				 dfsFindWord(board,words, currentIndexOfAlphabet, r-1, c, rowLength, columnLength) ||
				 dfsFindWord(board,words, currentIndexOfAlphabet, r+1, c, rowLength, columnLength) ;
			 }
		 }
		 
		 
		
		 
		 return result;
	 }
}
