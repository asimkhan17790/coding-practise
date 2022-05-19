package com.algos.dynamicProgramming.educativeIO.knapsack;

import java.util.Arrays;

public class EqualSubsetSumPartitionBottomUp {
    public static void main(String[] args) {
        int[] num = {1, 2, 3, 4};
        System.out.println(canPartition(num));
        num = new int[]{1, 1, 3, 4, 7};
        System.out.println(canPartition(num));
        num = new int[]{2, 3, 4, 6};
        System.out.println(canPartition(num));
    }


    public static boolean canPartition(int [] num) {

        int sum = Arrays.stream(num).sum();

        if (sum%2!=0){
            return false;
        }

        sum /= 2;

        boolean dp [][] = new boolean[num.length][sum+1];

        for (int i = 0;i<num.length;i++){
            dp[i][0] = true;

        }

        for (int i = 0;i<=sum;i++){
            dp[0][i] = ((num[0] == i) ? true:false);
        }


        for (int i = 1;i<num.length;i++) {
            for (int s = 1; s <= sum; s++) {
                if (dp[i-1][s]) {
                    dp[i][s] = dp[i-1][s];
                } else if (num[i]<=s) {
                    dp[i][s] =  dp[i-1][s - num[i]];
                }
            }
        }

    return dp [num.length-1][sum];
    }
             

}