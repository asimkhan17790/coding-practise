package com.educative.grokkingCodingInterview.pattern2TwoPointers;

import java.util.*;

public class TripletSumToZero {
    public static void main(String[] args) {


        TripletSumToZero t = new TripletSumToZero();

        Integer ar [] = new Integer[]{-3, 0, 1, 2, -1, 1, -2};

        // Two pointers
        System.out.println(t.searchTriplets(ar));

        ar = new Integer[]{-5, 2, -1, -2, 3};
        System.out.println(t.searchTriplets(ar));



        // BackTracking Approach
        System.out.println("BackTracking");
        ar = new Integer[]{-3, 0, 1, 2, -1, 1, -2};
        System.out.println(t.searchTripletsBackTrack(ar));

        ar = new Integer[]{-5, 2, -1, -2, 3};
        System.out.println(t.searchTripletsBackTrack(ar));

    }

    public  List<List<Integer>> searchTriplets(Integer[] arr) {
        List<List<Integer>> triplets = new ArrayList<>();
        Arrays.sort(arr);
        for (int i =0;i<arr.length-2;i++) {
                if (i>0 && arr[i]==arr[i-1]) {
                    continue;
                }
            searchPair(arr, i+1, -arr[i],triplets);
        }
        return triplets;
    }

    private void searchPair(Integer arr[], int left, int targetSum, List<List<Integer>> triplets){
        int right = arr.length-1;

        while (left<right) {
            int currentSum= arr[left]+arr[right];
            if (currentSum==targetSum){
                triplets.add(Arrays.asList(-targetSum,arr[left],arr[right]));
                left++;
                right--;
                while(left<right && arr[left]==arr[left-1]){
                    left++;
                }
                while (left<right && arr[right]==arr[right+1]){
                    right--;
                }
            } else if (targetSum<currentSum){
                right--;
            }else {
                left++;
            }

        }
    }


    // BackTracking
    //TODO: Not able to get Unique lists
    public  List<List<Integer>> searchTripletsBackTrack(Integer[] arr) {
        List<List<Integer>> triplets = new ArrayList<>();
        List<Integer> l = Arrays.asList(arr);
        Set<Integer> set = new HashSet<>(l);
        List<Integer> list = new ArrayList<>(set);

        searchTripletsHelper(list, new ArrayList<>(),triplets);

        return triplets;
    }

    private void searchTripletsHelper(List<Integer> list, List<Integer> tripletList,List<List<Integer>> triplets){

        // base condition
        if (tripletList.size()==3){
            if (tripletList.get(0)+tripletList.get(1)+tripletList.get(2)==0){
                triplets.add(new ArrayList<>(tripletList));
                return;
            }
        }
        if (tripletList.size()>3){
            return;
        }

        // iterate through options

        for (int i=0;i<list.size();i++) {
            Integer num = list.get(i);
            tripletList.add(num);
            list.remove(i);
            searchTripletsHelper(list, tripletList,triplets);
            list.add(i,num);
            tripletList.remove(num);
        }
        // choose
        //unchoose

    }
}
