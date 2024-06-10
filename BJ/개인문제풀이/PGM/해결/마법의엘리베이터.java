package BJ.개인문제풀이.PGM.해결;

public class 마법의엘리베이터 {

    public int solution(int storey) {

        int ans = 0;

        while(storey != 0){

            int one = storey%10;
            int ten = (storey/10)%10;

            if(one > 5){
                ans += 10-one;
                storey += 10;
            } else if(one == 5){
                ans += one;
                storey += (ten >= 5 ? 10 : 0);
            } else{
                ans += one;
            }

            storey /= 10;
        }

        return ans;
    }
}
