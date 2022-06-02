package com.algos.dynamicProgramming.educativeIO.pattern5LongestCommonSubstring;

public class ShortestCommonSupersequence {
    public static void main(String[] args) {
        ShortestCommonSupersequence scs = new ShortestCommonSupersequence();
        System.out.println(scs.findSCSLength("abcf", "bdcf"));
        System.out.println(scs.findSCSLength("dynamic", "programming"));

        // LEET CODE
        System.out.println("--- Leetcode Solution Using Shortest Common Subsequence ---");
        System.out.println(scs.getSCSLengthLeetcode("abcf", "bdcf"));
        System.out.println(scs.getSCSLengthLeetcode("dynamic", "programming"));
        
      }

      private int findSCSLength (String s1, String s2) {
        int dp [][] = new int [s1.length()+1][s2.length()+1];

        for (int i =0;i<=s1.length();i++) {
            dp[i][0] = i;
        } 
        for (int i =0;i<=s2.length();i++) {
            dp[0][i] = i;
        }   

        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else {
                    dp[i][j] = 1 + Math.min( dp[i-1][j], dp[i][j-1]);
                }
            }
        }   
  

        return dp[s1.length()][s2.length()];
      }
      private int getSCSLengthLeetcode(String str1, String str2) {
        return this.shortestCommonSupersequence(str1, str2).length();
      }

      // Leet Code Solution
      public String shortestCommonSupersequence(String str1, String str2) {
        
        
        if (str1.length() == 0 || str2.length() == 0){
            return str1.length() == 0 ? str2:str1;
        }
        
        int m = str1.length();
        int n = str2.length();
        int C[][] = new int [m+1][n+1];
        
        for (int i = 0;i<=m;i++){
            C[i][0]=0;
        }
        for (int i = 0;i<=n;i++){
            C[0][i] = 0;
        }
        
        for (int i = 1;i<=m;i++){
            for (int j = 1;j<=n;j++){                
                if (str1.charAt(i-1) == str2.charAt(j-1)){
                    C[i][j] = 1 + C[i-1][j-1];
                }else {
                    C[i][j] = Math.max(C[i][j-1],C[i-1][j]);
                }
            }
        }
        
        int l = C[m][n];
        StringBuilder s = new StringBuilder("");
        
        int i = m;
        int j = n;
        while (i > 0 && j > 0){
            if (str1.charAt(i-1) == str2.charAt(j-1)){
                s.append(str1.charAt(i-1));
                i--;
                j--;
            }else if (C[i-1][j] > C[i][j-1]){
                s.append(str1.charAt(i-1));
                i--;
            } else {
                s.append(str2.charAt(j-1));
                j--;
            }
        }
        while (i>0){
            s.append(str1.charAt(i-1));
            i--;
        }
        
        while (j>0){
            s.append(str2.charAt(j-1));
            j--;
        }     
        
        
        return s.reverse().toString();
        
    }
}
