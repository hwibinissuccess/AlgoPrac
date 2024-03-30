package BJ.개인문제풀이.PGM;

import java.util.Arrays;

public class 최솟값만들기_S {

    public int solution(int []A, int []B)
    {

        int ans = 0;

        Arrays.sort(A);
        Arrays.sort(B);

        for(int i=0; i<A.length; i++){
            ans += A[i]*B[A.length-1-i];
        }

        return ans;

    }

}
