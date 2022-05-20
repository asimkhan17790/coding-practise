package com.algos.dynamicProgramming.educativeIO.pattern2UnboundedKnapsack;

public class MinimumCoinChange {

    public static void main(String[] args) {
        MinimumCoinChange cc = new MinimumCoinChange();
        int[] denominations = {1, 2, 3};
        System.out.println(cc.countChange(denominations, 5));
        System.out.println(cc.countChange(denominations, 11));
        System.out.println(cc.countChange(denominations, 7));
        denominations = new int[]{3, 5};
        System.out.println(cc.countChange(denominations, 7));

        
    }


    //Pavlo Algorithm
    public int countChange (int [] denom, int TARGET) {

        int k = denom.length;
        int [] C = new int[TARGET+1];
        C[0]=0;

        for (int p=1;p<=TARGET;p++){
            int min = Integer.MAX_VALUE;
            for (int i = 0; i<k; i++){                
                if (denom[i]<=p){
                    int curMin = 1 + C[p-denom[i]];
                    if (curMin < min){
                        min = curMin;
                    }
                }
            }
            C[p] = min;
        }
        return C[TARGET];
    }
    
}
