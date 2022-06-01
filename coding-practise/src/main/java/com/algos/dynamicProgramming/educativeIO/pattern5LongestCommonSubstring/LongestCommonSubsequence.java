package com.algos.dynamicProgramming.educativeIO.pattern5LongestCommonSubstring;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        System.out.println(lcs.findLCSLength("abdca", "cbda"));
        System.out.println(lcs.findLCSLength("passport", "ppsspt"));

        // Memoization
        System.out.println("--- Memoization ---");
        System.out.println(lcs.findLCSLengthMemoize("abdca", "cbda"));
        System.out.println(lcs.findLCSLengthMemoize("passport", "ppsspt"));

        // Memoization
        System.out.println("--- Bottom Up ---");
        System.out.println(lcs.findLCSLengthBottomUp("abdca", "cbda"));
        System.out.println(lcs.findLCSLengthBottomUp("passport", "ppsspt"));
    }

    // recursive
    private int findLCSLength(String s1, String s2) {
        return this.findLCSLengthRecursive(s1, s2, 0, 0);
    }

    private int findLCSLengthRecursive(String s1, String s2, int i1, int i2) {
        if (s1.length() == i1 || s2.length() == i2) {
            return 0;
        }

        if (s1.charAt(i1) == s2.charAt(i2)) {
            return 1 + findLCSLengthRecursive(s1, s2, i1 + 1, i2 + 1);
        }

        int c1 = findLCSLengthRecursive(s1, s2, i1 + 1, i2);
        int c2 = findLCSLengthRecursive(s1, s2, i1, i2 + 1);
        return Math.max(c1, c2);
    }

    // Memoization
    // recursive
    private int findLCSLengthMemoize(String s1, String s2) {
        Integer dp[][] = new Integer[s1.length()][s2.length()];
        return this.findLCSLengthRecursiveMemoize(s1, s2, 0, 0, dp);
    }

    private int findLCSLengthRecursiveMemoize(String s1, String s2, int i1, int i2, Integer [][] dp) {
        if (s1.length() == i1 || s2.length() == i2) {
            return 0;
        }

        if (dp[i1][i2]==null) {
            if (s1.charAt(i1) == s2.charAt(i2)) {
                dp[i1][i2] = 1 + findLCSLengthRecursive(s1, s2, i1 + 1, i2 + 1);
            }
    
            int c1 = findLCSLengthRecursive(s1, s2, i1 + 1, i2);
            int c2 = findLCSLengthRecursive(s1, s2, i1, i2 + 1);
            dp[i1][i2] = Math.max(c1, c2);
    
        }
        return dp[i1][i2];
    }

    // Bottom UP DP
    private int findLCSLengthBottomUp(String s1, String s2) {
        int dp[][] = new int[s1.length()+1][s2.length()+1];

        int max =0;

        for (int i =1;i<=s1.length();i++){
            for (int j =1;j<=s2.length();j++){
                if (s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j]= 1+ dp[i-1][j-1];
                }else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }

                max = Math.max(max, dp[i][j]);
            }
        }        
        return max;
    }
}
