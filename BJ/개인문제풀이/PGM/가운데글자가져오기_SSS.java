package BJ.개인문제풀이.PGM;

public class 가운데글자가져오기_SSS {

    public String solution(String s) {

        String ans = "";
        int mid = s.length()/2;
        int len = s.length();

        if(len%2 == 0){
            ans = s.substring(mid-1, mid+1);

        }else{
            ans = s.substring(mid,mid+1);
        }

        return ans;
    }
}
