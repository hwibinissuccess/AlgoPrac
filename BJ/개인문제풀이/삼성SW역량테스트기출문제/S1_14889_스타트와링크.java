package BJ.개인문제풀이.삼성SW역량테스트기출문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1_14889_스타트와링크 {
    static int[][] map;
    static int min = Integer.MAX_VALUE;
    static int N;
    static StringTokenizer st;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visit = new boolean[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        } // 입력완료

        DFS(0, 0);

        System.out.println(min);
    }

    public static void DFS(int depth, int a) {
        if (depth == N / 2) {
            diff();
            return;
        }

        for (int i = a; i < N; i++) {
            visit[i] = true;
            DFS(depth + 1, i + 1);
            visit[i] = false;

        }

    }

    public static void diff() {
        int start = 0;
        int link = 0;
        for (int i = 0; i < N - 1; i++) {
            for(int j=i+1; j<N; j++){
                if(visit[i]==true && visit[j] == true){
                    start += map[i][j];
                    start += map[j][i];
                } else if(visit[i] ==false && visit[j] ==false){
                    link += map[i][j];
                    link += map[j][i];
                }
            }
        }
        int val = Math.abs(start -link);
        if(val == 0){
            System.out.println(val);
            System.exit(0);
        }
        min = Math.min(min, val);
    }

}
