package BJ.개인문제풀이.삼성SW역량테스트기출문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1_14888_연산자끼워넣기 {
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static int[] operator = new int[4];
    static int[] number;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        number = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            number[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<4; i++){
            operator[i] = Integer.parseInt(st.nextToken());
        }

        DFS(number[0],1);
        System.out.println(max);
        System.out.println(min);
    }

    public static void DFS(int num, int idx){
        if(idx == N){
            max = Math.max(max, num);
            min = Math.min(min, num);
            return;
        }

        for(int i=0; i<4; i++){
            if(operator[i]>0){
                operator[i]--;

                switch (i){
                    case 0: DFS(num+number[idx], idx+1); break;
                    case 1: DFS(num-number[idx], idx+1); break;
                    case 2: DFS(num*number[idx], idx+1); break;
                    case 3: DFS(num/number[idx], idx+1); break;
                }
                operator[i]++;
            }
        }
    }

}
