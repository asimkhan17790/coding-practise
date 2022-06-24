package com.leetcode.trees;

import java.util.*;

public class LeetCode652_FindDuplicateSubtrees {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(4);
        root.right.left.left = new TreeNode(4);

        LeetCode652_FindDuplicateSubtrees r = new LeetCode652_FindDuplicateSubtrees();
        List<TreeNode>result = r.findDuplicateSubtrees(root);

        for (TreeNode t : result){
            System.out.println(t.val + " ");
        }
    }


    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        Set<TreeNode> set = new HashSet<>();
        Map<String,TreeNode> map = new HashMap<>();


        getDuplicate(root, set, map, false, false);

        return new ArrayList<>(set);
    }

    public String getDuplicate(TreeNode root, Set<TreeNode>set, Map<String,TreeNode>map,boolean left,boolean right){

        if (root==null && left){
            return "LEFT_NULL";
        }
        if (root == null && right){
            return "RIGHT_NULL";
        }
        if (root == null){
            return "NULL";
        }

        int val = root.val;

        String leftString = getDuplicate(root.left,set,map,true,false);
        String rightString = getDuplicate(root.left,set,map,false,true);

        String combined = leftString+val+rightString;

        if (map.get(combined)!=null){
            set.add(map.get(combined));
        }else {
            map.put(combined, root);
        }

        return combined;
    }


//      Definition for a binary tree node.
      static class TreeNode {
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

}
