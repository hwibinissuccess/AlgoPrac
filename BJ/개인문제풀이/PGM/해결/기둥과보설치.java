package BJ.개인문제풀이.PGM.해결;

public class 기둥과보설치 {

    static boolean[][] bar;
    static boolean[][] river;

    public int[][] solution(int n, int[][] build_frame) {

        int cnt = 0;
        bar = new boolean[n+1][n+1];
        river = new boolean[n+1][n+1];

        for(int i=0; i<build_frame.length; i++){

            int x = build_frame[i][0];
            int y = build_frame[i][1];
            int type = build_frame[i][2];
            int action = build_frame[i][3];

            if(type == 0){
                if(action == 1){
                    if(checkBar(x,y)){
                        bar[x][y] = true;
                        cnt++;
                    }
                } else{
                    bar[x][y] = false;
                    if(!canDelete(n)) bar[x][y] = true;
                    else cnt--;
                }
            } else{
                if(action == 1){
                    if(checkRiver(x,y)){
                        river[x][y] = true;
                        cnt++;
                    }
                } else{
                    river[x][y] = false;
                    if(!canDelete(n)) river[x][y] = true;
                    else cnt--;
                }
            }
        }

        int[][] ans = new int[cnt][3];
        int idx = 0;

        for(int i=0; i<=n; i++){
            for(int j=0; j<=n; j++){

                if(bar[i][j]){
                    ans[idx][0] = i;
                    ans[idx][1] = j;
                    ans[idx++][2] = 0;
                }

                if(river[i][j]){
                    ans[idx][0] = i;
                    ans[idx][1] = j;
                    ans[idx++][2] = 1;
                }
            }
        }

        return ans;
    }

    public static boolean canDelete(int n){

        for(int i=0; i<=n; i++){
            for(int j=0; j<=n; j++){
                if(bar[i][j] && !checkBar(i,j)) return false;
                else if(river[i][j] && !checkRiver(i,j)) return false;
            }
        }

        return true;
    }

    public static boolean checkBar(int x, int y){

        if(y == 0) return true;
        else if(x > 0 && river[x-1][y] || river[x][y]) return true;
        else if(y > 0 && bar[x][y-1]) return true;

        return false;
    }

    public static boolean checkRiver(int x, int y){

        if(y > 0 && bar[x][y-1] || bar[x+1][y-1]) return true;
        else if(x > 0 && river[x-1][y] && river[x+1][y]) return true;

        return false;
    }
}
