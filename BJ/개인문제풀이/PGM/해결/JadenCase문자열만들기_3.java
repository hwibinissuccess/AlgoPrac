package BJ.개인문제풀이.PGM.해결;

public class JadenCase문자열만들기_3 {

    public String solution(String s) {

        String ans = ""; // 정답 변수
        String[] sen = s.split(" "); // 입력을 단어별로 구분하는 배열

        for(int i=0; i<sen.length; i++){
            if(sen[i].length() == 0){ // 공백문자라면
                ans += " ";
            } else{ // 아니라면
                ans += sen[i].substring(0,1).toUpperCase(); // 맨 앞 대문자
                ans += sen[i].substring(1,sen[i].length()).toLowerCase(); // 나머지 소문자
                ans += " ";
            }
        }

        if(s.substring(s.length()-1, s.length()).equals(" ")){
            return ans;
        }

        return ans.substring(0,ans.length()-1);

    }

}
