package com.educative.grokkingCodingInterview.pattern2TwoPointers;

public class RemoveDuplicates {
    public static void main(String[] args) {
        System.out.println(remove(new int[]{2, 3, 3, 3, 6, 9, 9}));
        System.out.println(remove(new int[]{2, 2, 2, 1, 1}));
        System.out.println(remove(new int[]{2,1}));
        System.out.println(remove(new int[]{2, 2}));
    }
    public static int remove(int[] arr) {
        if (arr.length==0) return 0;
        if (arr.length==1)return arr[0];
        int start=0;
        int end =start;
        for (int i = start+1 ;i < arr.length; i++){
            if (arr[i]!=arr[end]){
                end++;
                arr[end]=arr[i];
            }
        }
        return end-start+1;
    }
}
