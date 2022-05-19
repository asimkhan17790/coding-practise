package com.algos.dynamicProgramming.educativeIO.pattern1Knapsack;

import java.util.Arrays;

public class MinimumSubsetSumDifference {
    public static void main(String[] args) {
        MinimumSubsetSumDifference ps = new MinimumSubsetSumDifference();
        System.out.println("--- BRUTE FORCE --- ");
        int[] num = {1, 2, 3, 9};
        System.out.println(ps.canPartition(num));
        num = new int[]{1, 2, 7, 1, 5};
        System.out.println(ps.canPartition(num));
        num = new int[]{1, 3, 100, 4};
        System.out.println(ps.canPartition(num));


        System.out.println("--- MEMOIZATION --- ");

        MinimumSubsetSumDifference ps1 = new MinimumSubsetSumDifference();
        num = new int[]{1, 2, 3, 9};
        System.out.println(ps1.canPartitionMemoize(num));
        num = new int[]{1, 2, 7, 1, 5};
        System.out.println(ps1.canPartitionMemoize(num));
        num = new int[]{1, 3, 100, 4};
        System.out.println(ps1.canPartitionMemoize(num));
    }

    // BRUTE FORCE SOLUTION - START
    public int canPartition (int [] num){
        return canPartitionRecursive (num,0,0,0);
    }
    public int canPartitionRecursive (int [] num, int curIndex, int sum1, int sum2){

        // BASE CONDITION
        if (curIndex == num.length){
            return Math.abs(sum1-sum2);
        }

        int diff1 = canPartitionRecursive(num, curIndex + 1, sum1+num[curIndex], sum2);

        int diff2 = canPartitionRecursive(num, curIndex + 1, sum1, sum2+num[curIndex]);

        return Math.min(diff1, diff2);

    }
    // BRUTE FORCE SOLUTION - END


    // MEMOIZATION

    public int canPartitionMemoize(int [] num) {

        int sum = Arrays.stream(num).sum();

        Integer dp [][] = new Integer [num.length][sum+1];

        return canPartitionMemoizeRecursive (num,dp, 0, 0, 0);
    }

    public int canPartitionMemoizeRecursive (int [] num,Integer [][] dp, int curIndex, int sum1, int sum2) {


        //BASE CONDITION
        if (curIndex == num.length){
            return Math.abs(sum1-sum2);
        }

        if (dp[curIndex][sum1] == null) {
            int diff1 = canPartitionMemoizeRecursive (num,dp, curIndex+1,  sum1 + num[curIndex], sum2);
            int diff2 = canPartitionMemoizeRecursive (num,dp, curIndex+1,  sum1, sum2 + num[curIndex]);
            dp[curIndex][sum1] = Math.min(diff1,diff2);

        }
        return dp[curIndex][sum1];
    }
}
