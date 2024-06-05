package BJ.개인문제풀이.PGM;

public class 양과늑대_6 {

    static int maxSheepCnt = 0;
    static int[] gInfo;
    static int[][] gEdges;

    public int solution(int[] info, int[][] edges) {

        boolean[] visit = new boolean[info.length];
        gInfo = info;
        gEdges = edges;
        DFS(0, visit, 0, 0);

        return maxSheepCnt;
    }

    public static void DFS(int idx, boolean[] visit, int sheepCnt, int wolfCnt){

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
            visit[idx] = false; // 상태 되돌리기
            return;
        }

        for(int[] edge : gEdges){
            if(visit[edge[0]] && !visit[edge[1]]){
                DFS(edge[1], visit, sheepCnt, wolfCnt);
            }
        }

        visit[idx] = false; // 상태 되돌리기
    }
}
