package BJ.개인문제풀이.PGM.해결;

public class 이상한문자만들기 {

    public String solution(String s) {

        String ans = "";
        int idx = 0;

        for(int i=0; i<s.length(); i++){

            if(s.charAt(i) != ' '){

                if(idx%2 == 0){
                    ans += String.valueOf(s.charAt(i)).toUpperCase();
                    idx++;
                } else{
                    ans += String.valueOf(s.charAt(i)).toLowerCase();
                    idx++;
                }
            } else{
                ans += " ";
                idx = 0;
            }
        }

        return ans;
    }
}
