package BJ.개인문제풀이.PGM;

import java.util.ArrayList;

public class 하노이의탑_1 {

    static ArrayList<int[]> seq;

    public int[][] solution(int n) {

        seq = new ArrayList<>();

        hanoi(n,1,2,3);

        int[][] ans = new int[seq.size()][2];

        for(int i=0; i<seq.size(); i++){
            int[] cmd = seq.get(i);
            ans[i][0] = cmd[0];
            ans[i][1] = cmd[1];
        }

        return ans;

    }

    public static void hanoi(int n, int from, int via, int to){

        int[] move = {from, to};

        if(n==1){
            seq.add(move);
        } else{
            hanoi(n-1, from, to, via);
            seq.add(move);
            hanoi(n-1, via, from, to);
        }
    }

}
