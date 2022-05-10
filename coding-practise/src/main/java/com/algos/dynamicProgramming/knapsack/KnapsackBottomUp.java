package com.algos.dynamicProgramming.knapsack;

public class KnapsackBottomUp {

    public static void main(String[] args) {
        
        int[] profits = {1, 6, 10, 16};
        int[] weights = {1, 2, 3, 5};
        int maxProfit = solveKnapsackBottomUp(profits, weights, 7);
        System.out.println("Total knapsack profit ---> " + maxProfit);
        maxProfit = solveKnapsackBottomUp(profits, weights, 6);
        System.out.println("Total knapsack profit ---> " + maxProfit);
        
      }

      private static int solveKnapsackBottomUp(int profits[],int weights[],int capacity){

        // basic checks
        if (capacity <= 0 || profits.length == 0 || weights.length != profits.length)
            return 0;
        int dp[][] = new int [profits.length][capacity+1];
        for (int i = 0;i<profits.length;i++){
            dp[i][0]=0;    
        }

        for (int c = 0; c <= capacity; c++){
            if(weights[0] <= c)
                dp[0][c] = profits[0];
        }

        for (int i = 1;i<profits.length;i++){
            for (int c=0;c<=capacity;c++){
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

        return dp[profits.length-1][capacity];


      }
    
}
