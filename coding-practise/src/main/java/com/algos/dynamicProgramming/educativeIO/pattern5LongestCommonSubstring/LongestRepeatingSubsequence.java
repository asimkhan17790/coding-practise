package com.algos.dynamicProgramming.educativeIO.pattern5LongestCommonSubstring;

public class LongestRepeatingSubsequence {
    public static void main(String[] args) {
        LongestRepeatingSubsequence lrs = new LongestRepeatingSubsequence();
        System.out.println(lrs.findLRSLength("tomorrow"));
        System.out.println(lrs.findLRSLength("aabdbcec"));
        System.out.println(lrs.findLRSLength("fmff"));

        System.out.println("-- Memoization --");
        System.out.println(lrs.findLRSLengthMemoize("tomorrow"));
        System.out.println(lrs.findLRSLengthMemoize("aabdbcec"));
        System.out.println(lrs.findLRSLengthMemoize("fmff"));

        System.out.println("-- Bottom Up Dp --");
        System.out.println(lrs.findLRSLengthBottomUp("tomorrow"));
        System.out.println(lrs.findLRSLengthBottomUp("aabdbcec"));
        System.out.println(lrs.findLRSLengthBottomUp("fmff"));


      }

      private int findLRSLength(String s){
        return this.findLRSLengthRecursive(s, 0, 0);
      }
      
      private int findLRSLengthRecursive(String s, int i1, int i2){
        if (i1 == s.length() || i2 == s.length()){
            return 0;
        }
        if (i1!=i2 && s.charAt(i1)==s.charAt(i2)){
            return 1 + findLRSLengthRecursive(s, i1+1, i2+1);
        }
        int c1 = findLRSLengthRecursive(s, i1+1, i2);
        int c2 = findLRSLengthRecursive(s, i1, i2+1);

        return Math.max(c1, c2);

      }

      //Memoization

      private int findLRSLengthMemoize(String s){
        Integer dp[][] = new Integer[s.length()][s.length()];
        return this.findLRSLengthRecursiveMemoize(s, 0, 0, dp);
      }
      
      private int findLRSLengthRecursiveMemoize(String s, int i1, int i2, Integer [][] dp){
        if (i1 == s.length() || i2 == s.length()){
            return 0;
        }

        if (dp[i1][i2] == null) {
            
          if (i1!=i2 && s.charAt(i1)==s.charAt(i2)){
              dp[i1][i2] = 1 + findLRSLengthRecursive(s, i1+1, i2+1);
          } else {
            int c1 = findLRSLengthRecursive(s, i1+1, i2);
            int c2 = findLRSLengthRecursive(s, i1, i2+1);
            dp[i1][i2] = Math.max(c1, c2);
          } 
        }
        return dp[i1][i2];
      }

      // Bottom Up DP
      private int findLRSLengthBottomUp(String s) {
        int dp [][] = new int [s.length()+1][s.length()+1];

        int max = 0;

        for (int i =1;i<=s.length();i++) {
          for (int j = 1;j<=s.length();j++) {
               if (i!=j && s.charAt(i-1)==s.charAt(j-1)) {
                 dp[i][j] = 1 + dp[i-1][j-1];
               }else {
                 dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
               }
               max = Math.max(max, dp[i][j]);
          }
        }

        return max;
      }
}
