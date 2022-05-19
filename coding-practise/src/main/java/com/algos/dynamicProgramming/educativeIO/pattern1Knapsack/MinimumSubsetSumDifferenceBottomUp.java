package com.algos.dynamicProgramming.educativeIO.pattern1Knapsack;

import java.util.Arrays;

public class MinimumSubsetSumDifferenceBottomUp {

    public static void main(String[] args) {

        MinimumSubsetSumDifferenceBottomUp ps = new MinimumSubsetSumDifferenceBottomUp();
        int[] num = {1, 2, 3, 9};
        System.out.println(ps.canPartition(num));
        num = new int[]{1, 2, 7, 1, 5};
        System.out.println(ps.canPartition(num));
        num = new int[]{1, 3, 100, 4};
        System.out.println(ps.canPartition(num));
        
    }

    public int canPartition (int [] num) {

        int SUM = Arrays.stream(num).sum();
        int sumHalf = SUM/2;
        boolean dp [][] = new boolean [num.length][sumHalf+1];

        for (int i = 0; i < num.length; i++) {
            dp[i][0] = true;
        }

        for (int s = 0; s <= sumHalf; s++) {
            dp[0][s] = (num[0]==s ? true:false);
        }

        for (int i = 1; i < num.length; i++) {
            for (int s = 1; s <= sumHalf; s++ ) {                
                
                if (dp[i-1][s]){
                    dp[i][s] = dp[i-1][s];
                } else if (num[i] <= s){
                    dp[i][s] = dp[i-1][s-num[i]];
                }
            }
        }

        int sum1 = 0;
        // Find the largest index in the last row which is true
        for (int i = sumHalf; i >= 0; i--) {
        if (dp[num.length-1][i] == true) {
            sum1 = i;
            break;
            }
        }

        int sum2 = SUM - sum1;
        return Math.abs(sum2-sum1);  
        
    }    
}
