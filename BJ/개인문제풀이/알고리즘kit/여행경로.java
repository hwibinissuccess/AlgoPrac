package BJ.개인문제풀이.알고리즘kit;

import java.util.ArrayList;
import java.util.Collections;

public class 여행경로 {

    static boolean[] visit;
    static ArrayList<String> allRoute;

    public String[] solution(String[][] tickets) {

        String[] ans = {};
        int cnt=0;
        visit = new boolean[tickets.length];
        allRoute = new ArrayList<>();

        DFS("ICN", "ICN", tickets, cnt);

        Collections.sort(allRoute);
        ans = allRoute.get(0).split(" ");
        return ans;

    }

    public static void DFS(String start, String route, String[][] tickets, int cnt){
        if(cnt == tickets.length){
            allRoute.add(route);
            return;
        }

        for(int i=0; i<tickets.length; i++){
            if(start.equals(tickets[i][0]) && !visit[i]){
                visit[i] = true;
                DFS(tickets[i][1], route+" "+tickets[i][1], tickets, cnt+1);
                visit[i] = false;
            }
        }
    }

}
