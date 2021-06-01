package com.koreait.spring.user;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import java.util.Scanner;
public class Main {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t= sc.nextInt(); //Testcase
        int Q=25; //Quarter
        int D=10; //Dime
        int N=5; //Nickel
        int P=1; //Penny

        for (int i = 0; i < t; i++)
        {
            int money = sc.nextInt();
            int temp1 = money/Q;
            int temp2 = (money%Q)/D;
            int temp3 = ((money%Q)%D)/N;
            int temp4 = (((money%Q)%D)%N)/P;

            System.out.println(temp1+" "+temp2+" "+temp3+" "+temp4);
        }
    }
}