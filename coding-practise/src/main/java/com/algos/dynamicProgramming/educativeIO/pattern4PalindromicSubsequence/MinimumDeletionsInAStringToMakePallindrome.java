package com.algos.dynamicProgramming.educativeIO.pattern4PalindromicSubsequence;

public class MinimumDeletionsInAStringToMakePallindrome {
    public static void main(String[] args) {
        MinimumDeletionsInAStringToMakePallindrome mdsp = new MinimumDeletionsInAStringToMakePallindrome();
        System.out.println(mdsp.findMinimumDeletions("abdbca"));
        System.out.println(mdsp.findMinimumDeletions("cddpd"));
        System.out.println(mdsp.findMinimumDeletions("pqr"));
      }


      private int findMinimumDeletions (String s) {

        int dp[][] = new int [s.length()][s.length()];

        for (int i =0;i<s.length();i++) {
            dp[i][i] = 1;
        }

        for (int startIndex = s.length()-1; startIndex>=0;startIndex--){
            for (int endIndex = startIndex+1;endIndex<s.length();endIndex++){
                if (s.charAt(startIndex) == s.charAt(endIndex)){
                    dp[startIndex][endIndex] = 2 + dp[startIndex+1][endIndex-1];
                }else {
                    dp[startIndex][endIndex] = Math.max(dp[startIndex][endIndex-1], dp[startIndex+1][endIndex]);
                }
            }
        }

        return s.length() - dp[0][s.length()-1];
      }



      /*
      SIMILAR PROBLEMS

      1. Minimum insertions in a string to make it a palindrome#
      2. Find if a string is K-Palindromic#
        Any string will be called K-palindromic if it can be transformed into a palindrome by removing at most ‘K’ characters from it.
        This problem can easily be converted to our base problem of finding the minimum deletions in a string to make it a palindrome. If the “minimum deletion count” is not more than ‘K’, the string will be K-Palindromic.

      */
}
