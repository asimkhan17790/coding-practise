package com.algos;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import com.datastructures.BinaryTree;
import com.datastructures.BinaryTreeNode;

public class LevelOrderTraversalInATree {
    public static void main(String[] args) {
        BinaryTree t = new BinaryTree();
        t.root = new BinaryTreeNode(1);

        t.root.left = new BinaryTreeNode(2);
        t.root.right = new BinaryTreeNode(3);
        t.root.right.right = new BinaryTreeNode(5);
        t.root.right.right.left = new BinaryTreeNode(7);
        t.root.right.right.right = new BinaryTreeNode(6);

        t.root.left.left = new BinaryTreeNode(4);
        System.out.print("Level Order: ");
        levelOrderPrint(t.root);
        System.out.println();
        System.out.print("Inorder: ");

        inOrderTraversal(t.root);
        System.out.println();
        System.out.print("Preorder: ");
        preOrderTraversal(t.root);
        System.out.println();
        System.out.print("Posteorder: ");
        postOrderTraversal(t.root);
        System.out.println();
        System.out.print("Level Order using Queue: ");
        levelOrderPrintUsingQueue(t.root);
        System.out.println();
        System.out.print("inOrder Traversal Using Queue: ");
        inOrderTraversalUsingQueue(t.root);

    }
    static void inOrderTraversal(BinaryTreeNode node){
        if (node == null) return;
        inOrderTraversal(node.left);
        System.out.print(node.key + "  ");
        inOrderTraversal(node.right);
    }

    static void inOrderTraversalUsingQueue(BinaryTreeNode root) {

        if (root == null) return;
        Stack<BinaryTreeNode> stack = new Stack<>();
        BinaryTreeNode temp = root;       
        while (!stack.isEmpty() || temp !=null){           
            
            if (temp!=null) {
                stack.push(temp);
                temp = temp.left;
            }else {
                temp = stack.pop();
                System.out.print(temp.key + "  ");
                temp = temp.right;
            }            
        }
    }
    static void preOrderTraversal(BinaryTreeNode node){
        if (node == null) return;
        System.out.print(node.key + "  ");
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }
    static void postOrderTraversal(BinaryTreeNode node){
        if (node == null) return;
        postOrderTraversal(node.left);
        postOrderTraversal(node.right);
        System.out.print(node.key + "  ");        
    }

    public static void levelOrderPrintUsingQueue(BinaryTreeNode root){

        if (root == null) return;
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            BinaryTreeNode temp = queue.poll();
            
                System.out.print(temp.key + "   ");
                if (temp.left != null){
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
        }

    }

    public static void levelOrderPrint(BinaryTreeNode root) {
        int treeHeight = height(root);

        for (int i = 1;i<=treeHeight;i++){
            printLevel(root,i);
        }
    }
    public static void printLevel(BinaryTreeNode node, int level) {

        if (node == null) return;
        if (level == 1) {
            System.out.print(node.key + "  ");
        
        }else if(level > 1) {
            printLevel(node.left, level-1);
            printLevel(node.right, level-1);
        }
    }

    public static int height(BinaryTreeNode node){
        if (node == null) return 0;

        int leftSubTreeheight = height(node.left);
        int rightSubTreeheight = height(node.right);
        return Math.max(leftSubTreeheight,rightSubTreeheight) + 1;

    }
}
