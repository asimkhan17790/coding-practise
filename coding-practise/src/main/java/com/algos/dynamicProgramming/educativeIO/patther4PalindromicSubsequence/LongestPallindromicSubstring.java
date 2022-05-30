package com.algos.dynamicProgramming.educativeIO.patther4PalindromicSubsequence;

public class LongestPallindromicSubstring {
    public static void main(String[] args) {
        LongestPallindromicSubstring lps = new LongestPallindromicSubstring();
        System.out.println(lps.findLPSLength("abdbca"));
        System.out.println(lps.findLPSLength("cddpd"));
        System.out.println(lps.findLPSLength("pqr"));

        // Memoization
        System.out.println("--- Memoization ---");
        LongestPallindromicSubstring lps2 = new LongestPallindromicSubstring();
        System.out.println(lps2.findLPSLengthMemoize("abdbca"));
        System.out.println(lps2.findLPSLengthMemoize("cddpd"));
        System.out.println(lps2.findLPSLengthMemoize("pqr"));

      }


      private int findLPSLength (String s) {
        return this.findLPSLengthRecursive(s, 0, s.length()-1);
      }
      private int findLPSLengthRecursive(String s, int startIndex, int endIndex) {

        if (startIndex > endIndex){
            return 0;
        }
        if (startIndex == endIndex){
            return 1;
        }

        if (s.charAt(startIndex)== s.charAt(endIndex)){
            int remainingLength = endIndex-startIndex-1;
            if (remainingLength == findLPSLengthRecursive(s, startIndex+1,endIndex-1)){
                return 2 + remainingLength;
            }
        }

        int c1 = findLPSLengthRecursive(s, startIndex+1, endIndex);
        int c2 = findLPSLengthRecursive(s, startIndex, endIndex-1);
        return Math.max(c1, c2);
        
      }

      // Memoization
      private int findLPSLengthMemoize(String s){
        Integer dp[][] = new Integer[s.length()][s.length()];
        return this.findLPSLengthRecursiveMemoize(s, dp, 0, s.length()-1);
      }

      private int findLPSLengthRecursiveMemoize(String s, Integer [][] dp, int startIndex, int endIndex) {
        if (startIndex > endIndex){
            return 0;
        }
        if (startIndex == endIndex){
            return 1;
        }
        if (dp[startIndex][endIndex] == null){
            if (s.charAt(startIndex)== s.charAt(endIndex)){
                int remainingLength = endIndex-startIndex-1;
                if (remainingLength == findLPSLengthRecursive(s, startIndex+1,endIndex-1)){
                    dp[startIndex][endIndex] =  2 + remainingLength;
                }
            }
            int c1 = findLPSLengthRecursive(s, startIndex+1, endIndex);
            int c2 = findLPSLengthRecursive(s, startIndex, endIndex-1);
            dp[startIndex][endIndex] = Math.max(c1, c2);
        }        
        
        return dp[startIndex][endIndex];
      }
}
