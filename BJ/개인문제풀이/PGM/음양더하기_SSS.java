package BJ.개인문제풀이.PGM;

public class 음양더하기_SSS {

    public int solution(int[] absolutes, boolean[] signs) {

        int ans = 0;

        for(int i=0; i<absolutes.length; i++){
            int num = absolutes[i];
            if(signs[i]) ans += num;
            else if(!signs[i]) ans-= num;
        }

        return ans;

    }

}
