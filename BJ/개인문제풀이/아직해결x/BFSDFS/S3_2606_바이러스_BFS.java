package BJ.개인문제풀이.아직해결x.BFSDFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class S3_2606_바이러스_BFS {
    static int N_com, N_conn;
    static int map[][];
    static int cnt;
    static int visit[];
    static Queue<Integer> q = new LinkedList<Integer>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N_com = sc.nextInt();
        N_conn = sc.nextInt();

        map = new int[N_com+1][N_com+1];
        visit = new int[N_com+1];

        for(int i=0; i<N_com; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            map[a][b] = map[b][a] = 1;
        }

        BFS(1);
        System.out.println(cnt);

    }

    static void BFS(int start){
        q.offer(start);
        visit[start] = 1;

        while(q.isEmpty() == false){
            int current = q.poll();
            for(int i=1; i<N_com+1; i++){
                if(map[current][i] == 1 && visit[i] ==0){
                    q.offer(i);
                    visit[i] = 1;
                    cnt++;
                }
            }
        }

    }

}
