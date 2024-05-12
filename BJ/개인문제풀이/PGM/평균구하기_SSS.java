package BJ.개인문제풀이.PGM;

public class 평균구하기_SSS {

    public double solution(int[] arr) {

        double sum = 0;
        double cnt = arr.length;
        double ans = 0;

        for(int i=0; i<arr.length; i++){
            sum += arr[i];
        }

        ans = sum/cnt;

        return ans;

    }

}
