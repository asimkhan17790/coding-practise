package com.educative.grokkingCodingInterview.pattern1SlidingWindow;

public class MaxSumSubArrayOfSizeK {
    public static void main(String[] args) {
        System.out.println("Maximum sum of a subarray of size K: "
            + MaxSumSubArrayOfSizeK.findMaxSumSubArray(3, new int[] { 2, 1, 5, 1, 3, 2 }));
        System.out.println("Maximum sum of a subarray of size K: "
            + MaxSumSubArrayOfSizeK.findMaxSumSubArray(2, new int[] { 2, 3, 4, 1, 5 }));
      }


      private static int findMaxSumSubArray(int k , int [] arr) {
        int maxSum = 0;
        int windowSum=0;
        int startIndex =0;

        for (int end = 0;end<arr.length;end++){
            windowSum+=arr[end];

            if (end >= k-1){
                maxSum = Math.max(windowSum, maxSum);
                windowSum-=arr[startIndex];
                startIndex++;
            }

        }

        return maxSum;

      }
}
