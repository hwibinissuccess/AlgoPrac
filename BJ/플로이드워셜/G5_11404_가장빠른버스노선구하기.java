package BJ.플로이드워셜;

import java.io.*;
import java.util.StringTokenizer;

public class G5_11404_가장빠른버스노선구하기 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, M;
    static int distance[][];

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        distance = new int[N+1][N+1];
        for(int i=1; i<=N; i++){ // 인접 행렬 초기화
            for(int j=1; j<=N; j++){
                if(i==j)
                    distance[i][j] = 0;
                else distance[i][j] = 10000001;
            }
        }
        for(int i=0; i<M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            if(distance[s][e] > v) distance[s][e] = v;
        }
        for(int k=1; k<=N; k++){ // 플로이드-워셜 알고림
            for(int i=1; i<=N; i++){
                for(int j=1; j<=N; j++){
                    if(distance[i][j] > distance[i][k]+distance[k][j])
                        distance[i][j] = distance[i][k]+distance[k][j];
                }
            }
        }
        for(int i=1; i<N; i++){
            for(int j=1; j<=N; j++){
                if(distance[i][j] == 10000001) System.out.println("0 ");
                else System.out.println(distance[i][j] + " ");
            }
            System.out.println();
        }
    }
}
