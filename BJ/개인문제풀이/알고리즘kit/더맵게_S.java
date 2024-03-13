package BJ.개인문제풀이.알고리즘kit;

import java.util.PriorityQueue;

public class 더맵게_S {

    public int solution(int[] scoville, int K) {

        int ans=0;
        PriorityQueue<Integer> q = new PriorityQueue<>();

        for(int i=0; i<scoville.length; i++){
            q.add(scoville[i]);
        }

        while(q.peek() < K){
            if(q.size() == 1){
                return -1;
            }
            q.add(q.poll() + q.poll()*2);
            ans++;
        }
        return ans;

    }

}
