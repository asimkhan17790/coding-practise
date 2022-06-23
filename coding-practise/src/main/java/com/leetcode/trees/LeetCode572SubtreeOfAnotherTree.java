package com.leetcode.trees;

public class LeetCode572SubtreeOfAnotherTree {
    static  class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left=new TreeNode(4);
        root.right=new TreeNode(5);
        root.left.left=new TreeNode(1);
        root.left.right = new TreeNode(2);

        TreeNode subTree =new TreeNode(4);
        subTree.left=new TreeNode(1);
        subTree.right = new TreeNode(2);
        LeetCode572SubtreeOfAnotherTree t = new LeetCode572SubtreeOfAnotherTree();
        System.out.println(t.isSubtree(root,subTree));
    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        TreeNode r = findRoot(root, subRoot);

        return check(r,subRoot);
    }

    boolean check(TreeNode r, TreeNode subRoot){
        if (r==null && subRoot==null){
            return true;
        }
        if(r.val!=subRoot.val)
            return false;

        boolean l = check(r.left,subRoot.left);
        boolean right = check(r.right,subRoot.right);
        return l&&right;

    }

    public TreeNode findRoot(TreeNode root,TreeNode subRoot){
        if (root==null) return null;

        if (root.val == subRoot.val) return root;
        else if(root.left!=null){
            return findRoot(root.left,subRoot);
        }else{
            return findRoot(root.right, subRoot);
        }

    }
}
