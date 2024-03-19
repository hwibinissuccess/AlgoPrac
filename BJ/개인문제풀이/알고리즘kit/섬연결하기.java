package BJ.개인문제풀이.알고리즘kit;

import java.util.Arrays;

public class 섬연결하기 {


    static int[] parent;

    public int solution(int n, int[][] costs) {

        int ans = 0;
        parent = new int[n];

        for(int i=0; i<n; i++){
            parent[i] = i;
        }

        Arrays.sort(costs, (o1, o2) -> o1[2]-o2[2]);

        for(int i=0; i<costs.length; i++){
            if(find(costs[i][0]) != find(costs[i][1])){
                union(costs[i][0], costs[i][1]);

                ans += costs[i][2];
            }
        }

        return ans;

    }

    static int find(int a){
        if(parent[a] == a) return a;
        else return parent[a] = find(parent[a]);
    }

    static void union(int a, int b){
        a = find(a);
        b = find(b);
        if(a != b){
            parent[b] = a;
        }
    }


}
