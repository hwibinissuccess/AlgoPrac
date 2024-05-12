package BJ.개인문제풀이.PGM;

public class 서울에서김서방찾기_1 {

    public String solution(String[] seoul) {

        String ans = "";
        int idx = 0;

        for(int i=0; i<seoul.length; i++){

            if(seoul[i].equals("Kim")){
                idx =i;
            }
        }



        return "김서방은 "+idx+"에 있다";

    }

}
