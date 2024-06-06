package BJ.개인문제풀이.PGM;

import java.util.LinkedList;
import java.util.Queue;

public class 두큐합같게만들기_4 {

    public int solution(int[] queue1, int[] queue2) {

        int ans = 0;
        long sum1 = getSum(queue1);
        long sum2 = getSum(queue2);
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        for(int i=0; i<queue1.length; i++){
            q1.add(queue1[i]);
            q2.add(queue2[i]);
        }

        while(sum1 != sum2){

            if(ans > (queue1.length+queue2.length)*2) return -1;

            int val = 0;
            if(sum1 < sum2){

                val = q2.poll();
                q1.add(val);
                sum1 += (long) val;
                sum2 -= (long) val;
            } else if(sum1 > sum2){
                val = q1.poll();
                q2.add(val);
                sum1 -= (long) val;
                sum2 += (long) val;
            } else{
                return ans;
            }

            ans++;
        }
        return ans;
    }

    public static long getSum(int[] q){

        long sum = 0;

        for(int i=0; i<q.length; i++){
            sum += (long)q[i];
        }
        return sum;
    }
}
