package BJ.개인문제풀이.PGM;

public class 핸드폰번호가리기_1_SSS {

    public String solution(String phone_number) {

        String ans = "";
        int len = phone_number.length();

        for(int i=0; i<len; i++){

            if(i<len-4) ans += "*";
            else ans += phone_number.charAt(i);
        }
        return ans;
    }
}
