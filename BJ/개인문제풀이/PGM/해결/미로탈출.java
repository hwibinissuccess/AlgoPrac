package BJ.개인문제풀이.PGM.해결;

import java.util.LinkedList;
import java.util.Queue;

public class 미로탈출 {

    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static char[][] map;

    public int solution(String[] maps) {

        int ans = 0;
        int[] labor = new int[2];
        int[] exit = new int[2];
        int[] start = new int[2];
        map = new char[maps.length][maps[0].length()];
        for(int i=0; i<maps.length; i++){
            map[i] = maps[i].toCharArray();
            for(int j=0; j<maps[i].length(); j++){
                if(maps[i].charAt(j) == 'L'){
                    labor[0] = i;
                    labor[1] = j;
                }
                if(maps[i].charAt(j) == 'E'){
                    exit[0] = i;
                    exit[1] = j;
                }
                if(maps[i].charAt(j) == 'S'){
                    start[0] = i;
                    start[1] = j;
                }
            }
        }
        int a = BFS(start, labor);
        int b = BFS(labor, exit);

        if(a == 0 || b == 0) return -1;
        else return a+b;

    }

    public static int BFS(int[] start, int[] goal){

        Queue<int[]> q = new LinkedList<>();
        boolean[][] visit = new boolean[map.length][map[0].length];
        visit[start[0]][start[1]] = true;
        q.add(new int[]{start[0], start[1], 0});

        while(!q.isEmpty()){

            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int depth = cur[2];

            if(map[x][y] == map[goal[0]][goal[1]]) return depth;

            for(int i=0; i<4; i++){

                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || ny < 0 || nx >= map.length || ny >= map[0].length
                        || map[nx][ny] == 'X') continue;

                if(!visit[nx][ny]){
                    visit[nx][ny] = true;
                    q.add(new int[]{nx, ny,depth+1});
                }
            }
        }

        return 0;
    }
}

