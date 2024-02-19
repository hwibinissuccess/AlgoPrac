package BJ.개인문제풀이.알고리즘kit;

import java.util.Arrays;

public class 입국심사 {

    public long solution(int n, int[] times) {

        long ans = 0;
        Arrays.sort(times);
        long left=0;
        long right = times[times.length-1]*(long)n;

        while(left <= right){
            long mid = (left+right)/2;
            long com = 0;

            for(int i=0; i<times.length; i++){
                com += mid/times[i];
            }
            if(com < n)
                left = mid+1;
            else{
                right = mid-1;
                ans = mid;
            }
        }
        return ans;

    }

}
