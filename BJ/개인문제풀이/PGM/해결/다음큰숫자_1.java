package BJ.개인문제풀이.PGM.해결;

public class 다음큰숫자_1 {

    public int solution(int n) {

        int ans = 0;
        String nn = Integer.toBinaryString(n);
        int cntA = 0;
        int cntB = 0;


        for(int i=0; i<nn.length(); i++){
            if(nn.charAt(i) == '1') cntA++;
        }


        for(int i=n+1; i<=1000000; i++){
            cntB = 0;
            String mm = Integer.toBinaryString(i);

            for(int j=0; j<mm.length(); j++){
                if(mm.charAt(j) == '1') cntB++;
            }

            if(cntA == cntB){
                ans = i;
                break;
            }

        }

        return ans;

    }

}
