package BJ.개인문제풀이.PGM;

import java.util.Collections;
import java.util.PriorityQueue;

public class 숫자게임_SSS {

    public int solution(int[] A, int[] B) {

        int ans = 0;

        PriorityQueue<Integer> qA = new PriorityQueue<Integer>(Collections.reverseOrder());
        PriorityQueue<Integer> qB = new PriorityQueue<Integer>(Collections.reverseOrder());
        // 오름차순으로 우선순위 큐 만들기

        for(int i=0; i<A.length; i++){
            qA.add(A[i]);
            qB.add(B[i]);
        } // 우선순위 큐에 각 배열 넣기

        for(int i=0; i<A.length; i++){
            if(qA.peek() >= qB.peek()){ // A가 더 크거나 같을 때
                qA.poll();
            } else{ // 나머지 경우
                qA.poll();
                qB.poll();
                ans++;
            }

        }

        return ans;


    }

}
