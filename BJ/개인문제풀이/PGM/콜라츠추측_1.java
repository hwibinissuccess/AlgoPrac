package BJ.개인문제풀이.PGM;

public class 콜라츠추측_1 {

    public long solution(long num) {


        int cnt = 0;


        if(num == 1) return 0;
        while( num != 1){

            if(cnt >= 500) return -1;


            if(num%2 == 0){
                num /= 2;

            }else{
                num = (num*3)+1;

            }

            cnt++;
        }

        return cnt;


    }

}
