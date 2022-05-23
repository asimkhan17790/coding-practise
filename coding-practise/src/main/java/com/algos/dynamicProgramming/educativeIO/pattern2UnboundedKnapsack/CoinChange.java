package com.algos.dynamicProgramming.educativeIO.pattern2UnboundedKnapsack;

/*
Given an infinite supply of ‘n’ coin denominations and a total money amount, we are asked to find the total number of distinct ways to make up that amount.
*/
public class CoinChange {

    public static void main(String[] args) {
        CoinChange cc = new CoinChange();
        int[] denominations = {1, 2, 3};
        System.out.println(cc.countChange(denominations, 5));
    }

    // BOTTOM UP Approach
    private int countChange(int denom[], int SUM) {

        int [][] dp = new int[denom.length][SUM + 1];

        for (int i = 0;i < denom.length; i++) {
            dp[i][0]=1;
        }

        for (int i = 0;i<denom.length;i++) {
            for (int s = 1;s<=SUM;s++) {


                //exclude
                int cExclude = 0;
                int cInclude = 0;
                if (i>0){
                    cExclude = dp[i-1][s];
                }
                //include
                if (denom[i]<=s){
                    cInclude = dp[i][s-denom[i]];
                }
                dp[i][s] = cExclude + cInclude;

                
            }
        }

        return dp[denom.length-1][SUM];
    }
    
}
