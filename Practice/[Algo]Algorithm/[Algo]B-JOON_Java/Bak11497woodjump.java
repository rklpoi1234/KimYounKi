package com.koreait.spring.user;

import java.util.ArrayList;
import java.util.List;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCaseN = sc.nextInt();

        for(int i=0;i<testCaseN;i++) {
            int[] ans_tmp = new int[sc.nextInt()+1];

            for(int j=1;j<ans_tmp.length;j++) {
                ans_tmp[j]=sc.nextInt();
                System.out.println(ans_tmp[j]);
                //Arrays.sort(ans_tmp);
            }

            int[] ans_arr=new int[ans_tmp.length];

            for(int j=1;j<ans_arr.length;j++) {
                if(j%2!=0) {
                    ans_arr[j] = ans_tmp[j];
                    System.out.println("j%2 !="+ans_tmp[j]);
                }else {
                    ans_arr[ans_arr.length-j-1] = ans_arr[j];
                    System.out.println("j%2 =="+ans_tmp[j]);
                }
            }
            for(int k=1;k<ans_arr.length;k++) {
                System.out.println(ans_arr[k]);
            }
        }
    }
}

