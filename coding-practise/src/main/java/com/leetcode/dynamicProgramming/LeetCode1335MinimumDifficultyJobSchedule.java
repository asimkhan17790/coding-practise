package com.leetcode.dynamicProgramming;

import java.util.Arrays;

public class LeetCode1335MinimumDifficultyJobSchedule {

    public static void main(String[] args) {
        int[] jobDifficulty = {6, 5, 4, 3, 2, 1};
        int d = 2;

        System.out.println("Job Difficulty: " + Arrays.toString(jobDifficulty));
        System.out.println("Days: " + d);
        System.out.println("Minimum difficulty: " + minDifficulty(jobDifficulty, d));

        // Test case 2
        int[] jobDifficulty2 = {9, 9, 9};
        int d2 = 4;
        System.out.println("\nJob Difficulty: " + Arrays.toString(jobDifficulty2));
        System.out.println("Days: " + d2);
        System.out.println("Minimum difficulty: " + minDifficulty(jobDifficulty2, d2));
    }

    static int minDifficulty (int [] jobDifficulty, int days) {

        int len = jobDifficulty.length;
        // If we have more days than jobs, it's impossible
        if (len < days) {
            return -1;
        }
        Integer [][] dp  = new Integer [len][days+1];
        return minDiffHelper (jobDifficulty, len, dp, 0, days);
    }
    static int minDiffHelper (int [] jobDifficulty, int len, Integer[][] dp , int index, int d) {
        // Base Case
        if (d == 1) {
            int curMax = -1;
            for (int i = index; i<len; i++) {
                curMax=Math.max(curMax, jobDifficulty[i]);
            }
            return curMax;
        }
        // check cache
        if (dp[index][d] != null) {
            return dp [index][d];
        }
        int curMax = Integer.MIN_VALUE;
        int jobMin = Integer.MAX_VALUE;
        for (int i = index; i < len-d+1;i++ ) {
            curMax = Math.max(curMax, jobDifficulty[i]);
            int jobCost = curMax +
                    minDiffHelper(jobDifficulty, len, dp, i+1, d-1);
            jobMin = Math.min(jobCost, jobMin);
        }
        dp [index][d] = jobMin;
        return jobMin;
    }
}
