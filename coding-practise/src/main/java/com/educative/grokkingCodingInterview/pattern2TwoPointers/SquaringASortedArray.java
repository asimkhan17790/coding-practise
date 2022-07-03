package com.educative.grokkingCodingInterview.pattern2TwoPointers;

import java.util.Arrays;

public class SquaringASortedArray {

    public static void main(String[] args) {

        Arrays.stream(makeSquares(new int[]{-2, -1, 0, 2, 3})).forEach(e-> System.out.print(e+ ", "));
    }
    public static int[] makeSquares(int[] arr) {
        int result [] = new int[arr.length];


        /*for (int i = 0;i<arr.length;i++) {
            if (arr[i]>-1){
                index=i;
                break;
            }
        }*/
        int left=0;
        int right=arr.length-1;


        int index=arr.length-1;
        while(left<=right){

            int leftSquare = arr[left]*arr[left];
            int rightSquare = arr[right]*arr[right];

            if (leftSquare>rightSquare) {
                result[index--]=leftSquare;
                left++;
            }else {
                result[index--]=rightSquare;
                right--;
            }

        }
        return result;
    }
}
