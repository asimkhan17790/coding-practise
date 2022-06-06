package com.algos.dynamicProgramming.educativeIO.pattern5LongestCommonSubstring;

public class LongestAlternatingSubsequence {
    public static void main(String[] args) {
        LongestAlternatingSubsequence las = new LongestAlternatingSubsequence();
        System.out.println("--- Brute Force Recursion ---");
        int[] nums = {1,2,3,4};
        System.out.println(las.findLASLength(nums));
        nums = new int[]{3,2,1,4};
        System.out.println(las.findLASLength(nums));
        nums = new int[]{1,3,2,4};
        System.out.println(las.findLASLength(nums));

        // Memoize
        
        System.out.println("--- Memoization ---");
        nums = new int[]{1,2,3,4};
        System.out.println(las.findLASLengthMemoize(nums));
        nums = new int[]{3,2,1,4};
        System.out.println(las.findLASLengthMemoize(nums));
        nums = new int[]{1,3,2,4};
        System.out.println(las.findLASLengthMemoize(nums));

        // Bottom UP
        System.out.println("--- Bottom Up DP ---");
        nums = new int[]{1,2,3,4};
        System.out.println(las.findLASLengthBottomUp(nums));
        nums = new int[]{3,2,1,4};
        System.out.println(las.findLASLengthBottomUp(nums));
        nums = new int[]{1,3,2,4};
        System.out.println(las.findLASLengthBottomUp(nums));

    }

    private int findLASLength(int nums[]){
        
        return Math.max(this.findLASLengthRecursive(nums, -1 , 0, true),
                        this.findLASLengthRecursive(nums, -1 , 0, false));
    }
    private int findLASLengthRecursive(int nums[], int prevIndex, int curIndex, boolean isAsc){
        
        if (curIndex == nums.length){
            return 0;
        }
        
        int c1 =0;
        if (isAsc){
            if (prevIndex == -1 || nums[curIndex]>nums[prevIndex]){
                c1 = 1 + this.findLASLengthRecursive(nums, curIndex, curIndex + 1, !isAsc);
            }
        }else if (prevIndex == -1 || nums[curIndex]<nums[prevIndex]){
            c1 = 1 + this.findLASLengthRecursive(nums, curIndex, curIndex + 1, !isAsc);
        }
        int c2 = this.findLASLengthRecursive(nums, prevIndex, curIndex + 1, isAsc);

        return Math.max(c1, c2);
    }

    // Memoization
    private int findLASLengthMemoize(int nums[]){
        Integer dp[][][] = new Integer[nums.length][nums.length][2];
        return Math.max(this.findLASLengthRecursiveMemoize(dp, nums, -1 , 0, true),
                        this.findLASLengthRecursiveMemoize(dp, nums, -1 , 0, false));
    }
    private int findLASLengthRecursiveMemoize(Integer [][][] dp, int nums[], int prevIndex, int curIndex, boolean isAsc){
        
        if (curIndex == nums.length){
            return 0;
        }
        
        if (dp[prevIndex+1][curIndex][isAsc ? 1 : 0]==null){
            int c1 =0;
            if (isAsc){
                if (prevIndex == -1 || nums[curIndex]>nums[prevIndex]){
                    c1 = 1 + this.findLASLengthRecursive(nums, curIndex, curIndex + 1, !isAsc);
                }
            }else if (prevIndex == -1 || nums[curIndex]<nums[prevIndex]){
                c1 = 1 + this.findLASLengthRecursive(nums, curIndex, curIndex + 1, !isAsc);
            }
            int c2 = this.findLASLengthRecursive(nums, prevIndex, curIndex + 1, isAsc);
    
            dp[prevIndex+1][curIndex][isAsc ? 1 : 0] = Math.max(c1, c2);
        }
       return dp[prevIndex+1][curIndex][isAsc ? 1 : 0];
    }

    private int findLASLengthBottomUp (int [] nums) {

        int maxLength=1;
        if (nums.length == 0){
            return 0;
        }
        int dp[][] = new int[nums.length][2];

        for (int i =0; i < nums.length; i++) {
            dp[i][0]=dp[i][1]=1;
            for (int j = 0; j < i; j++){
                if (nums[i] > nums[j]){
                    dp[i][0]= Math.max(dp[i][0], 1+dp[j][1]);
                    maxLength = Math.max(dp[i][0], maxLength);
                } else if (nums[i]!=nums[j]){
                    dp[i][1]= Math.max(dp[i][1], 1+dp[j][0]);
                    maxLength = Math.max(dp[i][1], maxLength);
                }
            }
        }
        return maxLength;
    }
}
