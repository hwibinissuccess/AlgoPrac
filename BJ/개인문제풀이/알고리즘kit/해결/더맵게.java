package BJ.개인문제풀이.알고리즘kit.해결;
import java.util.*;

public class 더맵게 {

    public int solution(int[] scoville, int K) {

        int ans = 0;

        PriorityQueue<Integer> q = new PriorityQueue<>();

        for(int i=0; i<scoville.length; i++){
            q.add(scoville[i]);
        }

        while(q.size() >= 2 && q.peek() < K){

            q.add(q.poll()+q.poll()*2);
            ans++;

        }

        if(q.peek() < K){
            return -1;
        }else{
            return ans;
        }




    }

}
