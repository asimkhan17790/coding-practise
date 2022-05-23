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


        
        System.out.println("Coin Change: Educative.io Algo");
        denominations =  new int[]{1, 2, 3};
        System.out.println(cc.countChange2DArray(denominations, 5));
        System.out.println(cc.countChange2DArray(denominations, 11));
        System.out.println(cc.countChange2DArray(denominations, 7));
        denominations = new int[]{3, 5};
        System.out.println(cc.countChange2DArray(denominations, 7));

        
    }

    // Educative.io Algorithm
    private int countChange2DArray (int [] denom, int TARGET) {
        int dp [][] = new int [denom.length][TARGET+1];

        for(int i=0; i < denom.length; i++){
            for(int j=0; j <= TARGET; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }                
        } 

        for (int i = 0; i < denom.length; i++) {           
                dp[i][0] = 0;            
        }

        for (int i = 0; i < denom.length; i++){
            for (int sum = 1; sum <= TARGET; sum++){  

                //exclude
                if (i > 0) {
                    dp[i][sum] = dp[i-1][sum];
                }                    
                //include
                if (denom[i]<=sum){                    
                    if (dp[i][sum-denom[i]] != Integer.MAX_VALUE){
                        dp[i][sum] = Math.min(dp[i][sum], 1 + dp[i][sum-denom[i]]);
                    }
                    
                }                 
            }
        }

        return (dp[denom.length-1][TARGET] == Integer.MAX_VALUE ? -1 : dp[denom.length-1][TARGET]);
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
