package BJ.개인문제풀이.알고리즘kit;

import java.util.HashSet;

public class 소수찾기 {


    static HashSet<Integer> set = new HashSet<>();
    static char[] arr;
    static boolean[] visit;

    public int solution(String numbers) {

        int ans = 0;
        arr = new char[numbers.length()];
        visit = new boolean[numbers.length()];

        for(int i=0; i<numbers.length(); i++){
            arr[i] = numbers.charAt(i);
        }

        DFS("",0);

        ans = set.size();
        return ans;

    }

    public void DFS(String str, int idx){
        int num;
        if(str != ""){
            num = Integer.parseInt(str);
            if(isPrime(num)) set.add(num);
        }

        if(idx == arr.length) return;

        for(int i=0; i<arr.length; i++){
            if(visit[i]) continue;
            visit[i] = true;

            DFS(str+arr[i], idx+1);

            visit[i] = false;
        }

    }

    public boolean isPrime(int num){
        if(num==0 || num==1) return false;

        for(int i=2; i*i<=num; i++){
            if(num%i == 0) return false;
        }
        return true;
    }

}
