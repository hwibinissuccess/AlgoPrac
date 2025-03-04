package BJ.개인문제풀이.PGM.해결;

public class 푸드파이트대회 {

    public String solution(int[] food) {

        String ans = "";

        for(int i=1; i<food.length; i++){
            for(int j=0; j<food[i]/2; j++){
                ans += Integer.toString(i);
            }
        }

        String plus = "";

        for(int i=ans.length()-1; i>=0; i--){
            plus += ans.charAt(i);
        }

        return ans + "0" + plus;
    }
}
