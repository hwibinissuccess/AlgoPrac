package BJ.개인문제풀이.PGM.해결;

public class 가장긴팰린드롬_2 {

    public int solution(String s){

        int ans = 1;
        int len = s.length();

        if(len == 1){
            return ans;
        }

        for(int i=1; i<len; i++){

            if(s.charAt(i) == s.charAt(i-1)){
                ans = Math.max(ans, Pal(s,i-1,i));
            }

            if(i>1 && s.charAt(i) == s.charAt(i-2)){
                ans = Math.max(ans, Pal(s,i-2,i));
            }
        }

        return ans;

    }

    public static int Pal(String s, int start, int end){



        while(start>=0 && end<s.length() && s.charAt(start) == s.charAt(end)){

            start--;
            end++;
        }

        return end-start-1;

    }

}
