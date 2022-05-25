package com.algos.dynamicProgramming.educativeIO.pattern3FibonacciNumbers;

/*
Problem Statement#
Given a number ‘n’, implement a method to count how many possible ways there are to express ‘n’ as the sum of 1, 3, or 4.

Example 1:

n : 4
Number of ways = 4
Explanation: Following are the four ways we can express 'n' : {1,1,1,1}, {1,3}, {3,1}, {4} 
Example 2:

n : 5
Number of ways = 6
Explanation: Following are the six ways we can express 'n' : {1,1,1,1,1}, {1,1,3}, {1,3,1}, {3,1,1}, 
{1,4}, {4,1}


*/
public class NumberFactors {
    public static void main(String[] args) {
        NumberFactors en = new NumberFactors();
        System.out.println(en.countWays(4));
        System.out.println(en.countWays(5));
        System.out.println(en.countWays(6));
    }
    public int countWays(int n) {

        int dp[] = new int[n+1];

        if (n<=2){
            return 1;
        }
        if (n==3){
            return 2;
        }

        dp[0]=1;
        dp[1]=1;
        dp[2]=1;
        dp[3]=2;
        for (int i =4;i<=n;i++) {
            dp[i] = dp[i-1]+dp[i-3]+dp[i-4];
        }
        return dp[n];
    }
}
