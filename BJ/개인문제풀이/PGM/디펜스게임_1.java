package BJ.개인문제풀이.PGM;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class 디펜스게임_1 {

    public int solution(int n, int k, int[] enemy) {

        int ans = enemy.length;
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int my = n;
        int card = k;

        for(int i=0; i<enemy.length; i++){
            my -= enemy[i];
            pq.add(enemy[i]);

            if(my < 0){
                if(card > 0 && !pq.isEmpty()){
                    my += pq.poll();
                    card--;
                } else{
                    ans = i;
                    break;
                }
            }
        }
        return ans;
    }
}
