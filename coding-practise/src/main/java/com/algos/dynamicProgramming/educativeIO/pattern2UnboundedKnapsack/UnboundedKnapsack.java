package com.algos.dynamicProgramming.educativeIO.pattern2UnboundedKnapsack;

public class UnboundedKnapsack {
    public static void main(String[] args) {
        UnboundedKnapsack ks = new UnboundedKnapsack();
        int[] profits = { 15, 50, 60, 90 };
        int[] weights = { 1, 3, 4, 5 };
        int maxProfit = ks.solveKnapsack(profits, weights, 8);
        System.out.println(maxProfit);

        // Memoization call
        maxProfit = ks.solveKnapsackMemoization(profits, weights, 8);
        System.out.println("Memoization:");
        System.out.println(maxProfit);
      }    
      public int solveKnapsack(int [] profits, int [] weights, int CAPACITY){
        return this.knapsackRecursive(profits, weights, CAPACITY, 0);
      }

      private int knapsackRecursive(int [] profits, int [] weights, int capacity, int currentIndex){

        // base checks
        if (capacity <= 0 || profits.length == 0 || weights.length != profits.length || currentIndex >= profits.length){
                return 0;
            }
                
            //choose the current item
            int profit1 = 0;
            if (weights[currentIndex]<=capacity){
                profit1 = profits[currentIndex] + knapsackRecursive(profits, weights, capacity - weights[currentIndex], currentIndex);
            }
            int profit2 = knapsackRecursive(profits, weights, capacity, currentIndex+1);
            return Math.max(profit1,profit2);
      }


      // With Memoization
      public int solveKnapsackMemoization(int [] profits, int [] weights, int CAPACITY){
        Integer[][] dp = new Integer[profits.length][CAPACITY + 1];
        return this.knapsackRecursiveMemoization(profits, weights, CAPACITY, 0, dp);
      }

      public int knapsackRecursiveMemoization(int [] profits, int [] weights, int CAPACITY, int currentIndex, Integer [][] dp){
        // base check
        if (CAPACITY <= 0 || profits.length == 0 || weights.length != profits.length || currentIndex >= profits.length)
            return 0;

        if (dp[currentIndex][CAPACITY] == null) {
            int profit1 = 0;

            // include 
            if (weights[currentIndex]<=CAPACITY){
                profit1 = profits[currentIndex] + knapsackRecursiveMemoization(profits, weights, CAPACITY- weights[currentIndex], currentIndex, dp);
            }

            int profit2 =  knapsackRecursiveMemoization(profits, weights, CAPACITY, currentIndex+1, dp);
            dp[currentIndex][CAPACITY] = Math.max(profit1, profit2);
        }
        return dp[currentIndex][CAPACITY];
      }

}
