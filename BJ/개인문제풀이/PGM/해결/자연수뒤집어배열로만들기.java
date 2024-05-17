package BJ.개인문제풀이.PGM.해결;

public class 자연수뒤집어배열로만들기 {

    public int[] solution(long n) {

        String nn = String.valueOf(n);
        int[] ans = new int[nn.length()];
        int idx = 0;

        for(int i=nn.length()-1; i>=0; i--){

            String s = String.valueOf(nn.charAt(i));

            ans[idx] = Integer.parseInt(s);
            idx++;

        }

        return ans;

    }

}
