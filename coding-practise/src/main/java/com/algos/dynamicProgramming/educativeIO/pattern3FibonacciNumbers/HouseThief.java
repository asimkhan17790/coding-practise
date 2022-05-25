package com.algos.dynamicProgramming.educativeIO.pattern3FibonacciNumbers;
/*
There are n houses built in a line. A thief wants to steal the maximum possible money from these houses. The only restriction the thief has is that he can’t steal from two consecutive houses, as that would alert the security system. How should the thief maximize his stealing?

Problem Statement#
Given a number array representing the wealth of n houses, determine the maximum amount of money the thief can steal without alerting the security system.

Example 1:

Input: {2, 5, 1, 3, 6, 2, 4}
Output: 15
Explanation: The thief should steal from houses 5 + 6 + 4
Example 2:

Input: {2, 10, 14, 8, 1}
Output: 18
Explanation: The thief should steal from houses 10 + 8
*/
public class HouseThief {
    public static void main(String[] args) {
        HouseThief ht = new HouseThief();
        int[] wealth = {2, 5, 1, 3, 6, 2, 4};
        System.out.println(ht.findMaxSteal(wealth));
        wealth = new int[]{2, 10, 14, 8, 1};
        System.out.println(ht.findMaxSteal(wealth));

        // Memoization
        System.out.println("--- Memoization ---");
        wealth = new int[]{2, 5, 1, 3, 6, 2, 4};
        System.out.println(ht.findMaxStealMemoize(wealth));
        wealth = new int[]{2, 10, 14, 8, 1};
        System.out.println(ht.findMaxStealMemoize(wealth));

      }
      int findMaxSteal (int [] wealth){
        return this.findMaxStealRecursive(wealth,0);
      }
      int findMaxStealRecursive(int wealth[],int curIndex){
        
        //base condition
        if (curIndex >= wealth.length){
            return 0;
        }

        int select = wealth[curIndex] + findMaxStealRecursive(wealth, curIndex+2);
        int exclude = findMaxStealRecursive(wealth, curIndex+1);
        return Math.max(select,exclude);
      }

      int findMaxStealMemoize (int [] wealth){
        Integer dp[] = new Integer[wealth.length];
        return this.findMaxStealRecursiveMemoize(wealth,0,dp);
      }
      int findMaxStealRecursiveMemoize(int wealth[],int curIndex,Integer dp[]){
        
        //base condition
        if (curIndex >= wealth.length){
            return 0;
        }
        if (dp[curIndex]!=null){
            return dp[curIndex];
        }

        int select = wealth[curIndex] + findMaxStealRecursive(wealth, curIndex+2);
        int exclude = findMaxStealRecursive(wealth, curIndex+1);
        dp[curIndex] = Math.max(select,exclude);
        return dp[curIndex];
      }



}
