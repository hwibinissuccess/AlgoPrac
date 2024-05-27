package BJ.개인문제풀이.PGM.해결;

public class 방문길이 {

    int[] dx = {-1,0,1,0};
    int[] dy = {0,1,0,-1};

    public int solution(String dirs) {

        boolean[][][] visit = new boolean[11][11][4];
        int x = 5, y = 5;
        int ans = 0;

        for(int i=0; i<dirs.length(); i++){

            char cc = dirs.charAt(i);
            int d = 0;

            if(cc == 'U'){
                d = 0;
            }

            if(cc == 'R'){
                d = 1;
            }

            if(cc == 'D'){
                d = 2;
            }

            if(cc == 'L'){
                d = 3;
            }

            int nx = x+dx[d];
            int ny = y+dy[d];

            if(nx < 0 || ny < 0 || nx >= 11 || ny >= 11) continue;

            if(!visit[nx][ny][d]){
                visit[nx][ny][d] = true;
                d = (d%2==0) ? 2-d : 4-d;
                visit[x][y][d] = true;
                ans ++;
            }

            x = nx;
            y = ny;
        }

        return ans;
    }
}
