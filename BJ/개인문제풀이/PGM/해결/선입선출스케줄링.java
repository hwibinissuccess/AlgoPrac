package BJ.개인문제풀이.PGM.해결;

public class 선입선출스케줄링 {

    public int solution(int n, int[] cores) {

        int ans = 0;
        if(n<=cores.length) return n;
        int low = 1;
        int high = n*10000;
        int time = 0;
        int work = 0;

        while(low<=high){

            int mid = (low+high)/2;

            int cnt = cal(mid, cores);

            if(cnt>=n){
                high = mid-1;
                time = mid;
                work = cnt;
            } else{
                low = mid+1;
            }
        }

        work -= n;

        for(int i=cores.length-1; i>=0; i--){

            if(time%cores[i] == 0){
                if(work == 0){
                    ans = i+1;
                    break;
                }
                work--;
            }

        }

        return ans;

    }

    public static int cal(int mid, int[] cores){

        int cnt = cores.length;

        for(int i=0; i<cores.length; i++){
            cnt += mid/cores[i];
        }

        return cnt;
    }

}
