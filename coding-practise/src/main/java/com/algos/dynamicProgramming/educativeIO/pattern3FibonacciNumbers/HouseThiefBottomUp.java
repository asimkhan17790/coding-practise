package com.algos.dynamicProgramming.educativeIO.pattern3FibonacciNumbers;

public class HouseThiefBottomUp {
    
    public static void main(String[] args) {
        HouseThiefBottomUp ht = new HouseThiefBottomUp();
        int[] wealth = {2, 5, 1, 3, 6, 2, 4};
        System.out.println(ht.findMaxSteal(wealth));
        wealth = new int[]{2, 10, 14, 8, 1};
        System.out.println(ht.findMaxSteal(wealth));
    }

    public int findMaxSteal(int [] wealth){

        int dp[] = new int[wealth.length+1];
        dp[0] = 0;
        dp[1] = wealth[0];


        for (int i = 1; i < wealth.length; i++){
            dp[i+1] = Math.max(dp[i], dp[i-1] + wealth[i]); // IMPORTANT!!!
        }
        return dp[wealth.length];
    }
}
