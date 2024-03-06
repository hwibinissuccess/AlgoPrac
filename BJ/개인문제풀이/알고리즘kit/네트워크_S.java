package BJ.개인문제풀이.알고리즘kit;

public class 네트워크_S {

    public int solution(int n, int[][] computers) {

        int ans = 0;
        boolean[] check = new boolean[n];

        for(int i=0; i<n; i++){
            if(!check[i]){
                DFS(computers, i, check);
                ans++;
            }
        }
        return ans;
    }
    boolean[] DFS(int[][] computers, int i, boolean[] check){
        check[i] = true;

        for(int j=0; j<computers.length; j++){
            if(i != j && computers[i][j] == 1 && check[j] == false){
                check = DFS(computers, j, check);
            }
        }
        return check;

    }

}
