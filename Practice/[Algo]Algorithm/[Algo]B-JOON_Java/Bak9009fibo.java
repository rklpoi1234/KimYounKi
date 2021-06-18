package com.koreait.junittest;

import java.io.*;
import java.util.StringTokenizer;
import java.util.*;
import java.math.*;
import java.text.*;

public class Main
{
    static
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int stoi(String s) { return Integer.parseInt(s); }
    static void print(StringBuilder sbb) { System.out.println(sbb.toString()); }

    static void solve() throws IOException
    {
        StringTokenizer st = null;
        int MAX = 44;
        int[] fi = new int[MAX+12];
        fi[0] = 0; //피보나치 0번과 1번은 문제에도 나와있음
        fi[1] = 1;

        for (int i = 2; i <= MAX ; i++)
        {
            fi[i] = fi[i-1] + fi[i-2]; //피보나치 f는 = k = k-1 + k-2로 정의됨
        }
        
        int T = stoi(br.readLine());

        while(T-- > 0) {
            int N = stoi(br.readLine());

            Stack<Integer> stk = new Stack<Integer>();
            for(int i = MAX; i >= 0; i--) {
                if(fi[i] <= N) {
                    N -= fi[i];
                    stk.push(fi[i]);
                }

                if(N == 0) {
                    break;
                }
            }

            while(stk.isEmpty() == false) {
                sb.append(stk.pop() + " ");
            }
            sb.append("\n");

        }
        print(sb);

        br.close();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        solve();
    }

}
