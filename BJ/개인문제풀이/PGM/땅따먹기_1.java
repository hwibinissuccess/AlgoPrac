package BJ.개인문제풀이.PGM;

public class 땅따먹기_1 {

    int solution(int[][] land) {

        int ans = 0;

        for(int i=1; i<land.length; i++){

            land[i][0] += Math.max(land[i-1][1], Math.max(land[i-1][2], land[i-1][3]));
            land[i][1] += Math.max(land[i-1][0], Math.max(land[i-1][2], land[i-1][3]));
            land[i][2] += Math.max(land[i-1][0], Math.max(land[i-1][1], land[i-1][3]));
            land[i][3] += Math.max(land[i-1][0], Math.max(land[i-1][2], land[i-1][1]));

        }

        for(int i=0; i<4; i++){
            ans = Math.max(ans, land[land.length-1][i]);
        }

        return ans;

    }

}
