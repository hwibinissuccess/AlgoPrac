package BJ.개인문제풀이.PGM;

public class 나머지1이되는수찾기_1_SSS {

    public int solution(int n) {

        int ans = 0;

        int x = 1;

        while(true){

            if(n%x == 1){
                ans = x;
                break;
            }

            x++;

        }

        return ans;

    }

}
