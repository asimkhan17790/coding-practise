package com.educative.grokkingCodingInterview.pattern1SlidingWindow;

import java.util.HashMap;
import java.util.Map;

// Coudnt understand
public class SmallestWindowContainingSubstring {

    public static void main(String[] args) {
        System.out.println(findSubstring("aabdec", "abc"));
        System.out.println(findSubstring("abdbca", "abc"));
        System.out.println(findSubstring("aabdec", "abac"));
    }

    public static String findSubstring(String str, String pattern) {

        Map<Character, Integer> map = new HashMap<>();

        pattern.chars().mapToObj(e -> (char) e).forEach(c -> map.put(c, map.getOrDefault(c, 0) + 1));

        int match = 0;
        int start = 0;
        int minLength = str.length() + 1;
        int subStrStart = 0;

        for (int end = 0; end < str.length(); end++) {
            char c = str.charAt(end);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) >= 0) {
                    match++;
                }
            }
            while (match == pattern.length()) {
                if (minLength > end - start + 1) {
                    minLength = end - start + 1;
                    subStrStart = start;
                }

                char leftChar = str.charAt(start++);
                if (map.containsKey(leftChar)) {
                    // note that we could have redundant matching characters, therefore we'll decrement the
                    // matched count only when a useful occurrence of a matched character is going out of the window
                    if (map.get(leftChar) == 0)
                        match--;
                    map.put(leftChar, map.get(leftChar) + 1);
                }
            }
        }
        return minLength > str.length() ? "" : str.substring(subStrStart, subStrStart + minLength);

    }
}


