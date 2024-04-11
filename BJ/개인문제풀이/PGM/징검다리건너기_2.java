package BJ.개인문제풀이.PGM;

public class 징검다리건너기_2 {

    public int solution(int[] stones, int k) {

        int min = 0;
        int max = Integer.MAX_VALUE;
        int ans = 0;

        while(min <= max){

            int mid = (min+max)/2;

            if(check(mid,k,stones)){
                min = mid+1;
                ans = mid;
            } else{
                max =mid-1;
            }
        }

        return ans;

    }

    public static boolean check(int mid, int k, int[] stones){

        int cnt = 0;

        for(int i=0; i<stones.length; i++){

            if(stones[i] < mid){
                cnt++;
                if(cnt >= k) return false;
            } else cnt = 0;
        }

        return true;

    }


}
