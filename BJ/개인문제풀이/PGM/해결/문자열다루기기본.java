package BJ.개인문제풀이.PGM.해결;

public class 문자열다루기기본 {

    public boolean solution(String s) {

        char[] ss = s.toCharArray();

        for(int i=0; i<ss.length; i++){

            if(!Character.isDigit(ss[i])) return false;
        }

        if(s.length() == 4 || s.length() == 6) return true;
        else return false;
    }
}
