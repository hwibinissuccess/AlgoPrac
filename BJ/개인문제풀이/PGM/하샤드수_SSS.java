package BJ.개인문제풀이.PGM;

public class 하샤드수_SSS {

    public boolean solution(int x) {

        int sum = 0;
        int ori = x;

        while(x>0){

            sum += x%10;
            x /=10;

        }

        if(ori%sum == 0) return true;
        else return false;


    }

}
