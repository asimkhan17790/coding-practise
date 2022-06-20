package com.algos.dynamicProgramming.educativeIO.pattern1Knapsack;

public class CountOfSubsetSumRecursive {

    public static void main(String[] args) {
        CountOfSubsetSumRecursive ss = new CountOfSubsetSumRecursive();
        int[] num = {1, 1, 2, 3};
        System.out.println(ss.countSubsets(num, 4));
        num = new int[]{1, 2, 7, 1, 5};
        System.out.println(ss.countSubsets(num, 9));
    }

    private int countSubsets (int [] num, int SUM) {
        return countSubsetsRecursive(num,SUM,0);
    }
    private int countSubsetsRecursive(int [] num, int sum, int currentIndex) {
        if (sum==0) {
            return 1;
        }
        if (currentIndex>=num.length || num.length==0){
            return 0;
        }
        //include
        int include =0;
        int exclude =0;
        if (num[currentIndex]<=sum){
            include = countSubsetsRecursive(num,sum-num[currentIndex],currentIndex+1);
        }
        //exclude
         exclude = countSubsetsRecursive(num,sum,currentIndex+1);

        return include+exclude;
    }
}
