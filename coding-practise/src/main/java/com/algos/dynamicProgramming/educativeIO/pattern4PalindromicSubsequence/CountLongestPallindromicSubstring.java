package com.algos.dynamicProgramming.educativeIO.pattern4PalindromicSubsequence;

public class CountLongestPallindromicSubstring {
    public static void main(String[] args) {
        CountLongestPallindromicSubstring cps = new CountLongestPallindromicSubstring();
        System.out.println(cps.findCPS("abdbca"));
        System.out.println(cps.findCPS("cdpdd"));
        System.out.println(cps.findCPS("pqr"));
    
    }

    private int findCPS (String s) {
    
        boolean dp [][] = new boolean[s.length()][s.length()];

        int count = 0;
        for (int i = 0;i<s.length();i++) {
            dp[i][i] = true;
            count++;
        }
        
        for (int startIndex = s.length()-1;startIndex>=0;startIndex--) {
            for (int endIndex=startIndex+1;endIndex<s.length();endIndex++){
                if (s.charAt(startIndex)==s.charAt(endIndex)){
                    if (endIndex-startIndex==1 || dp[startIndex+1][endIndex-1]){
                        dp[startIndex][endIndex]=true;
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
