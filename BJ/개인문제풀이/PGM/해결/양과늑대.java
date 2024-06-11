package BJ.개인문제풀이.PGM.해결;

public class 양과늑대 {

    static boolean[] visit;
    static int ans;
    static int[] gInfo;
    static int[][] gEdges;

    public int solution(int[] info, int[][] edges) {

        visit = new boolean[info.length];
        ans = 0;
        gInfo = info;
        gEdges = edges;

        DFS(0,visit, 0,0);

        return ans;
    }

    public static void DFS(int idx, boolean[] visit, int sheepCnt, int wolfCnt){

        visit[idx] = true;

        if(gInfo[idx] == 0){
            sheepCnt++;
            if(sheepCnt > ans){
                ans = sheepCnt;
            }
        } else{
            wolfCnt++;
        }

        if(wolfCnt >= sheepCnt){
            visit[idx] = false;
            return;
        }

        for(int[] edge : gEdges){

            if(visit[edge[0]] && !visit[edge[1]]){
                DFS(edge[1], visit, sheepCnt, wolfCnt);

            }

        }
        visit[idx] = false;
    }
}
