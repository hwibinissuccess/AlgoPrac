package BJ.개인문제풀이.PGM;

public class JadenCase문자열만들기_4_SSS {

    public String solution(String s) {
        String ans = "";
        String[] arr = s.split(" ");

        for(int i=0; i<arr.length; i++){
            String now = arr[i];

            if(arr[i].length() == 0){
                ans += " ";
            } else {
                ans += now.substring(0,1).toUpperCase();
                ans += now.substring(1, now.length()).toLowerCase();
                ans += " ";
            }
        }

        if(s.substring(s.length()-1, s.length()).equals(" ")){
            return ans;
        }

        System.out.println();
        return ans.substring(0,ans.length()-1);

    }

}
