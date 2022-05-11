package com.algos.dynamicProgramming.knapsack;

import java.util.Arrays;

public class EqualSubsetSumPartition {
    public static void main(String[] args) {
        
        int[] num = {1, 2, 3, 4};
        System.out.println(canPartition(num));
        num = new int[]{1, 1, 3, 4, 7};
        System.out.println(canPartition(num));
        num = new int[]{2, 3, 4, 6};
        System.out.println(canPartition(num));


        System.out.println("MEMOIZATION");
        num = new int[]{1, 2, 3, 4};
        System.out.println(canPartitionMemoization(num));
        num = new int[]{1, 1, 3, 4, 7};
        System.out.println(canPartitionMemoization(num));
        num = new int[]{2, 3, 4, 6};
        System.out.println(canPartitionMemoization(num));


      }
    
      //RECURSION
      private static boolean canPartition(int [] num){
        int sum = Arrays.stream(num).sum();
        if(sum%2!=0) return false;

        return canPartitionRecursive(num, sum/2, 0);
      }
      //RECURSION
      static boolean canPartitionRecursive(int [] num, int sum, int curIndex){
          if (sum==0) return true;

          if(num.length ==0 || curIndex>=num.length) return false;

          //choose
          if(num[curIndex]<=sum){
              if(canPartitionRecursive(num, sum-num[curIndex], curIndex+1)) {
                return true;
              }
          }
          //if no selected
          return canPartitionRecursive(num, sum, curIndex+1);
      }

      // MEMOIZATION
      private static Boolean canPartitionMemoization(int [] num){
        int sum = Arrays.stream(num).sum();
        if(sum%2!=0) return false;
        Boolean dp[][] = new Boolean[num.length][sum/2+1];
        return canPartitionRecursiveMemoization(dp, num, sum/2, 0);
      }

      //MEMOIZATION
      private static Boolean canPartitionRecursiveMemoization(Boolean dp[][], int [] num, int sum, int curIndex) {
        if (sum==0) return true;

        if(num.length ==0 || curIndex>=num.length) return false;

        if (dp[curIndex][sum] == null) {
            // when current index is included
            if (num[curIndex]<=sum){
                if (canPartitionRecursiveMemoization(dp, num, sum-num[curIndex], curIndex+1)){
                    dp[curIndex][sum] = true;
                    return true;
                }
            }
            // when currentindex is exluded
            return canPartitionRecursiveMemoization(dp, num, sum, curIndex+1);
        }
        return dp[curIndex][sum];
      }
}
