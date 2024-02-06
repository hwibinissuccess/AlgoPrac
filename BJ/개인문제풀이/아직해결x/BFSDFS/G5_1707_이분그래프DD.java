package BJ.개인문제풀이.아직해결x.BFSDFS;

import java.io.IOException;
import java.util.*;

public class G5_1707_이분그래프DD {

    public static void DFS(ArrayList[] a, int[] color, int x, int c){
        color[x] = c;
        for(int y:a[x]){
            if(color[y]==0){
                DFS(a,color,y,3-c);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t= sc.nextInt();
        while (t-- > 0){
            int n=sc.nextInt();
            int m = sc.nextInt();

            ArrayList[] a = (ArrayList[]) new ArrayList[n+1];

            for(int i=1; i<=n; i++){
                a[i] = new ArrayList();
            }

            for(int i=0; i<m; i++){
                int part1 = sc.nextInt();
                int part2 = sc.nextInt();

                a[part1].add(part2);
                a[part2].add(part1);
            }

            int[] color = new int[n+1];

        }
    }
}
