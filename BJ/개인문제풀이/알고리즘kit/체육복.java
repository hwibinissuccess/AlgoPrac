package BJ.개인문제풀이.알고리즘kit;

import java.util.Arrays;

public class 체육복 {

    public int solution(int n, int[] lost, int[] reserve) {

        int ans = 0;

        Arrays.sort(reserve);
        Arrays.sort(lost);

        ans = n - lost.length;

        for(int i=0; i<lost.length; i++){
            for(int j=0; j<reserve.length; j++){
                if(lost[i] == reserve[j]){
                    ans++;
                    lost[i] = -1;
                    reserve[j] = -1;
                    break;
                }
            }
        }

        for(int i=0; i<lost.length; i++){
            for(int j=0; j<reserve.length; j++){
                if(lost[i] -1 == reserve[j] || lost[i]+1 == reserve[j]){
                    ans++;
                    reserve[j] = -1;
                    break;
                }
            }
        }
        return ans;

    }

}
