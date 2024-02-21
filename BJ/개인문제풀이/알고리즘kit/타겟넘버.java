package BJ.개인문제풀이.알고리즘kit;

public class 타겟넘버 {


    int cnt = 0;

    public int solution(int[] numbers, int target) {

        int ans = 0;
        DFS(numbers, 0, target, 0);
        ans = cnt;

        return ans;

    }

    public void DFS(int[] numbers, int depth, int target, int result){
        if(depth == numbers.length){
            if(target == result){
                cnt++;
            }
            return;
        }

        int plus = result + numbers[depth];
        int minus = result - numbers[depth];

        DFS(numbers, depth+1, target, plus);
        DFS(numbers, depth+1, target, minus);

    }


}
