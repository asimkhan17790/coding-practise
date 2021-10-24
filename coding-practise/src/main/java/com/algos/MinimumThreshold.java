package com.algos;

import java.util.Arrays;

public class MinimumThreshold {
    
    public static void main(String[] args) {
        int ar[] = {40,20,10,30}; 
        int requiredSum =70;
        //let = 10  {10,20,30,40}
            //20,20,10,20 =70
        //int ar[] = {1,2,3};
        //int requiredSum=5;
        minThreasholdNew(ar, requiredSum);
        minThreashold(ar, requiredSum);


       
        
    }
    static void minThreasholdNew(int [] ar, int requiredSum){
        long t1 = System.currentTimeMillis();
        Arrays.sort(ar);
        int [] runningSum = new int[ar.length];
        int rs=0;
        for (int i = 0;i<ar.length;i++){
            rs+=ar[i];
            runningSum[i]=rs;
        }

        for (int i = ar[0];i <= ar[ar.length-1];i++){
            int index = Arrays.binarySearch(ar, i);
            int left=0;
            int right=0;
            if (index<0){
                continue;
            }
            if (index>0){
                 left = runningSum[index-1];
                 right = i * (ar.length - index );
            }else if (index==0){
                right = ar.length * i;
            }
            int tot = left+right;
            if (tot == requiredSum){
                System.out.println("Threshold:>" + i);
                break;
            }
        }
        long t2 = System.currentTimeMillis();
        System.out.println("Time new" + (t2-t1));
    }
    
    
    static void minThreashold(int [] ar, int requiredSum){
        long t1 = System.currentTimeMillis();
        
        int sum =0;

        for (int i = 0;i<ar.length;i++){
            sum+=ar[i];
        }
        

        for (int i = 1;i<= requiredSum;i++) {
            int CalculatedSum = potential(ar,0,i);
            if (CalculatedSum==requiredSum){
                System.out.println("Threshold->" + i);
                break;
            }
        }
        long t2 = System.currentTimeMillis();
        System.out.println("Time old" + (t2-t1));
    }




    static int potential(int ar[],int i,int potential){

        if (i==ar.length){
            return 0;
        }
        int localSum = 0;
        if (ar[i]>potential){
            localSum = potential + potential(ar,i+1,potential);
        } else {
            localSum = ar[i] + potential(ar,i+1,potential);
        }
        return localSum;

    }

    
}
