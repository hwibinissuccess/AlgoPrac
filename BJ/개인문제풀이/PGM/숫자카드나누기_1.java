package BJ.개인문제풀이.PGM;

import java.util.Arrays;

public class 숫자카드나누기_1 {

    public int solution(int[] arrayA, int[] arrayB) {

        int ans = 0;
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);

        int gcdA = arrayA[0];
        int gcdB = arrayB[0];

        // 최대 공약수 구하기
        for(int i=1; i<arrayB.length; i++){
            gcdA = gcd(arrayA[i], gcdA);
            gcdB = gcd(arrayB[i], gcdB);
        }

        // 나눌 수 없는지 확인
        if(!canDivide(arrayB, gcdA)){
            ans = Math.max(ans, gcdA);
        }

        if(!canDivide(arrayA, gcdB)){
            ans = Math.max(ans, gcdB);
        }

        return ans;
    }

    public static int gcd(int a, int b){
        if(b==0) return a;
        else return gcd(b, a%b);
    }

    public static boolean canDivide(int[] array, int gcd){

        for(int num : array){
            if(num%gcd == 0){
                return true;
            }
        }

        return false;
    }
}
