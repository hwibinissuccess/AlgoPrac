package BJ.개인문제풀이.PGM;

import java.util.ArrayList;
import java.util.List;

public class 줄서는방법_1 {

    public int[] solution(int n, long k) {

        int[] ans = new int[n];
        List<Integer> list = new ArrayList<>();
        long f = 1;
        for(int i=1; i<=n; i++){
            list.add(i);
            f *= i;
        }

        k--;
        int idx = 0;

        while(idx < n){

            f /= n-idx;
            ans[idx++] = list.remove((int)(k/f));
            k %= f;
        }

        return ans;
    }
}
