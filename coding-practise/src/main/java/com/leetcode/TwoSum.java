package com.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//Leetcode #1
/*
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

 

Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Output: Because nums[0] + nums[1] == 9, we return [0, 1].
Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]
Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]
 

Constraints:

2 <= nums.length <= 104
-109 <= nums[i] <= 109
-109 <= target <= 109
Only one valid answer exists.
*/ 
public class TwoSum {
    public static void main(String[] args) {
        int i[] = {2,7,11,15};
        int target = 9;
        int[] result = twoSum(i, target);
        if (result != null) {
            System.out.println("Indices: [" + result[0] + ", " + result[1] + "]");
        } else {
            System.out.println("No two sum solution found.");
        }
    }

    public static int[] twoSum(int[] nums, int target) {
    Arrays.stream(nums).forEach(System.out::println);
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0;i < nums.length; i++){
            int complement = target - nums[i];
            if (map.containsKey(complement)){
                return new int[]{map.get(complement),i};
            }
            map.put(nums[i],i);
        }
        return null;
    }

    public int[] twoSum2PassHashTable(int[] nums, int target) {
        
        // 2 pass hash table
        // check for one pass hashtable logic in git
        Map<Integer,Integer> m = new HashMap<>();
        int result [] = new int[2];
        for (int i = 0; i < nums.length; i++) {
            m.put(nums[i],i);
        }
        
        for (int i = 0; i < nums.length; i++){
            if (m.containsKey(target - nums[i]) && m.get(target - nums[i])!=i){
                result[0] = i;
                result[1] = m.get(target - nums[i]);
                break;
            }
        }
        
        return result;
    }

}