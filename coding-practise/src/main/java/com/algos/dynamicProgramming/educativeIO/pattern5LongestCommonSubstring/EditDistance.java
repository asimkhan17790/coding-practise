package com.algos.dynamicProgramming.educativeIO.pattern5LongestCommonSubstring;

import javax.sound.midi.Soundbank;

public class EditDistance {
    public static void main(String[] args) {
        EditDistance editDisatnce = new EditDistance();
        System.out.println(" --- Brute Force Recursion ---");
        System.out.println(editDisatnce.findMinOperations("bat", "but"));
        System.out.println(editDisatnce.findMinOperations("abdca", "cbda"));
        System.out.println(editDisatnce.findMinOperations("passpot", "ppsspqrt"));

        System.out.println(" --- Memoization ---");
        System.out.println(editDisatnce.findMinOperationsMemoize("bat", "but"));
        System.out.println(editDisatnce.findMinOperationsMemoize("abdca", "cbda"));
        System.out.println(editDisatnce.findMinOperationsMemoize("passpot", "ppsspqrt"));

        System.out.println(" --- Bottom Up DP ---");
        System.out.println(editDisatnce.findMinOperationsBottomUp("bat", "but"));
        System.out.println(editDisatnce.findMinOperationsBottomUp("abdca", "cbda"));
        System.out.println(editDisatnce.findMinOperationsBottomUp("passpot", "ppsspqrt"));
    }

    private int findMinOperations(String s1, String s2) {
        return this.findMinOperationsRecursive(s1, s2, 0, 0);
    }

    private int findMinOperationsRecursive(String s1, String s2, int i1, int i2) {
        if (i1 == s1.length()) {
            return s2.length() - i2;
        }
        if (i2 == s2.length()) {
            return s1.length() - i1;
        }
        if (s1.charAt(i1) == s2.charAt(i2)) {
            return findMinOperationsRecursive(s1, s2, i1 + 1, i2 + 1);
        }
        int c1 = 1 + findMinOperationsRecursive(s1, s2, i1 + 1, i2);
        int c2 = 1 + findMinOperationsRecursive(s1, s2, i1, i2 + 1);
        int c3 = 1 + findMinOperationsRecursive(s1, s2, i1 + 1, i2 + 1);

        return Math.min(c1, Math.min(c2, c3));
    }

    // Memoization
    private int findMinOperationsMemoize(String s1, String s2) {
        Integer dp[][] = new Integer[s1.length() + 1][s2.length() + 1];
        return this.findMinOperationsRecursiveMemoize(dp, s1, s2, 0, 0);
    }

    private int findMinOperationsRecursiveMemoize(Integer[][] dp, String s1, String s2, int i1, int i2) {

        if (dp[i1][i2] == null) {
            if (i1 == s1.length()) {
                dp[i1][i2] = s2.length() - i2;
            } else if (i2 == s2.length()) {
                dp[i1][i2] = s1.length() - i1;
            } else if (s1.charAt(i1) == s2.charAt(i2)) {
                dp[i1][i2] = findMinOperationsRecursive(s1, s2, i1 + 1, i2 + 1);
            } else {
                int c1 = 1 + findMinOperationsRecursive(s1, s2, i1 + 1, i2);
                int c2 = 1 + findMinOperationsRecursive(s1, s2, i1, i2 + 1);
                int c3 = 1 + findMinOperationsRecursive(s1, s2, i1 + 1, i2 + 1);
                dp[i1][i2] = Math.min(c1, Math.min(c2, c3));
            }
        }
        return dp[i1][i2];
    }

    // Bottom Up DP
    private int findMinOperationsBottomUp(String s1, String s2) {
        int dp[][] = new int[s1.length() + 1][s2.length() + 1];

        for (int i = 0; i <= s1.length(); i++) {
            dp[i][0] = i;
        }

        for (int i = 0; i <= s2.length(); i++) {
            dp[0][1] = i;
        }

        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
                }

            }
        }
        return dp[s1.length()][s2.length()];

    }
}
