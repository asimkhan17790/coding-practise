package com.datastructures.trees;

public class BinarySearchTree {

    public BinaryTreeNode root = null;

    public void insert(int key) {
        root = insertRecursive(root, key);
    }

    public BinaryTreeNode insertRecursive(BinaryTreeNode node, int key) {
        if (node == null) {
            node = new BinaryTreeNode(key);
            return node;
        }
        if (key < node.key) {
            node.left = insertRecursive(node.left, key);
        } else if (key > node.key) {
            node.right = insertRecursive(node.right, key);
        }
        return node;
    }

    public void inorder(BinaryTreeNode node) {
        if (node == null)
            return;
        inorder(node.left);
        System.out.print(node.key + "  ");
        inorder(node.right);
    }

    public void deleteKey(int key) {
        root = deleteRecursive(root, key);
    }

    public BinaryTreeNode deleteRecursive(BinaryTreeNode node, int key) {
        if (node == null) {
            return node;
        }
        if (key < node.key) {
            node.left = deleteRecursive(node.left, key);
        } else if (key > node.key) {
            node.right = deleteRecursive(node.right, key);
        } else {
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }
            node.key = minValue(node.right);
            node.right = deleteRecursive(node.right, node.key);
        }
        return node;
    }

    static int minValue(BinaryTreeNode root) {
        int minv = root.key;
        while (root != null) {
            minv = root.key;
            root = root.left;
        }
        return minv;
    }

    static int inorderSuccessorOfBinarySearchTree(BinaryTreeNode root, BinaryTreeNode node) {

        if (node.right != null) {
            return minValue(node.right);
        }
        BinaryTreeNode p = node.parent;
        while (p != null && node == p.right) {
            node = p;
            p = p.parent;
        }
        return p.key;

    }

    public static void main(String[] args) {
        BinarySearchTree t = new BinarySearchTree();
        t.insert(5);
        t.insert(12);
        t.insert(2);
        t.insert(1);
        t.insert(243);
        t.insert(54);
        t.insert(3);
        t.insert(3);// redundant - wont get inserted
        t.insert(29);
        t.insert(27);
        t.insert(8);
        t.inorder(t.root);

        t.deleteKey(12);
        System.out.println();
        t.inorder(t.root);

    }

}
