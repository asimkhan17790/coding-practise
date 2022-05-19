package com.algos.dynamicProgramming.educativeIO.knapsack;

public class SubsetSumBottomUp {

    public static void main(String[] args) {        
            int[] num = { 1, 2, 3, 7 };
            System.out.println(canPartition(num, 6));
            num = new int[] { 1, 2, 7, 1, 5 };
            System.out.println(canPartition(num, 10));
            num = new int[] { 1, 3, 4, 8 };
            System.out.println(canPartition(num, 6));
    }


    public static boolean canPartition (int [] num, int SUM) {

        boolean dp [][] = new boolean [num.length][SUM+1];
        for (int i = 0; i < num.length;i++) {
            dp [i][0] = true;
        }
        for (int s = 0;s <= SUM;s++) {
            dp[0][s] = (num[0]==s ? true:false);
        }

        for (int i = 1;i<num.length;i++) {
            for (int s=1; s <= SUM; s++){
                if (dp[i-1][s]) {
                    dp[i][s] = dp [i-1][s];
                }
                else if (num[i]<=s) {
                    dp [i][s] = dp[i-1][s-num[i]];
                }
            }
        }
        return dp[num.length-1][SUM];
    }    
}
