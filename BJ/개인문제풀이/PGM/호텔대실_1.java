package BJ.개인문제풀이.PGM;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class 호텔대실_1 {

    public int solution(String[][] book_time) {

        int ans = 0;
        int[][] bookTime = new int[book_time.length][2];

        for(int i=0; i<book_time.length; i++){
            int start = Integer.parseInt(book_time[i][0].replace(":",""));
            int end = Integer.parseInt(book_time[i][1].replace(":",""));

            end += 10;

            if(end%100 >= 60){
                end += 40;
            }

            bookTime[i][0] = start;
            bookTime[i][1] = end;
        }

        Arrays.sort(bookTime, (a1, a2) -> {
            return a1[0]-a2[0];
        });

        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));

        for(int[] book : bookTime){

            if(q.isEmpty()){
                q.add(book);
            } else{
                int[] temp = q.peek();
                int start = temp[0];
                int end = temp[1];

                if(book[0] >= end){
                    q.poll();
                }

                q.add(book);
            }
        }

        return q.size();
    }
}
