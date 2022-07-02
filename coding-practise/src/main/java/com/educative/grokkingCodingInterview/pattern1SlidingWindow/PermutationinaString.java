package com.educative.grokkingCodingInterview.pattern1SlidingWindow;

import java.util.Arrays;

// Find permutation of a pattern in give String
public class PermutationinaString {

    public static void main(String[] args) {
        System.out.println(doesPatternMatch("oidbcaf","abc"));
        System.out.println(doesPatternMatch("odicf","dc"));
        System.out.println(doesPatternMatch("abcd","dcba"));
    }

    private static boolean doesPatternMatch(String str, String pattern){

        int m = pattern.length();
        int n = str.length();
        if (n<m) {
            return false;
        }

        int freq1[] = new int [26];// for pattern
        int freq2 [] = new int[26];//for string

        for (int i =0;i<m;i++){
            freq1[pattern.charAt(i) - 'a']++;
            freq2[str.charAt(i)- 'a']++;
        }

        for (int end =m;end<n;end++){
            if (Arrays.equals(freq1,freq2)) return true;

            freq2[str.charAt(end) - 'a']++;

            freq2[str.charAt(end-m) - 'a']--;

        }
        if (Arrays.equals(freq1,freq2)) return true;

        return false;
    }
}
