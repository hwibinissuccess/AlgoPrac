package BJ.개인문제풀이.삼성SW역량테스트기출문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2_13458_시험감독 {
    static int N, B, C;
    static long cnt;
    static int[] student;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        student = new int[N];
        for (int i = 0; i < N; i++) {
            student[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken()); // 입력완료

        cnt = 0;

        cnt += N;

        for (int i = 0; i < N; i++) {
            student[i] -= B;
            if(student[i] <=0) continue;
            cnt += student[i]/C;
            if(student[i]%C != 0){
                cnt++;
            }

        }
        System.out.println(cnt);
    }
}
