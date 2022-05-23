package com.algos.dynamicProgramming.educativeIO.pattern3FibonacciNumbers;

/**
 Problem Statement#
Given a stair with ‘n’ steps, implement a method to count how many possible ways are there to reach the top of the staircase, given that, at every step you can either take 1 step, 2 steps, or 3 steps.

Example 1:

Number of stairs (n) : 3
Number of ways = 4
Explanation: Following are the four ways we can climb : {1,1,1}, {1,2}, {2,1}, {3} 
Example 2:

Number of stairs (n) : 4
Number of ways = 7
Explanation: Following are the seven ways we can climb : {1,1,1,1}, {1,1,2}, {1,2,1}, {2,1,1}, 
{2,2}, {1,3}, {3,1}
 * 
 */
public class StairCase {
    public static void main(String[] args) {
        StairCase sc = new StairCase();
        System.out.println(sc.countWays(3));
        System.out.println(sc.countWays(4));
        System.out.println(sc.countWays(5));
      }

      public int countWays(int stairs) {

        int dp[] = new int [stairs+1];
        dp[0]=1;
        dp[1]=1;
        dp[2]=2;
        
        for (int i = 3;i<=stairs;i++) {
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }
        return dp[stairs];

      }
    
}
