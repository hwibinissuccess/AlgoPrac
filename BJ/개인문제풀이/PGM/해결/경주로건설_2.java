package BJ.개인문제풀이.PGM.해결;

import java.util.LinkedList;
import java.util.Queue;

public class 경주로건설_2 {

    static int[][][] visit;
    static int[][] d = {{1,0},{-1,0},{0,1},{0,-1}};
    static int N;

    public int solution(int[][] board) {

        N = board.length;
        visit = new int[N][N][4];

        return bfs(board);

    }

    public static int bfs(int[][] board){

        int x=0, y=0, direction=-1, cost=0;
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(y,x,direction, cost));
        int min_cost = Integer.MAX_VALUE;

        while(!q.isEmpty()){

            Node now = q.poll();

            if(now.x == N-1 && now.y == N-1){
                min_cost = Math.min(min_cost, now.cost);
            }

            for(int dir=0; dir<4; dir++){

                int dx = now.x + d[dir][0];
                int dy = now.y + d[dir][1];

                if(dx<0 || dy<0 || dx>=N || dy>=N || board[dx][dy] == 1) continue;

                int nextCost = now.cost;

                if(now.dir == -1 || now.dir == dir){
                    nextCost += 100;
                }else{
                    nextCost += 600;
                }

                if(visit[dx][dy][dir] == 0 || board[dx][dy] >= nextCost){
                    visit[dx][dy][dir] = 1;
                    board[dx][dy] = nextCost;
                    q.add(new Node(dx,dy,dir,nextCost));
                }

            }

        }

        return min_cost;

    }

    public static class Node{

        int x,y,dir,cost;

        public Node(int x, int y, int dir, int cost){

            this.x=x;
            this.y=y;
            this.dir=dir;
            this.cost=cost;

        }

    }

}
