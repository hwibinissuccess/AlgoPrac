package BJ.개인문제풀이.PGM.해결;

import java.util.Arrays;

public class 인사고과 {

    public int solution(int[][] scores) {

        int ans = 0;
        int wanx = scores[0][0];
        int wany = scores[0][1];
        int len = scores.length;

        Arrays.sort(scores, (o1, o2) -> {

            if(o1[0] == o2[0]) return o2[1]-o1[1];
            return o2[0]-o1[0];

        });

        int maxY = scores[0][1];

        for(int i=1; i<len; i++){

            if(maxY > scores[i][1]){
                if(scores[i][0] == wanx && scores[i][1] == wany) return -1;
                scores[i][0] = -1;
                scores[i][1] = -1;
            }else{
                maxY = scores[i][1];
            }

        }

        Arrays.sort(scores, (o1,o2)->
                (o2[0]+o2[1]) - (o1[0]+o1[1])
        );

        for(int i=0; i<scores.length; i++){
            if(scores[i][0] == wanx && scores[i][1] == wany){
                ans = i+1;
                break;
            }
        }

        return ans;



    }

}
