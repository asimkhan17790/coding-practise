package com.algos.recursion;

import java.util.ArrayList;
import java.util.List;

public class LeetCode377CombinationSum4 {
    //static List<List<Integer>> result = new ArrayList<>();
    public static void main(String[] args) {
        int [] nums = {1,2,3};
        System.out.println(combinationSum4(nums,4));
    }
    static int count=0;
    public static int combinationSum4(int[] nums, int target) {
        combinationSum4Recursive(nums,target);
        //return result.size();
        return count;
    }

    public static void combinationSum4Recursive(int[] nums, int target) {
        if (target == 0){
             count++;
            return;
        }

        if (target<0){
            return;
        }

        for (int i=0;i<nums.length;i++) {
            combinationSum4Recursive(nums, target-nums[i]);

        }
    }
}
