package BJ.개인문제풀이.PGM;

public class 점프와순간이동_1 {

    public int solution(int n) {

        int ans = 0;

        while(n != 0){

            if(n%2 == 0){
                n /= 2;
            } else{
                n--;
                ans++;
            }


        }
        return ans;


    }

}
