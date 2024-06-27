package BJ.개인문제풀이.PGM;

import java.util.*;

public class 무인도여행_1 {

    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static char[][] map;
    static boolean[][] visit;

    public List<Integer> solution(String[] maps) {

        List<Integer> ans = new ArrayList<>();
        map = new char[maps.length][maps[0].length()];
        visit = new boolean[map.length][map[0].length];

        for(int i=0; i<maps.length; i++){
            map[i] = maps[i].toCharArray();
        }

        for(int i=0; i<map.length; i++){
            for(int j=0; j<map[i].length; j++){
                if(!visit[i][j] && map[i][j] != 'X'){
                    ans.add(BFS(i,j));
                }
            }
        }

        if(ans.size() == 0){
            ans.add(-1);
        }

        Collections.sort(ans);
        return ans;
    }

    public static int BFS(int x, int y){

        int sum = 0;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x,y});
        visit[x][y] = true;

        while(!q.isEmpty()){

            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];
            sum += map[cx][cy]-'0';

            for(int i=0; i<4; i++){

                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(nx < 0 || ny < 0 || nx >= map.length || ny >= map[0].length) continue;

                if(!visit[nx][ny] && map[nx][ny] != 'X'){
                    visit[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                }
            }
        }

        return sum;
    }
}
