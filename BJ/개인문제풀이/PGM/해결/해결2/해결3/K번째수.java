package BJ.개인문제풀이.PGM.해결.해결2.해결3;

import java.util.Arrays;

public class K번째수 {



    public int[] solution(int[] array, int[][] commands) {

        int[] ans = new int[commands.length];

        for(int i=0; i<commands.length; i++){

            int[] com = commands[i];

            int x = com[0];
            int y = com[1];
            int k = com[2];
            int[] temp = new int[y-x+1];
            int idx = 0;

            for(int j=x-1; j<y; j++){

                temp[idx] = array[j];
                idx++;
            }

            Arrays.sort(temp);

            ans[i] = temp[k-1];
        }

        return ans;
    }
}
