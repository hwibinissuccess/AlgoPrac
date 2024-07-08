package BJ.개인문제풀이.PGM;

public class 미로탈출명령어_8 {

    static int[][] map;
    static String ans;
    static StringBuilder route;
    static char[] dir = {'d','l','r','u'};
    static int[] rdir = {1,0,0,-1};
    static int[] cdir = {0,-1,1,0};
    static int endRow, endCol;
    static int mapRow, mapCol;

    public String solution(int n, int m, int x, int y, int r, int c, int k) {

        route = new StringBuilder();
        ans = "";
        map = new int[n][m];
        endRow = r; endCol = c;
        mapRow = n; mapCol = m;

        int len = distance(x,y,r,c);

        if((k-len)%2 == 1 || k < len) return "impossible";
        DFS(x,y,0,k);

        return ans == "" ? "impossible" : ans;
    }

    public static int distance(int x, int y, int r, int c){
        return (int)Math.abs(x-r)+(int)Math.abs(y-c);
    }

    public static void DFS(int r, int c, int depth, int k){

        if(ans != "") return;
        if(depth + distance(r,c,endRow, endCol) > k) return;
        if(k == depth){
            ans = route.toString();
            return;
        }

        for(int i=0; i<4; i++){

            int nextRow = r+rdir[i];
            int nextCol = c+cdir[i];

            if(nextRow <= mapRow && nextCol <= mapCol && nextRow > 0 && nextCol > 0){
                route.append(dir[i]);
                DFS(nextRow, nextCol, depth+1, k);
                route.delete(depth, depth+1);
            }
        }
    }
}
