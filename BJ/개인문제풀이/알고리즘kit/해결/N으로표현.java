package BJ.개인문제풀이.알고리즘kit.해결;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class N으로표현 {

    public int solution(int N, int number) {
        List<Set<Integer>> cntList = new ArrayList<>();

        for(int i=0; i<9; i++){
            cntList.add(new HashSet<>());
        }

        cntList.get(1).add(N);

        for(int i=2; i<9; i++){
            Set<Integer> cntSet = cntList.get(i);
            for(int j=1; j<=i; j++){
                Set<Integer> preSet = cntList.get(j);
                Set<Integer> postSet = cntList.get(i-j);

                for(int preNum : preSet){
                    for(int postNum : postSet){
                        cntSet.add(preNum+postNum);
                        cntSet.add(preNum-postNum);
                        cntSet.add(preNum*postNum);

                        if(preNum != 0 && postNum != 0){
                            cntSet.add(preNum/postNum);
                        }
                    }
                }
            }
            cntSet.add(Integer.parseInt(String.valueOf(N).repeat(i)));
        }

        for(Set<Integer> ans : cntList){
            if(ans.contains(number)){
                return cntList.indexOf(ans);
            }
        }
        return -1;


    }

}
