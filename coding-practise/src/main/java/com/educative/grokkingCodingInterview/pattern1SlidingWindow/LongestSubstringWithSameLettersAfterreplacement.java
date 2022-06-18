package com.educative.grokkingCodingInterview.pattern1SlidingWindow;

import java.util.HashMap;
import java.util.Map;

/*
 Problem Statement#
Given a string with lowercase letters only, if you are allowed to replace no more than k letters with any letter, find the length of the longest substring having the same letters after replacement.

Example 1:

Input: String="aabccbb", k=2
Output: 5
Explanation: Replace the two 'c' with 'b' to have the longest repeating substring "bbbbb".
Example 2:

Input: String="abbcb", k=1
Output: 4
Explanation: Replace the 'c' with 'b' to have the longest repeating substring "bbbb".
Example 3:

Input: String="abccde", k=1
Output: 3
Explanation: Replace the 'b' or 'd' with 'c' to have the longest repeating substring "ccc".
 */

public class LongestSubstringWithSameLettersAfterreplacement {
    public static void main(String[] args) {
        System.out.println(LongestSubstringWithSameLettersAfterreplacement.findLength("aabccbb", 2));
        System.out.println(LongestSubstringWithSameLettersAfterreplacement.findLength("abbcb", 1));
        System.out.println(LongestSubstringWithSameLettersAfterreplacement.findLength("abccde", 1));
        System.out.println(LongestSubstringWithSameLettersAfterreplacement.findLength("bbbbbabbbbasdbb", 1));
    }


    private static int findLength(String str, int k){
        
        int maxRepeatingCount =0;
        Map<Character, Integer> map = new HashMap<>();
        int start =0;
        int maxLength=0;

        for (int end =0;end<str.length();end++) {
            Character c = str.charAt(end);
            map.put(c, map.getOrDefault(c, 0) + 1);
            maxRepeatingCount = Math.max(maxRepeatingCount, map.get(c));

            if (end-start+1-maxRepeatingCount>k) {
                Character l = str.charAt(start);
                map.put(l, map.get(l)-1);
                start++;
            }
            
            maxLength = Math.max(maxLength, end-start+1);
        }



        return maxLength;
    }
}
