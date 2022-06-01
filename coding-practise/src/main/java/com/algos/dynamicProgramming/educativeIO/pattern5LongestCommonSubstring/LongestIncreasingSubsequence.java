package com.algos.dynamicProgramming.educativeIO.pattern5LongestCommonSubstring;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();

        // Recursion
        int[] nums = {4,2,3,6,10,1,12};
        System.out.println(lis.findLISLength(nums));
        nums = new int[]{-4,10,3,7,15};
        System.out.println(lis.findLISLength(nums));

        // Memoization
        System.out.println("--- Memoization ---");
        int[] nums2 = {4,2,3,6,10,1,12};
        System.out.println(lis.findLISLengthMemoize(nums2));
        nums2 = new int[]{-4,10,3,7,15};
        System.out.println(lis.findLISLengthMemoize(nums2));

        // Bottom Up
        System.out.println("--- Bottom Up ---");
        nums2 = new int[] {4,2,3,6,10,1,12};
        System.out.println(lis.findLISLengthBottomUp(nums2));
        nums2 = new int[]{-4,10,3,7,15};
        System.out.println(lis.findLISLengthBottomUp(nums2));
      }

      // Recursion
      private int findLISLength(int [] nums){
        return this.findLISLengthRecursive(nums, 0, -1);
      }

      private int findLISLengthRecursive(int [] nums, int curIndex, int prevIndex){

        if (curIndex == nums.length){
            return 0;
        }
        int c1 = 0;
        if (prevIndex==-1 || nums[curIndex]> nums[prevIndex]){
            c1 = 1 + findLISLengthRecursive(nums, curIndex+1, curIndex);
        }

        int c2 = findLISLengthRecursive(nums, curIndex+1, prevIndex);
        return Math.max(c1, c2);
    }

    //Memoize
    private int findLISLengthMemoize(int [] nums){
        Integer dp [][] = new Integer[nums.length][nums.length+1];
        return this.findLISLengthRecursiveMemoize(nums, 0, -1, dp);
      }

      private int findLISLengthRecursiveMemoize(int [] nums, int curIndex, int prevIndex, Integer dp[][]){

        if (curIndex == nums.length){
            return 0;
        }

        if (dp[curIndex][prevIndex+1] == null) {
            int c1 = 0;
            if (prevIndex==-1 || nums[curIndex]> nums[prevIndex]){
                c1 = 1 + findLISLengthRecursive(nums, curIndex+1, curIndex);
            }
            int c2 = findLISLengthRecursive(nums, curIndex+1, prevIndex);
            dp[curIndex][prevIndex + 1] = Math.max(c1, c2);
        }

        return dp[curIndex][prevIndex + 1];     
    }

    // Bottom Up
    private int findLISLengthBottomUp(int [] nums){
        int dp [] = new int[nums.length];
        
        for (int i =0;i<nums.length;i++){
            dp[i]=1;
        }

        int maxLength=1;

        for (int i =1;i<nums.length;i++) {
            for (int j = 0;j<i;j++) {
                if (nums[i]>nums[j] && dp[i]<=dp[j]){
                    dp[i]=dp[j]+1;
                    maxLength = Math.max(maxLength, dp[i]);
                }
            }
        }
        return maxLength;
      }

}
