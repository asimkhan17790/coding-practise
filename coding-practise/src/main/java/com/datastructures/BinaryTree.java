package com.datastructures;

public class BinaryTree {

    BinaryTreeNode root;

    BinaryTree(int key){
        root = new BinaryTreeNode(key);
    }

    BinaryTree() {
        root = null;
    }


    public static void main(String[] args) {
        BinaryTree t = new BinaryTree();
        t.root = new BinaryTreeNode(1);

        t.root.left = new BinaryTreeNode(2);
        t.root.right = new BinaryTreeNode(3);

        t.root.left.left = new BinaryTreeNode(4);
            

    }
    
}
