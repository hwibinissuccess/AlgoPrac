package BJ.개인문제풀이.BJ;

import java.util.*;
import java.io.*;

public class DFS와BFS {

    static StringBuilder sb = new StringBuilder();
    static boolean[] check;
    static int[][] arr;
    static int node, line, start;
    static Queue<Integer> q = new LinkedList<>();

    public static void main(String args[]) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        node = Integer.parseInt(st.nextToken());
        line = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());


        arr = new int[node+1][node+1];
        check = new boolean[node+1];

        for(int i=0; i<line; i++){
            StringTokenizer str = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(str.nextToken());
            int b = Integer.parseInt(str.nextToken());

            arr[a][b] = arr[b][a] = 1;
        }

        DFS(start);
        sb.append("\n");
        check = new boolean[node+1];
        BFS(start);

        System.out.println(sb);

    }

    public static void DFS(int start){

        check[start] = true;
        sb.append(start+" ");

        for(int i=0; i<=node; i++){
            if(arr[start][i] == 1 && !check[i]){
                DFS(i);
            }
        }
    }

    public static void BFS(int start){

        q.add(start);
        check[start] = true;

        while(!q.isEmpty()){

            start = q.poll();
            sb.append(start+" ");

            for(int i=1; i<=node; i++){
                if(arr[start][i] == 1 && !check[i]){
                    q.add(i);
                    check[i] = true;
                }
            }
        }
    }
}
