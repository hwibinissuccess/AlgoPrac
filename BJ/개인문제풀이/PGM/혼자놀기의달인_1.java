package BJ.개인문제풀이.PGM;

import java.util.*;

public class 혼자놀기의달인_1 {


    public int solution(int[] cards) {

        int N = cards.length;
        boolean visit[] = new boolean[N];
        List<Integer> result = new ArrayList<>();

        for(int i=0;i<N; i++){

            Queue<Integer> q = new LinkedList<>();

            if(!visit[cards[i]-1]){

                int cnt = 0;
                q.add(cards[i]-1);
                visit[cards[i]-1] = true;

                while(!q.isEmpty()){

                    int now = q.poll();
                    cnt++;
                    int next = cards[now]-1;

                    if(visit[next]) continue;
                    q.add(next);
                    visit[next] = true;
                }
                result.add(cnt);
            }
        }

        Collections.sort(result, Comparator.reverseOrder());
        int ans = 0;
        if(result.size() != 1){
            ans = result.get(0)*result.get(1);
        }
        return ans;

    }
}
