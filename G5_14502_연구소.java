import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class G5_14502_연구소 {
    static int dx[] = {0,0,1,-1};
    static int dy[] = {1,-1,0,0};
    static int map[][];
    static int n,m;
    static int result = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        DFS(0);

        System.out.println(result);

    }

    static void DFS(int wall){
        if(wall == 3){
            BFS();
            return;
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(map[i][j] == 0){
                    map[i][j] = 1;
                    DFS(wall+1);
                    map[i][j] = 0;
                }
            }
        }
    }

    static void BFS(){
        Queue<Node> q = new LinkedList<>();

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(map[i][j] == 2){
                    q.add(new Node(i,j));
                }
            }
        }
        int map2[][] = new int[n][m];

        for(int i=0; i<n; i++){
            map2[i] = map[i].clone();
        }

        while(!q.isEmpty()){
            Node now = q.poll();
            int x = now.x;
            int y = now.y;

            for(int k=0; k<4; k++){
                int nx = x+dx[k];
                int ny = y+dy[k];

                if(0<=nx && nx<n && 0<=ny && ny<m){
                    if(map2[nx][ny] == 0){
                        q.add(new Node(nx, ny));
                        map2[nx][ny] = 2;
                    }
                }
            }
        }

        check(map2);

    }

    private static void check(int[][] map2){
        int safe = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(map2[i][j] == 0){
                    safe++;
                }
            }
        }
        if(result < safe){
            result = safe;
        }
    }

    static class Node{
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}


