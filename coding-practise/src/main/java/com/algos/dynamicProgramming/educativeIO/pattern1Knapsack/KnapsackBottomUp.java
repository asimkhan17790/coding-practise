package com.algos.dynamicProgramming.educativeIO.pattern1Knapsack;

public class KnapsackBottomUp {

    public static void main(String[] args) {
        
        int[] profits = {1, 6, 10, 16};
        int[] weights = {1, 2, 3, 5};
        int maxProfit = solveKnapsackBottomUp(profits, weights, 7);
        System.out.println("Total knapsack profit ---> " + maxProfit);
        maxProfit = solveKnapsackBottomUp(profits, weights, 6);
        System.out.println("Total knapsack profit ---> " + maxProfit);

        profits = new int[] { 60, 100, 120, 150 };
        weights = new int[] { 10, 20, 30, 50 };
        int W = 50;
        maxProfit = solveKnapsackBottomUp(profits, weights, W);
        System.out.println("Total knapsack profit ---> " + maxProfit);
      }

      private static int solveKnapsackBottomUp(int profits[],int weights[],int capacity){
//
        // basic checks
        if (capacity <= 0 || profits.length == 0 || weights.length != profits.length)
            return 0;

        //dp[i][c] will represent the maximum knapsack profit for capacity ‘c’ calculated from the first ‘i’ items.
        int dp[][] = new int [profits.length][capacity+1];
        for (int i = 0;i<profits.length;i++){
            dp[i][0]=0;    
        }

        for (int c = 0; c <= capacity; c++){
            if(weights[0] <= c)
                dp[0][c] = profits[0];
        }

        for (int i = 1;i<profits.length;i++){
            for (int c=1;c<=capacity;c++){
                //include
                int pInclude=0;
                int pExclude=0;
                if (weights[i]<=c){
                    pInclude = profits[i] + dp[i-1][c-weights[i]];
                }

                //exclude
                pExclude = dp[i-1][c];
                dp[i][c]=Math.max(pInclude,pExclude);

            }
        }
        printSelectedElements(dp, weights, profits, capacity);
        return dp[profits.length-1][capacity];


      }
      static void printSelectedElements(int [][] dp,int[]  weights,int[] profits,int capacity){
        System.out.print("Selected weights:");
        int totalProfit = dp[weights.length-1][capacity];
        for(int i=weights.length-1; i > 0; i--) {
            if(totalProfit != dp[i-1][capacity]) {
              System.out.print(" " + weights[i]);
              capacity -= weights[i];
              totalProfit -= profits[i];
            }
      }
    }
    
}
