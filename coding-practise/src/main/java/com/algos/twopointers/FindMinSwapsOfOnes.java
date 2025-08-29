package com.algos.twopointers;

public class FindMinSwapsOfOnes {
    public static void main(String[] args) {

        int [] ar = {1,0,1,0,1,0,0,1,1,0,1};
        System.out.println(findMinOnes(ar));


        int [] ar2 = {1,1,1,1,1,0,0,1,1,0,1};
        System.out.println(findMinOnes(ar2));
    }

    static int findMinOnes(int nums[]) {
        // Find the no.of 1s

        int k = 0;

        for (int num : nums) {
            if (num == 1)
                k++;
        }

        // Find all windows with size = onesCount and get size of the one with max 1s

        int l=0;
        int r=k-1;

        int count=0;
        int windowOnes=0;
        int maxOnes=0;

        for (int i=0;i<k;i++) {
            if (nums[i]==1)windowOnes++;
        }

        maxOnes=windowOnes;
        r=k;
        while (r < nums.length) {
            if (nums[r]==1)windowOnes++;
            if (nums[r-k]==1)windowOnes--;
            maxOnes=Math.max(windowOnes,maxOnes);
            r++;
        }
        return k-maxOnes;
    }
}
