package BJ.개인문제풀이.PGM;

import java.util.ArrayList;

public class 연속된부분수열의합_1 {

    public int[] solution(int[] sequence, int k) {

        ArrayList<int[]> list = new ArrayList<>();
        int idx = 0;
        int len = sequence.length;
        int[] ans = new int[]{-1,-1};

        while(true){

            if(idx>=len) break;
            int sum = 0;

            for(int i=idx; i<len; i++){
                sum += sequence[i];
                if(sum >k) break;
                if(sum == k){
                    list.add(new int[]{idx, i});
                    //return new int[]{idx, i};
                    break;
                }
            }

            idx++;
        }

        if(list.size() == 1){
            int[] temp = list.get(0);
            ans[0] = temp[0];
            ans[1] = temp[1];
        }

        if (list.size() > 0) {
            ans[0] = list.get(0)[0];
            ans[1] = list.get(0)[1];
        }

        for(int i=1; i<list.size(); i++){

            int[] temp = list.get(i);
            int[] temp2 = ans;

            int currentLength = temp[1]-temp[0];
            int preLength = ans[1]-ans[0];

            if(preLength < currentLength) continue;
            if(currentLength < preLength){
                ans[0] = temp[0];
                ans[1] = temp[1];
            }
            if(currentLength == preLength){
                if(ans[0] < temp[0]) continue;
                else if(temp[0] < ans[0]){
                    ans[0] = temp[0];
                    ans[1] = temp[1];
                }
            }


        }

        return ans;
    }

}
