package BJ.개인문제풀이.PGM.해결;

public class 제일작은수제거하기 {

    public int[] solution(int[] arr) {

        if(arr.length == 1) return new int[]{-1};

        int[] ans = new int[arr.length-1];
        int minNum = Integer.MAX_VALUE;

        for(int i=0; i<arr.length; i++){
            minNum = Math.min(minNum, arr[i]);
        }
        int idx = 0;
        for(int i=0; i<arr.length; i++){

            if(arr[i] == minNum) continue;
            ans[idx] = arr[i];
            idx++;
        }

        return ans;
    }
}
