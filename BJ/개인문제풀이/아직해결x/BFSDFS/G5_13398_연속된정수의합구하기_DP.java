package BJ.개인문제풀이.아직해결x.BFSDFS;

import java.io.*;
import java.util.StringTokenizer;

public class G5_13398_연속된정수의합구하기_DP {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp1 = new int[N];
        dp1[0] = arr[0];

        int ans = dp1[0];

        // 오른쪽 방향으로 최대 연속 합 각 저장
        for(int i=1; i<N; i++){
            dp1[i] = Math.max(dp1[i-1]+arr[i], arr[i]);

            ans = Math.max(ans, dp1[i]);
        }

        int[] dp2 = new int[N];
        dp2[N-1] = arr[N-1];

        // 왼쪽 방향으로
        for(int i=N-2; i>=0; i--){
            dp2[i] = Math.max(dp2[i+1]+arr[i], arr[i]);
        }

        // 특정 값 지웠다고 가정하고, 그 값의 오른쪽 방향과 왼쪽 방향의 최대 연속 합 더하기
        // 윗줄에서 구한 값과 ans를 비교하여 더 큰 값으로 갱신
        for(int i=1; i<N-1; i++){
            int temp = dp1[i-1]+dp2[i+1];
            ans = Math.max(ans, temp);
        }

        bw.write(ans+"\n");
        bw.flush();
        bw.close();
        br.close();

    }
}
