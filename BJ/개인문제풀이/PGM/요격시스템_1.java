package BJ.개인문제풀이.PGM;

import java.util.Arrays;

public class 요격시스템_1 {
    public int solution(int[][] targets) {

        int ans = 0;
        Arrays.sort(targets, (o1,o2) -> o1[1]-o2[1]);

        int s = 0;
        int e = 0;

        for(int[] target : targets){

            if(target[0] >= e){
                ans++;
                e=target[1];
            }
        }

        return ans;
    }
}
