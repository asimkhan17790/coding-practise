package com.algos.dynamicProgramming.educativeIO.patther4PalindromicSubsequence;

public class LongestPalindromicSubsequence {

    public static void main(String[] args) {
        LongestPalindromicSubsequence lps = new LongestPalindromicSubsequence();
        System.out.println(lps.findLPSLength("abdbca"));
        System.out.println(lps.findLPSLength("cddpd"));
        System.out.println(lps.findLPSLength("pqr"));

        // Memoization
        System.out.println("Memoization: --- ");
        System.out.println(lps.findLPSLengthMemoize("abdbca"));
        System.out.println(lps.findLPSLengthMemoize("cddpd"));
        System.out.println(lps.findLPSLengthMemoize("pqr"));

    }

    private int findLPSLength(String s) {

            return  this.findLPSLengthRecursive(s, 0,s.length()-1);

    }
    private int findLPSLengthRecursive(String s, int startIndex, int endIndex) {

        if (startIndex > endIndex){
            return 0;
        }
        if (startIndex == endIndex){
            return 1;
        }

        if (s.charAt(startIndex)==s.charAt(endIndex)){
            return 2 + findLPSLengthRecursive(s, startIndex + 1 , endIndex - 1);
        }
        int c1 = findLPSLengthRecursive(s, startIndex + 1, endIndex);
        int c2 = findLPSLengthRecursive(s, startIndex , endIndex - 1);
        return Math.max(c1, c2);
    }    


    // Memoization
     private int findLPSLengthMemoize(String s) {
            Integer dp[][] = new Integer[s.length()][s.length()];
            return  this.findLPSLengthRecursiveMemoize(dp, s, 0,s.length()-1);

    }
    private int findLPSLengthRecursiveMemoize(Integer[][] dp, String s, int startIndex, int endIndex) {

        if (startIndex > endIndex){
            return 0;
        }
        if (startIndex == endIndex){
            return 1;
        }

        if (dp[startIndex][endIndex] == null) {
            if (s.charAt(startIndex)==s.charAt(endIndex)){
                dp[startIndex][endIndex] = 2 + findLPSLengthRecursive(s, startIndex + 1 , endIndex - 1);                
            } else {
                int c1 = findLPSLengthRecursive(s, startIndex + 1, endIndex);
                int c2 = findLPSLengthRecursive(s, startIndex , endIndex - 1);
                dp[startIndex][endIndex] =  Math.max(c1, c2);
            }
        }
        
        return dp[startIndex][endIndex];
    }
}
