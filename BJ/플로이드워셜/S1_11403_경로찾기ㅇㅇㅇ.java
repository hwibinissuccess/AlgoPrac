package BJ.플로이드워셜;

import java.io.*;
import java.util.StringTokenizer;

public class S1_11403_경로찾기ㅇㅇㅇ {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static int distance[][];

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        distance = new int[N][N];
        for(int i=0; i<N; i++){ // 입력 인접 행렬 값 그대로 저장
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                int v = Integer.parseInt(st.nextToken());
                distance[i][j] = v;
            }
        }
        for(int k=0; k<N; k++){ //변형된 플로이드워셜 알고리즘
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(distance[i][k] == 1 && distance[k][j] == 1) distance[i][j] = 1;
                }
            }
        }
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                System.out.println(distance[i][j] + " ");
            }
            System.out.println();
        }
    }
}
