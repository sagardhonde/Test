package test2;
import java.util.* ; 

public class bottomview {
	
	public static void main(String args[]) {
		
		//Solution s = new Solution();
		BinaryTreeNode root=new BinaryTreeNode(1);
		root.left=new BinaryTreeNode(2);
		root.right=new BinaryTreeNode(3);
		root.left.left=new BinaryTreeNode(4);
		root.left.left.left=null;
		root.left.left.right=null;
		root.left.right=new BinaryTreeNode(5);
		root.left.right.left=new BinaryTreeNode(8);
		root.left.right.right=new BinaryTreeNode(9);
		root.left.right.left.left=null;
		root.left.right.left.right=null;
		root.left.right.right.left=null;
		root.left.right.right.right=null;
		root.right.left=new BinaryTreeNode(6);
		root.right.right=new BinaryTreeNode(7);
		root.right.left.left=null;
		root.right.left.right=null;
		root.right.right.left=null;
		root.right.right.right=null;
		
		ArrayList<Integer> res =new ArrayList<Integer>();
		res = Solution.bottomView(root);
		
		for(int i=0; i<res.size(); i++)
			System.out.println(res.get(i));
	}
}
	class BinaryTreeNode {
        int val;
        BinaryTreeNode left;
        BinaryTreeNode right;

        BinaryTreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }
	class pair{

	    int hd;
	    BinaryTreeNode root;

	    pair() {
		}
		pair(int hd, BinaryTreeNode root) {
			this.hd = hd;
	        this.root = root;
		}
	}

	class Solution {
	    public static ArrayList<Integer> bottomView(BinaryTreeNode root) {
	         
	        Queue<pair> q = new LinkedList<pair>();
	        Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
	        ArrayList<Integer> ans = new ArrayList<Integer>();
	        q.add(new pair(0,root));
	        while(!q.isEmpty()){

	            pair p = q.poll();
	            map.put(p.hd,p.root.val);

	            if(p.root.left!=null)
	                q.add(new pair(p.hd-1, p.root.left));
	            if(p.root.right!=null)
	                q.add(new pair(p.hd+1, p.root.right));
	        }
	        
	        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
	            ans.add(entry.getValue()); 
	        }
	        
	        return ans;
	        
	    }
	}
