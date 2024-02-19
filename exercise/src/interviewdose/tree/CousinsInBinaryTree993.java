package interviewdose.tree;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/cousins-in-binary-tree/description/
public class CousinsInBinaryTree993 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

 class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        int depthOfx = 0;
        int depthOfy = 0;
        boolean found = false;
        TreeNode current = root;
        Map<String,Integer> depthMap = new HashMap<String,Integer>();
        Map<String,TreeNode> parentMap = new HashMap<String,TreeNode>();
        traverse(root,current,depthMap,parentMap,depthOfx,depthOfy,x,y);
        if(depthMap.containsKey("X")&&depthMap.containsKey("Y")){
                if((parentMap.get("X").val!=parentMap.get("Y").val)&&(depthMap.get("X").equals(depthMap.get("Y")))){
                   found = true;
                }else{
                    found =  false;
                }
            }
       return found;
    }


    public void traverse(TreeNode parent,TreeNode current,Map<String,Integer> depthMap,Map<String,TreeNode> parentMap,int depthOfx,int depthOfy,int x,int y){
         
          if(current == null){
            return ;
          
            
       

    }else{
          
            depthOfx++;
            depthOfy++;
           //System.out.println(depthOfx+" "+depthOfy+"parent "+parent.val+" current "+current.val);
        
             if(current.val==x){
                   System.out.println("found "+x);//found x
                depthMap.put("X", depthOfx);
                parentMap.put("X", parent);
               
            }
            if(current.val==y){
                System.out.println("found "+y);
                 depthMap.put("Y", depthOfy);
                  parentMap.put("Y", parent);
            }
 
           traverse( current, current.left,depthMap,parentMap,depthOfx,depthOfy,x,y);
           traverse( current, current.right,depthMap,parentMap,depthOfx,depthOfy,x,y);
    }
           

    }

    
    
}
