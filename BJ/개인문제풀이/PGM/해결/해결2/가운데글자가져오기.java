package BJ.개인문제풀이.PGM.해결.해결2;

public class 가운데글자가져오기 {


    public String solution(String s) {

        int len = s.length();
        int n = len/2;
        String ans = "";

        if(len%2 == 0){
            return s.substring(n-1,n+1);
        } else{
            return s.substring(n,n+1);
        }
    }
}
