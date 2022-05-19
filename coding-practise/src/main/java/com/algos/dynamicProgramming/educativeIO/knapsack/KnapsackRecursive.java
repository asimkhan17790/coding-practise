package com.algos.dynamicProgramming.educativeIO.knapsack;

public class KnapsackRecursive {

    public static void main(String[] args) {
        
        int[] profits = {1, 6, 10, 16};
        int[] weights = {1, 2, 3, 5};
        int maxProfit = solveKnapsack(profits, weights, 7);
        System.out.println("Total knapsack profit ---> " + maxProfit);
        maxProfit = solveKnapsack(profits, weights, 6);
        System.out.println("Total knapsack profit ---> " + maxProfit);


        maxProfit = solveKnapsackMemoization(profits, weights, 7);
        System.out.println("Total knapsack profit with Memoization ---> " + maxProfit);
        maxProfit = solveKnapsackMemoization(profits, weights, 6);
        System.out.println("Total knapsack profit with Memoization ---> " + maxProfit);
      }
    

      // RECURSIVE APPROACH - START
      private static int solveKnapsack(int [] profits, int [] weights, int capacity ){
        return knapsackRecursive(profits, weights, capacity, 0);
      }

      private static int knapsackRecursive(int profits[] ,int weights[], int capacity, int currentIndex){
        if (currentIndex >= profits.length || capacity <= 0){
            return 0;
        }
        // when we select
        int profitWhenSelected = 0;
        if (weights[currentIndex] <= capacity){
            profitWhenSelected = profits[currentIndex] + knapsackRecursive(profits, weights, capacity-weights[currentIndex], currentIndex+1);
        }
        // when we do not select current index
        int profitWhenNotSelected = knapsackRecursive(profits, weights, capacity, currentIndex+1);
        return Math.max(profitWhenNotSelected, profitWhenSelected);
      }
      // RECURSIVE APPROACH - END

      
      //DYNAMIC PROGRAMMING TOPDOWN - MEMOIZATION
      private static int solveKnapsackMemoization(int [] profits, int [] weights, int capacity ){
        int C[][] = new int [profits.length][capacity+1];
        return knapsackRecursiveWithMemoization(profits, weights, capacity, 0,C);
      }
      private static int knapsackRecursiveWithMemoization(int profits[] ,int weights[], int capacity, int currentIndex,int [][] C){
        if (currentIndex >= profits.length || capacity <= 0){
            return 0;
        }
        if (C[currentIndex][capacity]!=0){
            return C[currentIndex][capacity]; 
        }
        // when we select current index
        int profitWhenSelected = 0;
        if (weights[currentIndex] <= capacity){
            profitWhenSelected = profits[currentIndex] + knapsackRecursive(profits, weights, capacity-weights[currentIndex], currentIndex+1);
        }
        // when we dont select current index
        int profitWhenNotSelected = knapsackRecursive(profits, weights, capacity, currentIndex+1);

        C[currentIndex][capacity]= Math.max(profitWhenNotSelected, profitWhenSelected);
        return C[currentIndex][capacity];

      }
}
