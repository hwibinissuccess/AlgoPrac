package BJ.개인문제풀이.PGM;

public class 이진변환반복하기_2_SSS {

    public int[] solution(String s) {

        int[] ans = new int[2];

        while(s.length() > 1){

            int cntOne = 0;
            for(int i=0; i<s.length(); i++){
                if(s.charAt(i) == '0') ans[1]++;
                else cntOne++;
            }

            s = Integer.toBinaryString(cntOne);
            ans[0]++;

        }

        return ans;

    }

}
