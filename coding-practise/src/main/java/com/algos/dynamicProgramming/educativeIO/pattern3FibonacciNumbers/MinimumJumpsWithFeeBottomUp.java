package com.algos.dynamicProgramming.educativeIO.pattern3FibonacciNumbers;

public class MinimumJumpsWithFeeBottomUp {

        public static void main(String[] args) {
            MinimumJumpsWithFeeBottomUp sc = new MinimumJumpsWithFeeBottomUp();
        int[] fee = { 1, 2, 5, 2, 1, 2 };
        System.out.println(sc.findMinFee(fee));
        fee = new int[] { 2, 3, 4, 5 };
        System.out.println(sc.findMinFee(fee));
      }

      int findMinFee (int fee[]) {

        int dp[] = new int [fee.length+1];
        dp[0]=0;
        dp[1]=fee[0];
        dp[2]=dp[3]=fee[0];

        for (int i = 3; i < fee.length; i++){
            dp[i+1] = Math.min(fee[i]+dp[i],Math.min(fee[i-1]+dp[i-1],fee[i-2]+ dp[i-2]));
        }

        return dp[fee.length];

      }
    
}
