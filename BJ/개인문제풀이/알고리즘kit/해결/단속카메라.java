package BJ.개인문제풀이.알고리즘kit.해결;

import java.util.Arrays;

public class 단속카메라 {

    public int solution(int[][] routes) {

        int cam = Integer.MIN_VALUE;
        int ans = 0;

        Arrays.sort(routes, (o1, o2) -> o1[1] - o2[1]);



        for(int[] route : routes){
            if(cam < route[0]){
                cam = route[1];
                ans += 1;
            }
        }

        return ans;

    }

}
