package BJ.개인문제풀이.PGM;

public class 일이사나라의숫자_3 {
    public String solution(int n) {

        String ans = "";
        String[] nums = {"4","1","2"};

        while(n > 0){

            int r = n%3;
            n /= 3;

            if(r == 0) n--;

            ans = nums[r]+ans;
        }

        return ans;
    }
}
