package com.algos;

import com.datastructures.trees.BinaryTree;
import com.datastructures.trees.BinaryTreeNode;

public class FindHeightOfBinaryTree {

    public static void main(String[] args) {
        BinaryTree t = new BinaryTree();
        t.root = new BinaryTreeNode(1);

        t.root.left = new BinaryTreeNode(2);
        t.root.right = new BinaryTreeNode(3);

        t.root.left.left = new BinaryTreeNode(4);
        System.out.println(height(t.root));

        System.out.println(height2(t.root));

    }


    public static int height(BinaryTreeNode root){

        if (root == null){
            return 0;
        }
        int leftSubTreeheight = height(root.left);
        int rightSubTreeheight = height(root.left);
        return Math.max(leftSubTreeheight, rightSubTreeheight) + 1;
    }

    static int height2(BinaryTreeNode root)
    {
        if (root == null)
           return 0;
        else
        {
            /* compute  height of each subtree */
            int lheight = height(root.left);
            int rheight = height(root.right);
             
            /* use the larger one */
            if (lheight > rheight)
                return(lheight+1);
            else return(rheight+1);
        }
    }
    
}
