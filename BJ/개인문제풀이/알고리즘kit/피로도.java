package BJ.개인문제풀이.알고리즘kit;

public class 피로도 {

    public int ans;
    public boolean[] visit;

    public int solution(int k, int[][] dungeons) {

        visit = new boolean[dungeons.length];

        DFS(0,k,dungeons);

        return ans;

    }

    public void DFS(int depth, int k, int[][] dungeons){
        for(int i=0; i<dungeons.length; i++){
            if(!visit[i] && dungeons[i][0] <= k){
                visit[i] = true;
                DFS(depth+1, k-dungeons[i][1], dungeons);
                visit[i] = false;
            }
        }
        ans = Math.max(ans, depth);
    }

}
