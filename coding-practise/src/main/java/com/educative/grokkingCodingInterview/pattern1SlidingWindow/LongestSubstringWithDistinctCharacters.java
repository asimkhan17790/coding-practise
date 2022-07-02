package com.educative.grokkingCodingInterview.pattern1SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithDistinctCharacters {
    public static void main(String[] args) {
        System.out.println("Length of the longest substring: " + LongestSubstringWithDistinctCharacters.findLength("aabccbb"));
        System.out.println("Length of the longest substring: " + LongestSubstringWithDistinctCharacters.findLength("abbbb"));
        System.out.println("Length of the longest substring: " + LongestSubstringWithDistinctCharacters.findLength("abccde"));

        System.out.println("Length of the longest substring: " + LongestSubstringWithDistinctCharacters.findLength("abccdercsbbb"));
      }

    /* private static int findLength (String str) {
        int maxLength = 0;
        int start = 0;
        Map<Character,Integer> map = new HashMap<>();

        for (int end = 0;end < str.length(); end++) {
            Character c = str.charAt(end);
            if (map.get(c)!=null) {
                start = Math.max(start, map.get(c) + 1);                               
            }
            map.put(c, end);
            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength;
      } */

      private static int findLength (String str) {
        int max = 0;
        int start = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (int end =0;end<str.length();end++) {
            Character c = str.charAt(end);
            
            if (map.get(c)!=null){                    
                start = Math.max(start, map.get(c) + 1);     // Important
            }
            map.put(c, end);
            max = Math.max(max,end-start+1);
        }
        return max;

      }
}
