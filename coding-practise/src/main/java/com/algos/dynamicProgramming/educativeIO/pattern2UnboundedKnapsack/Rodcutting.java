package com.algos.dynamicProgramming.educativeIO.pattern2UnboundedKnapsack;


/*
Given a rod of length ‘n’, we are asked to cut the rod and sell the pieces in a way that will maximize the profit. We are also given the price of every piece of length ‘i’ where ‘1 <= i <= n’.

Example:

Lengths: [1, 2, 3, 4, 5]
Prices: [2, 6, 7, 10, 13]
Rod Length: 5

Let’s try different combinations of cutting the rod:

Five pieces of length 1 => 10 price
Two pieces of length 2 and one piece of length 1 => 14 price
One piece of length 3 and two pieces of length 1 => 11 price
One piece of length 3 and one piece of length 2 => 13 price
One piece of length 4 and one piece of length 1 => 12 price
One piece of length 5 => 13 price

This shows that we get the maximum price (14) by cutting the rod into two pieces of length ‘2’ and one piece of length ‘1’.

*/
public class Rodcutting {
    public static void main(String[] args) {
        Rodcutting rc = new Rodcutting();
        int[] lengths = {1, 2, 3, 4, 5};
        int[] prices = {2, 6, 7, 10, 13};
        int maxProfit = rc.solveRodCutting(lengths, prices, 5);
        System.out.println(maxProfit);
    }  
    public int solveRodCutting(int [] lengths, int [] prices, int N) {

        int dp [][] = new int [lengths.length][N+1];

        for (int i = 0;i<lengths.length;i++) {
            dp[i][0] = 0;
        }

        for (int i = 0;i<lengths.length;i++) {
            for (int c = 1;c<=N;c++){


                // include
                int profit1=0;int profit2=0;
                if (lengths[i]<=c){
                    profit1 = prices[i] + dp[i][c-lengths[i]];
                }
                if (i>0){
                    profit2 = dp[i-1][c];
                }

                dp[i][c] = Math.max(profit1, profit2);
            }
        }
        return dp[prices.length-1][N];
    }
}
