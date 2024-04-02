package BJ.개인문제풀이.PGM.해결;

public class 최고의집합 {

    public int[] solution(int n, int s) {

        int[] ans; // 정답 배열

        if(n > s){ // n이 더 클 경우 -1 담아서 리턴
            ans = new int[]{-1};
            return ans;
        }

        int init = s/n; // 몫
        int mod = s%n; // 나머지
        ans = new int[n]; // 정답배열 규모 정의

        for(int i=0; i<n; i++){
            ans[i] = init; // 몫으로 일단 일괄해서 다 넣기
        }


        if(mod != 0){
            for(int i=mod; i>0; i--){
                ans[n-1]++;
                n -=1;
            }
        }

        return ans;

    }

}
