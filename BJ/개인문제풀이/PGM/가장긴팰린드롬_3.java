package BJ.개인문제풀이.PGM;

public class 가장긴팰린드롬_3 {

    public int solution(String s){

        int ans = 1;

        if(s.length() <= 1){
            return 1;
        }

        for(int i=1; i<s.length(); i++){

            if(s.charAt(i) == s.charAt(i-1)){
                ans = Math.max(ans, Pal(s,i-1,i));
            }

            if(i>1 && s.charAt(i) == s.charAt(i-2)){
                ans = Math.max(ans,Pal(s,i-2,i));
            }

        }

        return ans;

    }

    public static int Pal(String s, int idx1, int idx2){

        while(idx1>=0 && idx2<s.length() && s.charAt(idx1) == s.charAt(idx2)){
            --idx1;
            ++idx2;
        }

        return idx2-idx1-1;

    }

}
