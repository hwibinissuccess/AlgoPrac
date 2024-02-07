package BJ.개인문제풀이.해결;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S2_4963_섬의개수 {
    static int[][] map;
    static boolean[][] visit;
    static int[] dx = {0, 0, -1, 1, -1, 1, -1, 1};
    static int[] dy = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int w, h, cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            map = new int[w][h];
            visit = new boolean[w][h];
            cnt = 0;

            if (w == 0 && h == 0) {
                break;
            }


            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    map[j][i] = Integer.parseInt(st.nextToken());

                }
            } // 입력받기

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (!visit[j][i] && map[j][i] == 1) {
                        cnt++;
                        DFS(j,i);
                    }
                }
            }
            System.out.println(cnt);
        }
    }

    public static void DFS(int x, int y) {
        visit[x][y] = true;

        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (!range_check(nx, ny) && !visit[nx][ny] && map[nx][ny] == 1) {
                DFS(nx, ny);
            }
        }
    }

    public static boolean range_check(int x, int y) {
        return x < 0 || y < 0 || x >= w || y >= h;
    }
}
