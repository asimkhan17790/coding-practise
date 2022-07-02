package com.educative.grokkingCodingInterview.pattern1SlidingWindow;

public class LongestSubarraywithOnesAfterReplacement {
    public static void main(String[] args) {
        System.out.println(LongestSubarraywithOnesAfterReplacement.findLength(new int[] { 0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1 }, 2));
        System.out.println(LongestSubarraywithOnesAfterReplacement.findLength(new int[] { 0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1 }, 3));
    }
    private static int findLength(int [] ar, int k){

        int maxLength = 0;
        int maxRepeatingOnes =0;
        int start =0;

        for (int end =0;end<ar.length;end++) {
            int i = ar[end];
            if (i == 1){
                maxRepeatingOnes++;
            }

            if (end-start+1-maxRepeatingOnes>k) {
                if(ar[start]==1){
                    maxRepeatingOnes--;
                }
                start++;
            }
            maxLength = Math.max(maxLength, end-start+1);
        }
        return maxLength;
    }
}
