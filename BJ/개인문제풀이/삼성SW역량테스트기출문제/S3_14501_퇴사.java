package BJ.개인문제풀이.삼성SW역량테스트기출문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S3_14501_퇴사 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] T = new int[N+1];
        int[] P = new int[N+1];
        int[] DP = new int[N+2];

        for(int i=1; i<=N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=N; i>0; i++){
            int next = i+T[i];

            if(next > N+1){
                // 일 못 하므로 다음 DP값(더 앞쪽의 날짜)로 설정
                DP[i] = DP[i+1];
            } else{
                // 1. 일하지 않았을 때 (DP[i+1])
                // 2. 일 했을 때 총 벌 수 있는 금액(P[i]+DP[next])
                // 위 두 경우 중 더 큰 값을 DP에 넣어주기
                DP[i] = Math.max(DP[i+1], P[i]+DP[next]);
            }
        }
        System.out.println(DP[1]);
    }
}
