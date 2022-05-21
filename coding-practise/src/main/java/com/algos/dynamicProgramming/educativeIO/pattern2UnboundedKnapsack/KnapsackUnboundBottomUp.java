package com.algos.dynamicProgramming.educativeIO.pattern2UnboundedKnapsack;

public class KnapsackUnboundBottomUp {
    public static void main(String[] args) {
        KnapsackUnboundBottomUp ks = new KnapsackUnboundBottomUp();
        int[] profits = {15, 50, 60, 90};
        int[] weights = {1, 3, 4, 5};
        System.out.println(ks.solveKnapsack(profits, weights, 8));
        System.out.println(ks.solveKnapsack(profits, weights, 6));
    }
    public int solveKnapsack(int profits [], int [] weights, int capacity){

        int dp [][] = new int [profits.length][capacity+1];

        for (int i = 0;i<profits.length;i++) {
            dp[i][0] = 0;
        }

        for (int i = 0; i < profits.length; i++) {
            for (int c=1;c<=capacity;c++){
                int profit1 = 0;
                int profit2 = 0;
                if (weights[i]<=c){
                    profit1 = profits[i] + dp[i][c-weights[i]];
                }
                //exclude - this is applicable from row 2 onwards only
                if (i>0){
                    profit2 = dp[i-1][c];
                }
                dp[i][c] = Math.max(profit1,profit2);
            }
        }

        return dp[profits.length-1][capacity];

    }
}
