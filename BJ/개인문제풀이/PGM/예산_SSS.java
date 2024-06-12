package BJ.개인문제풀이.PGM;

import java.util.Arrays;

public class 예산_SSS {

    public int solution(int[] d, int budget) {

        int ans = 0;

        Arrays.sort(d);
        int sum = budget;

        for(int i=0; i<d.length; i++){

            if(sum < d[i]) break;
            else {
                sum -= d[i];
                ans++;
            }
        }

        return ans;

    }
}
