package BJ.개인문제풀이.아직해결x;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class S2_11725_트리의부모찾기 {
    static int N;
    static int[] parent;
    static boolean[] visit;
    static StringTokenizer st;
    static ArrayList<Integer> list[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        visit = new boolean[N+1];
        list = new ArrayList[N+1];
        parent = new int[N+1];

        for(int i=0; i<N+1; i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<N-1; i++){ // 연결된 노드 값 입력받기
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        DFS(1);

        for(int i=2; i<parent.length;i++){
            System.out.println(parent[i]);
        }
    }

    public static void DFS(int index){
        visit[index] = true;
        for(int i : list[index]){
            if(!visit[i]){
                parent[i] = index; // parent list에 각 노드들의 부모값 저장
            }
        }
    }

}
