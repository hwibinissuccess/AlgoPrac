package BJ.개인문제풀이.PGM.해결;

public class 징검다리건너기 {

    public int solution(int[] stones, int k) {

        int min = 0;
        int max = Integer.MAX_VALUE;
        int ans = 0;

        while(min<=max){

            int mid = (max+min)/2;

            if(check(mid,stones,k)){
                min = mid+1;
                ans = mid;
            } else{
                max = mid-1;
            }

        }

        return ans;

    }

    public static boolean check(int mid, int[] stones, int k){

        int cnt = 0;

        for(int i=0; i<stones.length; i++){

            if(stones[i] < mid){
                cnt++;
                if(cnt>=k) return false;
            } else{
                cnt = 0;
            }

        }

        return true;

    }

}
