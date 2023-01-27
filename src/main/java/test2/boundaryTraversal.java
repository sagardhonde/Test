package test2;

import java.util.* ;
import java.io.*; 

//   class TreeNode {
//	    int data;
//	    TreeNode left;
//	    TreeNode right;
//
//	    TreeNode(int data) {
//		    this.data = data;
//		    this.left = null;
//		    this.right = null;
//	    }
//    }
import java.util.ArrayList;

public class Solution {
	public static ArrayList<Integer> traverseBoundary(TreeNode root){
		
		ArrayList<Integer> res = new ArrayList<>();
		if(isLeaf(root)==false)
			res.add(root.data);
		leftTraversal(root, res);
		bottomTraversal(root,res);
		rightTraversal(root,res);
		return res;
	}


	public static boolean isLeaf(TreeNode root){
		if(root.left==null && root.right==null)
			return true;
		return false;
	}
	public static void leftTraversal(TreeNode root,ArrayList<Integer> res){

		TreeNode node = root.left;
		while(node!=null)
		{
			if(isLeaf(node)==false)
				res.add(node.data);
			if(node.left!=null)
				node=node.left;
			else
				node=node.right;
		}
	}

	public static void bottomTraversal(TreeNode root,ArrayList<Integer> res){

		
		if(isLeaf(root)==true)
		{
			res.add(root.data);
			return;
		}	
		if(root.left!=null)
			bottomTraversal(root.left,res);
		if(root.right!=null)
			bottomTraversal(root.right,res);

	}
	public static void rightTraversal(TreeNode root,ArrayList<Integer> res){
		TreeNode node =root.right;
		ArrayList<Integer> ans = new ArrayList<>();
		while(node!=null){

			if(isLeaf(node)==false)
				ans.add(node.data);
			if(node.right!=null)
				node=node.right;
			else
				node=node.left;
		}
		for(int i=ans.size()-1; i>=0; i--){
			res.add(ans.get(i));
		}
	}
}