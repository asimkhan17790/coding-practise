package com.algos.dynamicProgramming.educativeIO.patther4PalindromicSubsequence;

import java.io.LineNumberInputStream;

public class LongestPallindromicSubstringBottomUp {
    public static void main(String[] args) {
        LongestPallindromicSubstringBottomUp lps = new LongestPallindromicSubstringBottomUp();
        System.out.println(lps.findLPSLength("abdbca"));
        System.out.println(lps.findLPSLength("cdpdd"));
        System.out.println(lps.findLPSLength("pqr"));
      }

      private int findLPSLength(String s) {

        boolean dp[][] = new boolean[s.length()][s.length()];
        for (int i = 0;i<s.length();i++) {
            dp[i][i] = true;
        }

        int maxLength =1 ;
        for (int startIndex = s.length()-1;startIndex>=0;startIndex--) {
            for (int endIndex = startIndex+1;endIndex<s.length();endIndex++) {
                if (s.charAt(startIndex) == s.charAt(endIndex)){
                    if (endIndex-startIndex ==1 || dp[startIndex+1][endIndex-1]) {
                        dp[startIndex][endIndex]=true;
                        maxLength = Math.max(maxLength, endIndex-startIndex+1);
                    }
                }
            }
        }
        return maxLength;
      }
}
