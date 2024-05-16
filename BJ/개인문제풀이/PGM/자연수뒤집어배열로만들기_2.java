package BJ.개인문제풀이.PGM;

public class 자연수뒤집어배열로만들기_2 {

    public int[] solution(long n) {

        String str = String.valueOf(n);

        int[] ans = new int[str.length()];
        int idx = 0;

        while(n>0){

            ans[idx] = (int)(n%10);
            n /= 10;
            idx++;

        }

        return ans;

    }

}
