package BJ.개인문제풀이.PGM.해결;

public class 일이사나라의숫자 {

    public String solution(int n) {

        String[] temp = {"4","1","2"};
        String ans = "";

        while(n > 0){

            int r = n%3;

            ans = temp[r]+ans;

            n /= 3;

            if(r == 0) n--;
        }

        return ans;
    }
}
