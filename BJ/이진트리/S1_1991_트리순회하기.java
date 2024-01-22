package BJ.이진트리;

import java.util.Scanner;

public class S1_1991_트리순회하기 {
     static int[][] tree;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        tree = new int[26][2]; // 0 -> 왼쪽 자식 노드(1) -> 오른쪽 자식 노드(2)
        for(int i=0; i<n; i++){
            String[] temp = sc.nextLine().split(" ");
            int node = temp[0].charAt(0) - 'A'; // index로 변환하기 위해 A 문자 빼기
            char left = temp[1].charAt(0);
            char right = temp[2].charAt(0);
            // 자식 노드가 없을 때는 -1 wjwkd
            if(left == '.'){
                tree[node][0] = -1;
            } else{
                tree[node][0] = left-'A';
            }
            if (right == '.') {
                tree[node][1] = -1;
            } else {
                tree[node][1] = right-'A';
            }
        }
        preOrder(0);
        System.out.println();
        inOrder(0);
        System.out.println();
        postOrder(0);
        System.out.println();
    }
    public static void preOrder(int now){
        if(now == -1)
            return;
        System.out.println((char)(now+'A')); // 현재 노드
        preOrder(tree[now][0]); // 왼쪽 노드 탐색
        preOrder(tree[now][1]); // 오른쪽 노드 탐색
    }

    public static void inOrder(int now){
        if(now == -1)
            return;
        inOrder(tree[now][0]);
        System.out.println((char)(now+'A'));
        inOrder(tree[now][1]);
    }

    public static void postOrder(int now){
        if(now == -1)
            return;
        postOrder(tree[now][0]);
        postOrder(tree[now][1]);
        System.out.println((char)(now+'A'));
    }
}
