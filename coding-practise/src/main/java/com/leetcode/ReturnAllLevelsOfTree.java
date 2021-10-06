package com.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.datastructures.BinaryTree;
import com.datastructures.BinaryTreeNode;

//Given the root of a binary tree, return the level order traversal of its nodes' values.
// (i.e., from left to right, level by level).

public class ReturnAllLevelsOfTree {
    public static void main(String[] args) {
        BinaryTree t = new BinaryTree();
        t.root = new BinaryTreeNode(1);

        t.root.left = new BinaryTreeNode(2);
        t.root.right = new BinaryTreeNode(3);
        t.root.right.right = new BinaryTreeNode(5);
        t.root.right.right.left = new BinaryTreeNode(7);
        t.root.right.right.right = new BinaryTreeNode(6);

        t.root.left.left = new BinaryTreeNode(4);


        ReturnAllLevelsOfTree runner = new ReturnAllLevelsOfTree();
        //List<List<Integer>> levels = runner.levelOrder(t.root);
        List<List<Integer>> levels = runner.levelOrderIterative(t.root);
        System.out.println(levels);
        
    }
    List<List<Integer>> levels = new ArrayList<List<Integer>>();

    //recursive
    public List<List<Integer>> levelOrder(BinaryTreeNode root) {
       
        if (root == null) {
            return levels;
        }
        printLevel(root,0);
        return levels;    
        
    }
    void printLevel(BinaryTreeNode node, int curLevel){
        if (levels.size() == curLevel){
            levels.add(new ArrayList<Integer>());
        }
        
        levels.get(curLevel).add(node.key);
        
        if (node.left != null){
            printLevel(node.left, curLevel + 1);
        }
        if (node.right != null){
            printLevel(node.right, curLevel + 1);
        }
        
    }
    
    //iterative
    public List<List<Integer>> levelOrderIterative(BinaryTreeNode root) {
       if (root == null) return levels;
        
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        
        while(!queue.isEmpty()) {
            levels.add(new ArrayList<Integer>());
            
            int levelLength = queue.size();
            for (int i = 0;i<levelLength;i++){
                BinaryTreeNode node = queue.remove();
                
                levels.get(level).add(node.key);
                
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            level++;
        }
         
        return levels;
    }
}
