package com.algos.dynamicProgramming.educativeIO.pattern3FibonacciNumbers;

import java.util.Arrays;

public class MinimumJumpsToReachEndBottomUp {
    public static void main(String[] args) {
        MinimumJumpsToReachEndBottomUp aj = new MinimumJumpsToReachEndBottomUp();
        int[] jumps = {2, 1, 1, 1, 4};
        System.out.println("Min Count: " + aj.countMinJumps(jumps));
        jumps = new int[]{1, 1, 3, 6, 9, 3, 0, 1, 3};
        System.out.println("Min Count: " + aj.countMinJumps(jumps));
      }
      public int countMinJumps(int jumps []){

        int dp [] = new int[jumps.length];

        dp[0]=0; // since no jump is required for a single step
        for (int i = 1;i<jumps.length;i++){
            dp[i]=Integer.MAX_VALUE;
        }

        for (int start = 0;start < jumps.length;start++){
            for (int end=start+1;end<jumps.length && end<=start + jumps[start];end++){
                dp[end] = Math.min(dp[end],dp[start]+1);
            }
        }
        System.out.println(dp.length);
          System.out.println("Original Array:");
        Arrays.stream(dp).forEach(s -> System.out.print(s +"|"));
          System.out.println("");
          System.out.println("DP Array:");
        Arrays.stream(dp).forEach(s -> System.out.print(s +"|"));
        System.out.println();
        return dp[jumps.length-1];

      }
}
