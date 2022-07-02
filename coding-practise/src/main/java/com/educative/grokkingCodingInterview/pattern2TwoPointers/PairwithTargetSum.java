package com.educative.grokkingCodingInterview.pattern2TwoPointers;

import java.util.Arrays;

public class PairwithTargetSum {
    public static void main(String[] args) {
        Arrays.stream(search(new int[]{2, 5, 9, 11}, 11)).forEach(e-> System.out.print(e + " "));
        System.out.println();
        Arrays.stream(search(new int[]{1, 2, 3, 4, 6}, 6)).forEach(e-> System.out.print(e + " "));
    }

    public static int[] search(int[] arr, int targetSum) {
        // TODO: Write your code here
        int result [] = new int[] { -1, -1 };
        int start=0;
        int end = arr.length-1;
        while(start<end) {
            int sum = arr[start] + arr[end];
            if (sum>targetSum){
                end--;
            }else if (sum<targetSum){
                start++;
            }else {
                result[0]=start;
                result[1]=end;
                break;
            }
        }
        return result;
    }
}
