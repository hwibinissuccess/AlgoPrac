package BJ.개인문제풀이.PGM;

public class 멀쩡한사각형_1 {

    public long solution(int w, int h) {
        long answer = 0;
        long weight = (long)w;
        long height = (long)h;

        long num=gcd(weight,height);

        answer = weight*height-(weight+height-num);
        return answer;
    }

    public long gcd(long x, long y){
        long big=Math.max(x,y);
        long small=Math.min(x,y);

        long temp = 0;
        while (small > 0) {
            temp = big % small;
            big = small;
            small = temp;
        }

        return big;
    }

}
