package com.algos.dynamicProgramming.educativeIO.knapsack;

public class DiscreteKnapSack {
    public static void main(String[] args) {
        int val[] = new int[] { 60, 100, 120, 150 };
        int wt[] = new int[] { 10, 20, 30, 50 };
        int W = 50;
        int n = val.length;
        System.out.println(knapSack(W, wt, val, n));
    }

    static int knapSack(int W, int wt[],int val[], int n) {
        int i, w;
        int C[][] = new int [n+1][W+1];

        for (i = 0;i<=n;i++){
            for (w=0;w<=W;w++){
                if (i==0 || w==0){
                    C[i][w] = 0;
                } else if (wt[i-1]<=w) {
                    C[i][w] = Math.max(val[i-1]+ C[i-1][w - wt[i-1]],C[i-1][w]);
                }else {
                    C[i][w] = C[i-1][w];
                }
            }
        }
        return C[n][W];
    }

}
