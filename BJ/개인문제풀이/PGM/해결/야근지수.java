package BJ.개인문제풀이.PGM.해결;

import java.util.Collections;
import java.util.PriorityQueue;

public class 야근지수 {

    public long solution(int n, int[] works) {

        long ans = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder()); // 오름차순 정렬

        for(int i=0; i<works.length; i++){
            q.add(works[i]);
        } // Queue에 넣어주기

        for(int i=0; i<n; i++){
            int num = (int)q.poll();
            if(num == 0) break;
            q.add(num-1);
        }

        while(!q.isEmpty()){
            ans += Math.pow(q.poll(), 2);
        }

        return ans;

    }

}
