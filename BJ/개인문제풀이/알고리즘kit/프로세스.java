package BJ.개인문제풀이.알고리즘kit;

import java.util.Collections;
import java.util.PriorityQueue;

public class 프로세스 {

    public int solution(int[] priorities, int location) {

        int ans = 0;

        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());

        for(int num : priorities){
            q.add(num);
        }

        while(!q.isEmpty()) {
            for (int i = 0; i < priorities.length; i++) {
                if (priorities[i] == q.peek()) {
                    q.poll();
                    ans++;
                    if (i == location) {
                        return ans;
                    }
                }
            }
        }
            return ans;


    }
}
