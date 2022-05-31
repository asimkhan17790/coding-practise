package com.algos.dynamicProgramming.educativeIO.pattern5LongestCommonSubstring;

public class LongestCommonSubstring {
    public static void main(String[] args) {
        LongestCommonSubstring lcs = new LongestCommonSubstring();
        System.out.println(lcs.findLCSLength("abdca", "cbda"));
        System.out.println(lcs.findLCSLength("passport", "ppsspt"));

        // Memoize
        System.out.println("--- Memoization ---");
        System.out.println(lcs.findLCSLengthMemoize("abdca", "cbda"));
        System.out.println(lcs.findLCSLengthMemoize("passport", "ppsspt"));

        // BottomUp
        
        System.out.println("Bottom Up");
        System.out.println(lcs.findLCSBottomUP("abdca", "cbda"));
        System.out.println(lcs.findLCSBottomUP("passport", "ppsspt"));
        
      }


      private int findLCSLength (String str1, String str2) {
        return this.findLCSLengthRecursive(str1,str2,0,0,0);
      }

      private int findLCSLengthRecursive(String str1, String str2, int i1, int i2, int count){

        // base case
        if (i1==str1.length() || i2==str2.length()){
            return count;
        }

        if (str1.charAt(i1)==str2.charAt(i2)){
            count= findLCSLengthRecursive(str1, str2, i1+1, i2+1, count+1);
        }
        int c1 = findLCSLengthRecursive(str1, str2, i1+1, i2, 0);
        int c2 = findLCSLengthRecursive(str1, str2, i1, i2+1, 0);

        return Math.max(count, Math.max(c1, c2));
      }
      //Memoization

      private int findLCSLengthMemoize (String str1, String str2) {
        int maxLength = Math.min(str1.length(), str2.length());
        Integer[][][] dp = new Integer[str1.length()][str2.length()][maxLength];
        return this.findLCSLengthRecursiveMemoize(str1,str2,0,0,0, dp);
      }

      private int findLCSLengthRecursiveMemoize(String str1, String str2, int i1, int i2, int count, Integer [][][] dp){

        // base case
        if (i1==str1.length() || i2==str2.length()){
            return count;
        }

        if (dp[i1][i2][count] == null){
            int c = count;
            if (str1.charAt(i1)==str2.charAt(i2)){
                    c= findLCSLengthRecursive(str1, str2, i1+1, i2+1, count+1);
                }
                int c1 = findLCSLengthRecursive(str1, str2, i1+1, i2, 0);
                int c2 = findLCSLengthRecursive(str1, str2, i1, i2+1, 0);
                dp[i1][i2][count] =Math.max(c, Math.max(c1, c2));
        }
        return dp[i1][i2][count];
      }

      // BOTTOM UP DP

      private int findLCSBottomUP(String s1, String s2){

        int dp[][] = new int[s1.length()+1][s2.length()+1];
        for (int i =0;i<=s1.length();i++){
            dp[i][0]=0;
        }
        for (int i =0;i<=s2.length();i++){
            dp[0][i]=0;
        }
        int max = 0;
        for (int i = 1;i<=s1.length();i++) {
            for (int j = 1;j<=s2.length();j++) {
                if (s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]= 1+ dp[i-1][j-1];
                    max = Math.max(max, dp[i][j]);
                }else {
                    dp[i][j]=0;
                }
            }
        }
        return max;
      }
}
