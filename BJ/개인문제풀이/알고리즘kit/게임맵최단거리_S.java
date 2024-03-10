package BJ.개인문제풀이.알고리즘kit;

import java.util.LinkedList;
import java.util.Queue;

public class 게임맵최단거리_S {

    int[] dx = {1,0,-1,0};
    int[] dy = {0,1,0,-1};

    public int solution(int[][] maps) {

        int ans = 0;

        int[][] visit = new int[maps.length][maps[0].length];

        BFS(maps, visit);
        ans = visit[maps.length-1][maps[0].length-1];

        if(ans == 0){
            ans = -1;
        }
        return ans;

    }

    public void BFS(int[][] maps, int[][] visit){
        int x = 0;
        int y = 0;
        visit[x][y] = 1;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x,y});

        while(!q.isEmpty()){
            int[] cur = q.remove();
            int cx = cur[0];
            int cy = cur[1];

            for(int i=0; i<4; i++){
                int nx = cx+dx[i];
                int ny = cy+dy[i];

                if(nx < 0 || nx > maps.length-1 || ny < 0 || ny > maps[0].length-1)
                    continue;

                if(visit[nx][ny] == 0 && maps[nx][ny] == 1){
                    visit[nx][ny] = visit[cx][cy]+1;
                    q.add(new int[]{nx,ny});
                }
            }
        }

    }

}
