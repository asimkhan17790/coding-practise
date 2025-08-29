package com.datastructures.trees;
import java.util.ArrayList;
import java.util.*;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;


/*

Example Input:
1 3 2 1 5 0 3 0 4 0
 */

class FindAllPathsInTernaryTree {
    public static class Node<T> {
        public T val;
        public List<Node<T>> children;

        public Node(T val) {
            this(val, new ArrayList<>());
        }

        public Node(T val, List<Node<T>> children) {
            this.val = val;
            this.children = children;
        }
    }

    public static List<String> ternaryTreePaths(Node<Integer> root) {
        // WRITE YOUR BRILLIANT CODE HERE
        List<String> resultPaths = new ArrayList<>();
        buildPath(root, "",resultPaths);

        //List<String> resultPaths = set.stream().collect(Collectors.toList());
        return resultPaths;
    }

    static void buildPath(Node<Integer> root, String curPath, List<String> resultPaths){
        if (curPath.isEmpty()){
            curPath = curPath + root.val;
        }else {
            curPath = curPath + "->" + root.val;
        }

        if (root.children.isEmpty()) {
            //set.add (curPath);
            resultPaths.add(curPath);
        }

        for (Node<Integer> child:root.children) {
            buildPath(child, curPath,resultPaths);
        }

    }

    // this function builds a tree from input; you don't have to modify it
    // learn more about how trees are encoded in https://algo.monster/problems/serializing_tree
    public static <T> Node<T> buildTree(Iterator<String> iter, Function<String, T> f) {
        String val = iter.next();
        int num = Integer.parseInt(iter.next());
        ArrayList<Node<T>> children = new ArrayList<>();
        for (int i = 0; i < num; i++)
            children.add(buildTree(iter, f));
        return new Node<T>(f.apply(val), children);
    }

    public static List<String> splitWords(String s) {
        return s.isEmpty() ? List.of() : Arrays.asList(s.split(" "));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Node<Integer> root = buildTree(splitWords(scanner.nextLine()).iterator(), Integer::parseInt);
        scanner.close();
        List<String> res = ternaryTreePaths(root);
        for (String line : res) {
            System.out.println(line);
        }
    }
}

