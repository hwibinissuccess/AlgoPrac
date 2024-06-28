package BJ.개인문제풀이.Softeer.해결;

import java.io.*;
import java.util.*;


public class 연습문제 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 학생 수
        int K = Integer.parseInt(st.nextToken()); // 구간 수
        st = new StringTokenizer(br.readLine());
        int[] score = new int[N];
        for(int i=0; i<N; i++){
            score[i] = Integer.parseInt(st.nextToken());
        } // 성적 배열

        for(int i=0; i<K; i++){

            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken())-1;
            int end = Integer.parseInt(st.nextToken())-1;
            int len = end-start+1;
            int sum = 0;

            for(int j=start; j<=end; j++){
                sum += score[j];
            }

            double avg = (double)sum/(double)len;

            System.out.println(String.format("%.2f", avg));
        }
    }
}
