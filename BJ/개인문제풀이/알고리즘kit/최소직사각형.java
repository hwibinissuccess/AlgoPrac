package BJ.개인문제풀이.알고리즘kit;

public class 최소직사각형 {

    public int solution(int[][] sizes) {

        int ans = 0;
        int max_v=0;
        int max_h=0;

        for(int i=0; i<sizes.length; i++){
            int v = Math.max(sizes[i][0], sizes[i][1]);
            int h = Math.min(sizes[i][0], sizes[i][1]);
            max_v = Math.max(max_v,v);
            max_h = Math.max(max_h,h);
        }

        return ans = max_v*max_h;

    }

}
