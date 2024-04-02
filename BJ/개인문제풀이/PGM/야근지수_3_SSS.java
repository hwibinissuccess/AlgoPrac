package BJ.개인문제풀이.PGM;

import java.util.Collections;
import java.util.PriorityQueue;

public class 야근지수_3_SSS {

    public long solution(int n, int[] works) {

        long ans = 0;

        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0; i<works.length; i++){
            q.add(works[i]);
        }

        for(int i=0; i<n; i++){
            int max = (int)q.poll();
            if(max <= 0) break;
            q.add(max-1);
        }


        while(!q.isEmpty()){
            ans += Math.pow(q.poll(),2);
        }
        return ans;



    }

}
