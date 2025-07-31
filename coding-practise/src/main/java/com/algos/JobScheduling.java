package com.algos;

import java.util.Arrays;

public class JobScheduling {
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
    
    public static int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;
        
        // If we have more days than jobs, it's impossible
        if (n < d) {
            return -1;
        }
        
        // dp[i][j] = minimum difficulty to schedule jobs 0 to i in j days
        int[][] dp = new int[n][d + 1];
        
        // Initialize with infinity
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        
        // Base case: first day
        int maxSoFar = 0;
        for (int i = 0; i < n; i++) {
            maxSoFar = Math.max(maxSoFar, jobDifficulty[i]);
            dp[i][1] = maxSoFar;
        }
        
        // Fill dp table
        for (int day = 2; day <= d; day++) {
            for (int i = day - 1; i < n; i++) {
                int maxDifficulty = 0;
                
                // Try all possible splits for current day
                for (int j = i; j >= day - 1; j--) {
                    maxDifficulty = Math.max(maxDifficulty, jobDifficulty[j]);
                    
                    if (dp[j - 1][day - 1] != Integer.MAX_VALUE) {
                        dp[i][day] = Math.min(dp[i][day], dp[j - 1][day - 1] + maxDifficulty);
                    }
                }
            }
        }
        
        return dp[n - 1][d] == Integer.MAX_VALUE ? -1 : dp[n - 1][d];
    }
} 