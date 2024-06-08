package BJ.개인문제풀이.PGM.해결;

import java.util.LinkedList;
import java.util.Queue;

public class 두큐합같게만들기 {

    public int solution(int[] queue1, int[] queue2) {

        long sum1 = getSum(queue1);
        long sum2 = getSum(queue2);
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        for(int i=0; i<queue1.length; i++){
            q1.add(queue1[i]);
            q2.add(queue2[i]);
        }

        int cnt = 0;
        while(sum1 != sum2){

            if(cnt > (queue1.length+queue2.length)*2) return -1;

            if(sum1 > sum2){
                int a = q1.poll();
                q2.add(a);
                sum1 -= (long)a;
                sum2 += (long)a;
                cnt++;
            } else if(sum1 < sum2){
                int a = q2.poll();
                q1.add(a);
                sum1 += (long)a;
                sum2 -= (long)a;
                cnt++;
            } else break;
        }

        return cnt;
    }

    public static long getSum(int[] q){

        long sum = 0;

        for(int i=0; i<q.length; i++){
            sum += q[i];
        }

        return sum;
    }
}
