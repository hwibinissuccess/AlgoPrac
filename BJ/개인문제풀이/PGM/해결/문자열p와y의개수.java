package BJ.개인문제풀이.PGM.해결;

public class 문자열p와y의개수 {

    boolean solution(String s) {

        boolean ans = true;
        char[] str = new char[s.length()];
        s = s.toLowerCase();

        for(int i=0; i<s.length(); i++){
            str[i] = s.charAt(i);
        }

        int numP = 0;
        int numY = 0;

        for(int i=0; i<str.length; i++){

            char ss= str[i];

            if(ss== 'p') numP++;
            if(ss== 'y') numY++;

        }

        if(numP == numY) return true;
        else if(numP == 0 && numY == 0) return true;
        else return false;

    }

}
