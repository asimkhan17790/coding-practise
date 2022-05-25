package com.algos.dynamicProgramming.educativeIO.pattern3FibonacciNumbers;

public class MinJumpsWithFee {
                 
          public static void main(String[] args) {
            MinJumpsWithFee sc = new MinJumpsWithFee();
            int[] fee = {1,2,5,2,1,2};
            System.out.println(sc.findMinFee(fee));
            fee = new int[]{2,3,4,5};
            System.out.println(sc.findMinFee(fee));


            System.out.println("--- Memoization ---");
             fee = new int[] {1,2,5,2,1,2};
            System.out.println(sc.findMinFeeMemoize(fee));
            fee = new int[]{2,3,4,5};
            System.out.println(sc.findMinFeeMemoize(fee));
          }

          public int findMinFee(int[] fee) {
            
            return this.findMinFeeRecursive(fee, 0);            
          }   
          public int findMinFeeRecursive(int [] fee, int curIndex){

            // base condition

            if (curIndex >= fee.length ){
                return 0;
            }

            int take1Step = findMinFeeRecursive(fee, curIndex+1);
            int take2Step = findMinFeeRecursive(fee, curIndex+2);
            int take3Step = findMinFeeRecursive(fee, curIndex+3);

            int min = Math.min(take1Step,Math.min(take2Step, take3Step));

            return min + fee[curIndex];

          }

          // Memoization

          public int findMinFeeMemoize (int fee[]) {
            Integer dp [] = new Integer [fee.length];
            return this.findMinFeeRecursiveMemoize(fee, 0, dp);   
          }
          int findMinFeeRecursiveMemoize (int [] fee, int curIndex, Integer dp[]){
                
                // base condition
                if (curIndex >= fee.length ){
                    return 0;
                }

                if (dp[curIndex] !=null){
                    return dp[curIndex];
                }

                int take1Step = findMinFeeRecursive(fee, curIndex+1);
                int take2Step = findMinFeeRecursive(fee, curIndex+2);
                int take3Step = findMinFeeRecursive(fee, curIndex+3);

                int min = Math.min(take1Step,Math.min(take2Step, take3Step));

                dp[curIndex] = min+fee[curIndex];
                return dp[curIndex];

          }
}
