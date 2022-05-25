package com.algos.dynamicProgramming.educativeIO.pattern3FibonacciNumbers;

/*
Problem Statement#
Given an array of positive numbers, where each element represents the max number of jumps that can be made forward from that element, write a program to find the minimum number of jumps needed to reach the end of the array (starting from the first element). If an element is 0, then we cannot move through that element.

Example 1:

Input = {2,1,1,1,4}
Output = 3
Explanation: Starting from index '0', we can reach the last index through: 0->2->3->4
Example 2:

Input = {1,1,3,6,9,3,0,1,3}
Output = 4
Explanation: Starting from index '0', we can reach the last index through: 0->1->2->3->8
*/
public class MinimumJumpsToReachEnd {
    public static void main(String[] args) {
        MinimumJumpsToReachEnd aj = new MinimumJumpsToReachEnd();
        int[] jumps = {2, 1, 1, 1, 4};
        System.out.println(aj.countMinJumps(jumps));
        jumps = new int[]{1, 1, 3, 6, 9, 3, 0, 1, 3};
        System.out.println(aj.countMinJumps(jumps));

        //TopDown Memoization
        System.out.println("-----Memoization-----");
        jumps = new int[]{2, 1, 1, 1, 4};
        System.out.println(aj.countMinJumpsMemoization(jumps));
        jumps = new int[]{1, 1, 3, 6, 9, 3, 0, 1, 3};
        System.out.println(aj.countMinJumpsMemoization(jumps));
      }

      public int countMinJumps(int [] jumps){
          return this.countMinJumpsRecursive(jumps, 0);
      }
      public int countMinJumpsRecursive(int [] jumps, int curIndex){


        // base case
        if (curIndex == jumps.length-1){
            return 0;
        }
        if (jumps[curIndex] == 0){
            return Integer.MAX_VALUE;
        }

        int totalJumps = Integer.MAX_VALUE;
        int start = curIndex+1;
        int end = curIndex + jumps[curIndex];

        while (start<jumps.length && start<=end){
            int minJumps = countMinJumpsRecursive(jumps, start++);
            if (minJumps !=Integer.MAX_VALUE){
                totalJumps = Math.min(totalJumps, minJumps + 1);
            }
        }
        return totalJumps;

      }

      // MEMOIZATION
      public int countMinJumpsMemoization(int [] jumps){
        int dp[] = new int[jumps.length];
        return this.countMinJumpsMemoizeRecursive(jumps, 0, dp);
    }
    public int countMinJumpsMemoizeRecursive(int [] jumps, int curIndex,int[] dp){
        //base case
        if (curIndex == jumps.length-1){
            return 0;
        }
        if (jumps[curIndex] == 0){
            return Integer.MAX_VALUE;
        }

        if (dp[curIndex]!=0){
            return dp[curIndex];
        }

        int totalJumps = Integer.MAX_VALUE;
        int start = curIndex+1;
        int end = curIndex + jumps[curIndex];

        while (start<jumps.length && start<=end){
            int minJumps = countMinJumpsRecursive(jumps, start++);
            if (minJumps !=Integer.MAX_VALUE){
                totalJumps = Math.min(totalJumps, minJumps + 1);
            }
        }
        dp[curIndex] = totalJumps;
        return dp[curIndex];


    }

}
