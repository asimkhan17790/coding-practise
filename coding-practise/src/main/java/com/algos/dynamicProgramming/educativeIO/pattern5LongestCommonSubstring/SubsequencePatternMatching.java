package com.algos.dynamicProgramming.educativeIO.pattern5LongestCommonSubstring;

public class SubsequencePatternMatching {
    public static void main(String[] args) {
        SubsequencePatternMatching spm = new SubsequencePatternMatching();
        System.out.println(spm.findSPMCount("baxmx", "ax"));
        System.out.println(spm.findSPMCount("tomorrow", "tor"));

        System.out.println("--- Memoization ---");
        System.out.println(spm.findSPMCountMemoization("baxmx", "ax"));
        System.out.println(spm.findSPMCountMemoization("tomorrow", "tor"));

        System.out.println("--- Bottom Up DP ---");
        System.out.println(spm.findSPMCountBottomUp("baxmx", "ax"));
        System.out.println(spm.findSPMCountBottomUp("tomorrow", "tor"));

    }

    private int findSPMCount(String str, String pat) {
        return this.findSPMCountRecursive(str, pat, 0, 0);
    }

    private int findSPMCountRecursive(String str, String pat, int strIndex, int patIndex) {

        if (patIndex == pat.length()) {
            return 1;
        }
        if (strIndex == str.length()) {
            return 0;
        }

        int c1 = 0;
        if (str.charAt(strIndex) == pat.charAt(patIndex)) {
            c1 = findSPMCountRecursive(str, pat, strIndex + 1, patIndex + 1);
        }

        int c2 = findSPMCountRecursive(str, pat, strIndex + 1, patIndex);

        return c1 + c2;
    }

    // Memoization
    private int findSPMCountMemoization(String str, String pat) {
        Integer dp[][] = new Integer[str.length()][pat.length()];
        return this.findSPMCountRecursiveMemoization(str, pat, 0, 0, dp);
    }

    private int findSPMCountRecursiveMemoization(String str, String pat, int strIndex, int patIndex, Integer dp[][]) {

        if (patIndex == pat.length()) {
            return 1;
        }
        if (strIndex == str.length()) {
            return 0;
        }

        if (dp[strIndex][patIndex] == null) {
            int c1 = 0;
            if (str.charAt(strIndex) == pat.charAt(patIndex)) {
                c1 = findSPMCountRecursive(str, pat, strIndex + 1, patIndex + 1);
            }

            int c2 = findSPMCountRecursive(str, pat, strIndex + 1, patIndex);

            dp[strIndex][patIndex] = c1 + c2;

        }
        return dp[strIndex][patIndex];
    }

    // Bottom up Dp
    private int findSPMCountBottomUp(String str, String pat) {
        if (pat.length() == 0)
            return 1;

        if (str.length() == 0 || pat.length() > str.length())
            return 0;

        int dp[][] = new int[str.length()+1][pat.length()+1];

        for(int i=0; i<=str.length(); i++){
            dp[i][0] = 1;
        }
            
        for (int i = 1; i <= str.length(); i++) {
            for (int j = 1; j <= pat.length(); j++) {
                if (str.charAt(i-1) == pat.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }
                dp[i][j] += dp[i-1][j];
            }
        }
        return dp[str.length()][pat.length()];
    }

}
