package BJ.개인문제풀이.Softeer;

import java.io.BufferedReader;
import java.io.*;
import java.util.*;


public class 금고털이_1 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int W = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        ArrayList<int[]> list = new ArrayList<>();

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            list.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }

        Collections.sort(list, (o1,o2) -> o2[1]-o1[1]);

        int ans = 0;

        for(int[] item : list){
            if(W <= item[0]){
                ans += W*item[1];
                break;
            } else{
                ans += item[0]*item[1];
                W -= item[0];
            }
        }

        System.out.println(ans);
    }
}
