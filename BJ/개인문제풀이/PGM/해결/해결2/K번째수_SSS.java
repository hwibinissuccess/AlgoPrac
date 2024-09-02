package BJ.개인문제풀이.PGM.해결.해결2;

import java.util.Arrays;

public class K번째수_SSS {

    public int[] solution(int[] array, int[][] commands) {

        int[] ans = new int[commands.length];

        for(int a=0; a<commands.length; a++){

            int i = commands[a][0]-1;
            int j = commands[a][1]-1;
            int k = commands[a][2]-1;
            int[] temp = new int[j-i+1];
            int idx = 0;
            for(int b=i; b<=j; b++){
                temp[idx] = array[b];
                idx++;
            }

            Arrays.sort(temp);

            ans[a] = temp[k];

        }

        return ans;
    }
}
