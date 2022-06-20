package com.algos.dynamicProgramming.educativeIO.pattern2UnboundedKnapsack;

public class CoinChangeRecursive {

    public static void main(String[] args) {
        CoinChangeRecursive cc = new CoinChangeRecursive();
        int[] denominations = {1, 2, 3};
        System.out.println(cc.countChange(denominations, 5));
    }
    private int countChange (int denom[], int total) {
        return this.countChangeRecursive(denom,total, 0);
    }
    private int countChangeRecursive(int denom[],int total, int curIndex){
        // basic checks
        if (total==0) return 1;

        if (denom.length == 0 || curIndex>=denom.length){
            return 0;
        }
        int sum1 = 0;
        //include
        if (denom[curIndex]<=total){
            sum1 = countChangeRecursive(denom,total-denom[curIndex],curIndex);
        }
        int sum2=countChangeRecursive(denom,total,curIndex+1);

        return sum1+sum2;
    }
}
