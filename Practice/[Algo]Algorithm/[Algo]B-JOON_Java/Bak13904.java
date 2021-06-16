package com.koreait.spring2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt();
        int[][] work = new int[N][2];
        int maxScores = 0;
        int d = 0;
        for(int i=0; i<N; i++) {
            work[i][0] = scan.nextInt();	// end
            work[i][1] = scan.nextInt();	// score
        }

        // 점수 높은순으로 정렬
        Arrays.sort(work, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o2[1], o1[1]);
            }
        });

        int[] scores = new int[1001];
        for(int i=0; i<N; i++) {
            for(int j=work[i][0]; j>0; j--) {
                if(scores[j] == 0) {
                    scores[j] = work[i][1];
                    break;
                }
            }
        }

        //나온값을 더해줌줌
       for(int i=0; i<scores.length; i++)
            maxScores += scores[i];


        System.out.println(maxScores);
        scan.close();
    }

}

