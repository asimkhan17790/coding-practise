package com.algos.dynamicProgramming.educativeIO.pattern1Knapsack;


/* 

Given a set of positive numbers, find the total number of subsets whose sum is equal to a given number ‘S’.

Example 1:#
Input: {1, 1, 2, 3}, S=4
Output: 3
The given set has '3' subsets whose sum is '4': {1, 1, 2}, {1, 3}, {1, 3}
Note that we have two similar sets {1, 3}, because we have two '1' in our input.
Example 2:#
Input: {1, 2, 7, 1, 5}, S=9
Output: 3
The given set has '3' subsets whose sum is '9': {2, 7}, {1, 7, 1}, {1, 2, 1, 5}
Given a set of positive numbers, find the total number of subsets whose sum is equal to a given number ‘S’.

Example 1:#
Input: {1, 1, 2, 3}, S=4
Output: 3
The given set has '3' subsets whose sum is '4': {1, 1, 2}, {1, 3}, {1, 3}
Note that we have two similar sets {1, 3}, because we have two '1' in our input.
Example 2:#
Input: {1, 2, 7, 1, 5}, S=9
Output: 3
The given set has '3' subsets whose sum is '9': {2, 7}, {1, 7, 1}, {1, 2, 1, 5} */
public class CountOfSubsetSum {

    public static void main(String[] args) {
        CountOfSubsetSum ss = new CountOfSubsetSum();
        int[] num = {1, 1, 2, 3};
        System.out.println(ss.countSubsets(num, 4));
        num = new int[]{1, 2, 7, 1, 5};
        System.out.println(ss.countSubsets(num, 9));
    }

    private int countSubsets (int [] num, int SUM) {

        int [][] dp = new int[num.length][SUM+1];

        for (int i = 0;i<num.length;i++) {
            dp[i][0] = 1;
        }

        for (int s = 1; s <= SUM; s++) {
            dp[0][s] = (num[0]==s?1:0);
        }

        for (int i = 1; i < num.length; i++){
            for (int s = 1;s <= SUM; s++){
                
                int whenIncluded=0;
                int whenExcluded=0;
                
                // exclude
                whenExcluded = dp[i-1][s];
                
                //include
                if(num[i]<=s){
                    whenIncluded = dp[i-1][s-num[i]];                    
                }
                dp[i][s] = whenIncluded + whenExcluded;
            }
        }
        return dp[num.length-1][SUM];
    }
    
}
