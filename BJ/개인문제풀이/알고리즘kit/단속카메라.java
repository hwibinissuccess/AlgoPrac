package BJ.개인문제풀이.알고리즘kit;

import java.util.Arrays;

public class 단속카메라 {

    class Solution {
        public int solution(int[][] routes) {

            int ans = 0;

            Arrays.sort(routes, (o1, o2) -> o1[1] - o2[1]);

            int cam = Integer.MIN_VALUE;

            for(int[] route : routes){
                if(cam < route[0]){
                    cam = route[1];
                    ans++;
                }
            }
            return ans;

        }
    }

}
