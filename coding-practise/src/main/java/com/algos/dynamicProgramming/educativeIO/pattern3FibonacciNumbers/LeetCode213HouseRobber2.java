package com.algos.dynamicProgramming.educativeIO.pattern3FibonacciNumbers;

public class LeetCode213HouseRobber2 {
    public static void main(String[] args) {
        LeetCode213HouseRobber2 a = new LeetCode213HouseRobber2();
        System.out.println(a.rob(new int[]{1,2,3,1}));

        System.out.println(a.rob(new int[]{0}));;
    }


    public int rob(int[] nums) {

        if (nums.length==0) {
            return 0;
        }
        if (nums.length==1){
            return nums[0];
        }

        return Math.max(robHelper(createNewArray(nums,0,nums.length-2)), robHelper(createNewArray(nums,1,nums.length-1)));

    }
    int[] createNewArray(int nums[], int start,int end){
        int len = end-start+1;
        int ar[] = new int[len];
        int i = 0;
        while(start<=end){
            ar[i++]=nums[start++];
        }
        return ar;
    }


    int robHelper(int nums[]) {

        int dp [] = new int[nums.length+1];

        dp[0]=0;
        dp[1]=nums[0];

        for (int i =2;i<=nums.length;i++) {
            dp[i]= Math.max(dp[i-1],dp[i-2]+nums[i-1]);
        }


        return dp[nums.length];
    }
}
