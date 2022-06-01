package com.algos.dynamicProgramming.educativeIO.pattern5LongestCommonSubstring;

public class MinimumDeletionstoMakeASequenceSorted {

    public static void main(String[] args) {
        MinimumDeletionstoMakeASequenceSorted mdss = new MinimumDeletionstoMakeASequenceSorted();
        int[] nums = {4,2,3,6,10,1,12};
        System.out.println(mdss.findMinimumDeletions(nums));
        nums = new int[]{-4,10,3,7,15};
        System.out.println(mdss.findMinimumDeletions(nums));
        nums = new int[]{3,2,1,0};
        System.out.println(mdss.findMinimumDeletions(nums));
      }

      private int findMinimumDeletions(int [] nums) {
          
        int dp[] = new int[nums.length];
        for (int i=0;i<nums.length;i++){
            dp[i]=1;
        }
        int max = 1;
        for (int i = 1; i < nums.length; i++){
            for (int j=0;j<i;j++){
                if (nums[i]>nums[j]){
                    dp[i] = Math.max(dp[j]+1, dp[i]);
                    max = Math.max(dp[i], max);
                }
            }
        }
        return nums.length-max;
      }
    
}
