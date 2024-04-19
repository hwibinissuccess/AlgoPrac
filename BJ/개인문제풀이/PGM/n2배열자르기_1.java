package BJ.개인문제풀이.PGM;

import java.util.ArrayList;
import java.util.List;

public class n2배열자르기_1 {

    public List<Long> solution(int n, long left, long right) {

        List<Long> list = new ArrayList<>();

        for(long i=left; i<right+1; i++){

            list.add(Math.max(i/n,i%n)+1);

        }

        return list;

    }

}
