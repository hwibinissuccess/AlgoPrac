package BJ.개인문제풀이.PGM;

public class 다음큰숫자_2 {

    public int solution(int n) {

        int ans = 0;

        String str = Integer.toBinaryString(n);

        int cnt = 0;

        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) == '1') cnt++;
        }

        for(int i=n+1; i<1000000; i++){
            String temp = Integer.toBinaryString(i);
            int temp_cnt = 0;
            for(int j=0; j<temp.length(); j++){
                if(temp.charAt(j) == '1') temp_cnt++;
            }

            if(temp_cnt == cnt){
                ans =i;
                break;
            }

        }
        return ans;

    }

}
