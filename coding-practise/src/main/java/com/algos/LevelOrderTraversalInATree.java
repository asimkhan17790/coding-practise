package com.algos;

import com.datastructures.BinaryTree;
import com.datastructures.BinaryTreeNode;

public class LevelOrderTraversalInATree {
    public static void main(String[] args) {
        BinaryTree t = new BinaryTree();
        t.root = new BinaryTreeNode(1);

        t.root.left = new BinaryTreeNode(2);
        t.root.right = new BinaryTreeNode(3);

        t.root.left.left = new BinaryTreeNode(4);
        levelOrderPrint(t.root);
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
