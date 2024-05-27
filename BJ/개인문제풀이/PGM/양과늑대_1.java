package BJ.개인문제풀이.PGM;

public class 양과늑대_1 {

    static int[] gInfo;
    static int[][] gEdges;
    static int maxSheepCnt = 0;

    public int solution(int[] info, int[][] edges) {

        gInfo = info;
        gEdges = edges;
        boolean[] visit = new boolean[info.length];
        dfs(0,visit,0,0);

        return maxSheepCnt;

    }

    public static void dfs(int idx, boolean[] visit, int sheepCnt, int wolfCnt){

        visit[idx] = true;

        if(gInfo[idx] == 0){
            sheepCnt++;
            if(sheepCnt > maxSheepCnt){
                maxSheepCnt = sheepCnt;
            }
        } else{
            wolfCnt++;
        }

        if(sheepCnt <= wolfCnt){
            return;
        }

        for(int[] edge : gEdges){
            if(visit[edge[0]] && !visit[edge[1]]){
                boolean[] nextVisit = new boolean[visit.length];

                for(int i=0; i<visit.length; i++){
                    nextVisit[i] = visit[i];
                }

                dfs(edge[1], nextVisit, sheepCnt, wolfCnt);
            }
        }
    }
}
