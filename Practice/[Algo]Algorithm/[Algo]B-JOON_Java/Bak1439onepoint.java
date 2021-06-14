package com.koreait.spring.user;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s = br.readLine().split("");
        int[] arr = new int[s.length];

        for (int i = 0; i < s.length; i++)
        {
            arr[i] = Integer.parseInt(s[i]);
        }
        List<Integer> list = new ArrayList<>();
        list.add(arr[0] );
        int last = 0;
        for (int i = 1; i < arr.length; i++)
        {
            if(list.get(last) != arr[i])
            {
                list.add(arr[i]);
                last++;
            }
        }
    }
}
