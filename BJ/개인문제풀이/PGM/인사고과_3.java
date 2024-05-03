package BJ.개인문제풀이.PGM;

import java.util.Arrays;

public class 인사고과_3 {

    public int solution(int[][] scores) {

        int ans = 0;
        int size = scores.length;
        int n = scores[0][0];
        int m = scores[0][1];

        Arrays.sort(scores, (o1, o2)->{

            if(o1[0] == o2[0]){
                return o1[1]-o2[1];
            }
            return o2[0]-o1[0];

        });

        int maxScore = scores[0][1];

        for(int i=1; i<size; i++){
            if(scores[i][1] < maxScore){
                if(scores[i][0] == n && scores[i][1] == m) return -1;

                scores[i][0] = -1;
                scores[i][1] = -1;
            } else{
                maxScore = scores[i][1];
            }
        }

        Arrays.sort(scores, (o1,o2) -> (o2[0]+o2[1]) - (o1[0]+o1[1]));

        ans = 1;

        for(int i=0; i<size; i++){
            if(scores[i][0]+scores[i][1] > n+m){
                ans++;
            } else{
                break;
            }
        }

        return ans;

    }

}
