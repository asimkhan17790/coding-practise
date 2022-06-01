package com.algos.dynamicProgramming.educativeIO.pattern5LongestCommonSubstring;

public class MaximumSumIncreasingSubsequence {
    public static void main(String[] args) {
        MaximumSumIncreasingSubsequence msis = new MaximumSumIncreasingSubsequence();
        int[] nums = {4,1,2,6,10,1,12};
        System.out.println(msis.findMSIS(nums));
        nums = new int[]{-4,10,3,7,15};
        System.out.println(msis.findMSIS(nums));
        nums = new int[]{1,3,8,4,14,6,14,1,9,4,13,3,11,17,29};
        System.out.println(msis.findMSIS(nums));
      }

      // Bottom up Dynamic Programming
      private int findMSIS (int nums[]) {

        int dp [] = new int [nums.length];

        for (int i = 0;i<nums.length;i++) {
            dp[i]=nums[i];
        }

        int maxSum = 0;
        for (int i = 1 ;i<nums.length;i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i]>nums[j]){
                    dp[i] = Math.max(dp[j]+nums[i],dp[i]);
                    
                }
                maxSum = Math.max(maxSum, dp[i]);
            }
        }
        return maxSum;
      }
}
