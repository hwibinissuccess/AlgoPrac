package BJ.개인문제풀이.PGM;

import java.util.LinkedList;
import java.util.Queue;

public class 미로탈출_2 {

    static String[][] map;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    public int solution(String[] maps) {

        map = new String[maps.length][maps[0].length()];
        int[] start = new int[2];
        int[] labor = new int[2];

        for(int i=0; i<maps.length; i++){
            String[] temp = maps[i].split("");

            for(int j=0; j<temp.length; j++){
                map[i][j] = temp[j];

                if(map[i][j].equals("S")){
                    start = new int[]{i,j};
                }

                if(map[i][j].equals("L")){
                    labor = new int[]{i,j};
                }
            }
        }

        int result = BFS(start, "L");
        int result2 = BFS(labor, "E");

        if(result == -1 || result2 == -1) return -1;

        return result + result2;
    }

    public static int BFS(int[] start, String target){

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{start[0], start[1], 0});

        boolean[][] visit = new boolean[map.length][map[0].length];

        while(!q.isEmpty()){

            int[] cur = q.poll();

            int x = cur[0];
            int y = cur[1];
            int cnt = cur[2];
            visit[x][y] = true;

            if(map[x][y].equals(target)) return cnt;

            for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx >= 0 && ny >= 0 && nx < map.length && ny < map[0].length &&!visit[nx][ny]){
                    if(!map[nx][ny].equals("X")){
                        visit[nx][ny] = true;
                        q.add(new int[]{nx,ny,cnt+1});
                    }
                }
            }
        }

        return -1;
    }
}
