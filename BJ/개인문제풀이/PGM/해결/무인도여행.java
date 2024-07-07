package BJ.개인문제풀이.PGM.해결;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class 무인도여행 {

    static boolean[][] visit;
    static char[][] map;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    public ArrayList<Integer> solution(String[] maps) {

        ArrayList<Integer> ans = new ArrayList<>();
        visit = new boolean[maps.length][maps[0].length()];
        map = new char[maps.length][maps[0].length()];
        for(int i=0; i<maps.length; i++){
            map[i] = maps[i].toCharArray();
        }

        for(int i=0; i<maps.length; i++){
            for(int j=0; j<maps[0].length(); j++){
                if(!visit[i][j] && map[i][j] != 'X'){
                    ans.add(BFS(i,j));
                }
            }
        }

        Collections.sort(ans);

        if(ans.size() == 0) ans.add(-1);

        return ans;

    }

    public static int BFS(int x, int y){

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x,y});
        int sum = 0;

        while(!q.isEmpty()){

            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];

            visit[cx][cy] = true;
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
