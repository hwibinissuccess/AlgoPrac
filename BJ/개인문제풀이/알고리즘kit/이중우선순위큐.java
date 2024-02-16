package BJ.개인문제풀이.알고리즘kit;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 이중우선순위큐 {

    public int[] solution(String[] operations) {

        int[] ans = new int[2];

        PriorityQueue<Integer> minq = new PriorityQueue<>();
        PriorityQueue<Integer> maxq = new PriorityQueue<>(Collections.reverseOrder());

        for(String op : operations){
            StringTokenizer st = new StringTokenizer(op);
            String judge = st.nextToken();
            int value = Integer.parseInt(st.nextToken());

            if(minq.size()<1 && judge.equals("D")){
                continue;
            }

            if(judge.equals("I")){
                minq.offer(value);
                maxq.offer(value);
                continue;
            }

            if(value < 0){
                int min = minq.poll();
                maxq.remove(min);
                continue;
            }

            int max = maxq.poll();
            minq.remove(max);
        }

        if(minq.size() > 0){
            ans[0] = maxq.poll();
            ans[1] = minq.poll();
        }
        return ans;

    }
}
