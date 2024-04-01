package BJ.개인문제풀이.PGM;

public class 최고의집합_2 {

    public int[] solution(int n, int s) {

        int[] ans;

        if(n > s){
            ans = new int[]{-1};
            return ans;
        }

        int init = s/n; // 몫
        int mod = s%n; // 나머지

        ans = new int[n];

        // 몫으로 모든 값을 초기화
        for(int i=0; i<n; i++){
            ans[i] = init;
        }

        // 나머지 만큼 뒤에서부터(오름차순 정렬이 되도록) 1씩 더해주기
        int idx = n-1;

        for(int m=0; m<mod; m++){
            ans[idx]++;
            idx--;
        }

        return ans;

    }


}
