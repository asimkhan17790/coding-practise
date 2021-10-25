package com.algos.backtracking;

import java.util.ArrayList;
import java.util.List;
/*

22. Generate Parentheses (Leetcode)
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

Example 1:

Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]
Example 2:

Input: n = 1
Output: ["()"]
 

Constraints:

1 <= n <= 8
*/ 
public class GenerateParenthesis {
    
    public static void main(String[] args) {
        GenerateParenthesis g = new GenerateParenthesis();
        System.out.println(g.generateParenthesis(2));
    }


    List<String> list = new ArrayList<>();    
    public List<String> generateParenthesis(int n) {
           
        generateParenthesisHelper(n,new StringBuilder(""), 0, 0);        
        //List<String> list = new ArrayList<>(set);
        return list;
    }
    
    void generateParenthesisHelper (int n , StringBuilder prefix, int open,int close) {
        
        //goalReached
        if (prefix.length() == n*2){
            list.add(prefix.toString());            
        } else {
            // LIST CHOICES            
            if (open < n){
                prefix.append("(");
                generateParenthesisHelper (n , prefix, open + 1 , close);
                prefix.deleteCharAt(prefix.length() -1);
            }
            
            if (close < open){
                prefix.append(")");
                generateParenthesisHelper (n , prefix, open , close+1);
                prefix.deleteCharAt(prefix.length() -1);
            }
            
        }
    }
}
