package com.leetcode.trees;
 // Definition for a binary tree node.

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Leetcode297SerializeAndDeserializeBinaryTree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        Leetcode297SerializeAndDeserializeBinaryTree t = new Leetcode297SerializeAndDeserializeBinaryTree();
        TreeNode root = new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        root.right.left=new TreeNode(4);
        root.right.right=new TreeNode(5);

        String result = t.serialize(root);
        System.out.println(result);

        String [] ss = t.serialize(root).split(",");
        System.out.println(ss);


        TreeNode deserializedTree = t.deserialize(result);
        System.out.println(deserializedTree);
    }

    public String serialize(TreeNode root) {
        return serializeRecrusive(root,"");
    }

    String serializeRecrusive(TreeNode root, String s){
        if (root==null){
            s+="null," ;

        }else {
            s = s + root.val+ ",";
            s= serializeRecrusive(root.left,s);
            s= serializeRecrusive(root.right,s);
        }
        return s;
    }


    public TreeNode deserialize(String data) {
        String [] d = data.split(",");
        List<String> list = new LinkedList<>(Arrays.asList(d));
        return deserializeRecursive(list);
    }
    private TreeNode deserializeRecursive (List<String> list) {
        if (list.get(0).equals("null")){
            list.remove(0);
            return null;
        }

        int val = Integer.valueOf(list.get(0));
        TreeNode root = new TreeNode(val);
        list.remove(0);
        root.left = deserializeRecursive(list);
        root.right = deserializeRecursive(list);
        return root;

    }
}
