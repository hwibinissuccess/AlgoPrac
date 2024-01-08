package BJ.유니온파인드;

import java.util.Scanner;

public class G5_1976_여행계획짜기 {

    public static int[] parent;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] dosi = new int[N+1][N+1];
        for(int i=1; i<=N; i++){ // 도시 연결 데이터 저장
            for(int j=1; j<=N; j++){
                dosi[i][j] = sc.nextInt();
            }
        }
        int[] route = new int[M+1];
        for(int i=1; i<=M; i++){ // 여행 도시 정보 저장
            route[i] = sc.nextInt();
        }
        parent = new int[N+1];
        for(int i=1; i<=N; i++){ // 대표 노드를 자기 자신으로 초기화
            parent[i] = i;
        }
        for(int i=1; i<=N; i++){ // 인접 행렬에서 도시가 연결되어 있으면 union 실행
            for(int j=1; j<=N; j++){
                if(dosi[i][j] == 1) union(i,j);
            }
        }
        // 여행 계획 도시들이 1개의 대표 도시로 연결되어 있는지 확인하기
        int index = find(route[1]);
        for(int i=2; i<route.length;i++){
            if(index != find(route[i])){
                System.out.println("No");
                return;
            }
        }
        System.out.println("YES");
    }
    public static void union(int a, int b){ // union : 대표 노드끼리 연결하기
        a = find(a);
        b=find(b);
        if(a != b){
            parent[b]=a;
        }
    }

    public static int find(int a){
        if(a==parent[a])
            return a;
        else
            return parent[a]=find(parent[a]);
    }

}
