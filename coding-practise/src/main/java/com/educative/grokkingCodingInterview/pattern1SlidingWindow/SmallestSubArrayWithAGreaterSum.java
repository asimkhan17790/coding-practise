package com.educative.grokkingCodingInterview.pattern1SlidingWindow;

/*
 Given an array of positive integers and a number ‘S,’ find the length of the smallest contiguous subarray whose sum is greater than or equal to ‘S’. Return 0 if no such subarray exists.

Example 1:

Input: [2, 1, 5, 2, 3, 2], S=7
Output: 2
Explanation: The smallest subarray with a sum greater than or equal to ‘7’ is [5, 2].
 */
public class SmallestSubArrayWithAGreaterSum {

    public static void main(String[] args) {
        SmallestSubArrayWithAGreaterSum s = new SmallestSubArrayWithAGreaterSum();
        int result = s.findMinSubArray(7, new int[] { 2, 1, 5, 2, 3, 2 });
        System.out.println("Smallest subarray length: " + result);
        result = s.findMinSubArray(8, new int[] { 3, 4, 1, 1, 6 });
        System.out.println("Smallest subarray length: " + result);
        result = s.findMinSubArray(8, new int[] { 2, 1, 5, 2, 3, 2});
        System.out.println("Smallest subarray length: " + result);
      }

      private int findMinSubArray(int s, int[] nums){
        
        int min = Integer.MAX_VALUE;
        int startIndex = 0;
        int windowSum =0;

        for (int end=0;end<nums.length;end++) {
            windowSum+=nums[end];
            while (windowSum >= s){
                min = Math.min(min, end-startIndex+1);
                windowSum-=nums[startIndex];
                startIndex++;
            }
        }
        return min==Integer.MAX_VALUE?0:min;
      }
    
}
