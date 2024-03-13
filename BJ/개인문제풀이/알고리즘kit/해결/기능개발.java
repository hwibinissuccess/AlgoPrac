package BJ.개인문제풀이.알고리즘kit.해결;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 기능개발 {

    public ArrayList solution(int[] progresses, int[] speeds) {

        ArrayList<Integer> ans = new ArrayList<>();

        Queue<Integer> q = new LinkedList<>();

        for(int i=0; i<progresses.length; i++){
            q.add((int)Math.ceil((100.0-progresses[i])/speeds[i]));
        }

        while(!q.isEmpty()){
            int n = q.poll();
            int cnt = 1;

            while(!q.isEmpty() && n >=q.peek()){
                q.poll();
                cnt += 1;
            }

            ans.add(cnt);

        }

        return ans;

    }

}
