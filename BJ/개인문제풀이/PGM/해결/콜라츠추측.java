package BJ.개인문제풀이.PGM.해결;

public class 콜라츠추측 {

    public long solution(long num) {

        long ans = 0;

        for(int i=0; i<500; i++){

            if(num == 1) break;

            if(num%2 == 0){
                num /=2;
                ans++;
            } else{
                num = (num*3)+1;
                ans++;
            }
        }

        if(num != 1) return -1;
        else return ans;
    }
}
