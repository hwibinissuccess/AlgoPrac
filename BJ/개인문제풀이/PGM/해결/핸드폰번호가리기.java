package BJ.개인문제풀이.PGM.해결;

public class 핸드폰번호가리기 {

    public String solution(String phone_number) {

        String ans = "";
        int len = phone_number.length();

        for(int i=0; i<len; i++){

            if(i < len-4){
                ans += "*";
                continue;
            }

            ans += phone_number.charAt(i);
        }

        return ans;
    }
}
