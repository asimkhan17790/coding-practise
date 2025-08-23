package com.algos.twopointers;

import org.junit.jupiter.api.Assertions;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TeleporterArrays {

    public static void main(String[] args) {
        Assertions.assertEquals(30,maximumScore(List.of(2,4,5,8,10), List.of(4,6,8,9)));
        //Assertions.assertEquals(94878,maximumScore());
        //Assertions.assertEquals(94878,maximumScore());
        //Assertions.assertEquals(94878,maximumScore());
    }

    public static int maximumScore(List<Integer> arr1, List<Integer> arr2) {
        long result= 0L;
        int MODULO=1000000007;
        Integer[] ar1 =  arr1.toArray(new Integer[0]);
        Integer[] ar2 =  arr2.toArray(new Integer[0]);

        int i = 0,j = 0;
        int sum1=0;
        int sum2=0;

        while (i<ar1.length && j<ar2.length) {
            if (ar1[i]<ar2[j]) {
                sum1+=ar1[i++];
            }else if (ar2[j]<ar1[i]) {
                sum2+=ar2[j++];
            }else {
                result += Math.max(sum1,sum2) + ar1[i];
                result = result % MODULO;
                sum1=0;
                sum2=0;
                i++;
                j++;
            }
        }
        while (i<ar1.length){
            sum1+=ar1[i++];
        }

        while (j<ar2.length){
            sum2+=ar2[j++];
        }

        result += Math.max(sum1,sum2);
        return (int)result%MODULO;
    }
}
