package com.algos.dynamicProgramming.educativeIO.pattern5LongestCommonSubstring;

public class LongestBitonicSubsequence {
      
    public static void main(String[] args) {
        System.out.println("Longest Bitonic Subsequence"); 

        System.out.println("-- Brute Force --");
        LongestBitonicSubsequence lbs = new LongestBitonicSubsequence();
        int[] nums = {4,2,3,6,10,1,12};
        System.out.println(lbs.findLBSLength(nums));
        nums = new int[]{4,2,5,9,7,6,10,3,1};
        System.out.println(lbs.findLBSLength(nums));
        
        
        System.out.println("-- Memoization --");


        System.out.println(" -- Bottom Up DP --");
        LongestBitonicSubsequence lbs2 = new LongestBitonicSubsequence();
        nums = new int[]{4,2,3,6,10,1,12};
        System.out.println(lbs2.findLBSLength(nums));
        nums = new int[]{4,2,5,9,7,6,10,3,1};
        System.out.println(lbs2.findLBSLength(nums));


    }
    private int findLBSLength(int [] nums){
        int maxLength = 0;
        for (int i = 0; i < nums.length; i++){
            int c1= findLDSLength(nums, i, -1);
            int c2=findLDSLengthRev(nums, i, -1);
            maxLength = Math.max(maxLength, c1+c2-1);
        }
        return maxLength;
    }
    private int findLDSLength(int [] nums, int curIndex, int prevIndex){
       if (curIndex == nums.length)
        return 0;

        int c1 =0;
        if (prevIndex==-1 || nums[curIndex]<nums[prevIndex]){
            c1= 1 + findLDSLength(nums, curIndex+1, curIndex);
        }
        int c2 = findLDSLength(nums, curIndex+1, prevIndex);

        return Math.max(c1,c2);
    }
   
    private int findLDSLengthRev(int [] nums, int curIndex, int prevIndex){
        if (curIndex < 0)
        return 0;

        int c1 =0;
        if (prevIndex==-1 || nums[curIndex]<nums[prevIndex]){
            c1= 1  + findLDSLengthRev(nums, curIndex-1, curIndex);
        }
        int c2 = findLDSLengthRev(nums, curIndex-1, prevIndex);

        return Math.max(c1,c2);
    }


    // DP Bottom UP
    private int findLBSLengthDPBottomUP(int [] nums){
        int maxLength = 0;

        int lds [] = new int[nums.length];
        int ldsRev[] = new int[nums.length];

        for (int i = 0; i < nums.length; i++){
            lds[i]=1;
            for (int j = i-1;j>=0;j--){
                if (nums[j]<nums[i]){
                    lds[i] = Math.max(lds[i],lds[j]+1);
                }
            }
        }
        for (int i = 0; i < nums.length; i++){
            lds[i]=1;
            for (int j = i+1;j < nums.length;j++){
                if (nums[j]<nums[i]){
                    ldsRev[i] = Math.max(ldsRev[i],ldsRev[j]+1);
                }
            }
        }

        for (int i= 0; i < nums.length; i++){
            maxLength = Math.max(maxLength, lds[i]+ldsRev[i]-1);
        }
        
        return maxLength;
    }
    
}
