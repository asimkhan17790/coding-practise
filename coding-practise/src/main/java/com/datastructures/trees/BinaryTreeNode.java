package com.datastructures.trees;

public class BinaryTreeNode {
    public int key;
    public BinaryTreeNode left, right, parent;

    public BinaryTreeNode(int item) {
        key = item;
        left = right = parent = null;
    }    
}
