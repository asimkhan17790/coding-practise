package com.algos.binarySearch;

import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;

public class Newspapers {

    public static void main(String[] args) {

        System.out.println(newspapersSplit(List.of(15,15,15,15),4));
        List<Integer> l = List.of(2873 ,2837 ,10 ,3 ,12 ,34 ,21 ,450, 12 ,
                4, 39, 1, 40, 59, 2, 67, 93, 49, 837, 499, 237,
                287, 459, 12309, 9249, 94878, 30);


        System.out.println(newspapersSplit(l,4)); // Answer should be 9478
        Assertions.assertEquals(94878,newspapersSplit(l,4));
        System.out.println("DONE!!");
    }

    public static int newspapersSplit(List<Integer> newspapersReadTimes, int numCoworkers) {
        // WRITE YOUR BRILLIANT CODE HERE
        int left=Integer.MIN_VALUE;
        int right=0;
        for (int times: newspapersReadTimes) {
            left= Math.max(left, times);
            right+=times;
        }
        int ans=-1;
        while (left<=right) {

            int mid = left + (right-left)/2;

            if (feasible (mid, newspapersReadTimes, numCoworkers)) {
                ans=mid;
                right=mid-1;
            }
            else {
                left=mid+1;
            }

        }
        return ans;
    }
    static boolean feasible(int mid, List<Integer> newspapersReadTimes, int numCoworkers) {
        int numWorkers=0;
        int time=0;

        for (int readTime: newspapersReadTimes) {
            if (time+readTime>mid) {
                time=0;
                numWorkers++;
            }
            time=time+readTime;
        }

        if (time!=0){
            numWorkers++;
        }
        return numWorkers<=numCoworkers;
    }
}
