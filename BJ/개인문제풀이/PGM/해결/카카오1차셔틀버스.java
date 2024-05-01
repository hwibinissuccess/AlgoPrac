package BJ.개인문제풀이.PGM.해결;

import java.util.PriorityQueue;

public class 카카오1차셔틀버스 {

    public String solution(int n, int t, int m, String[] timetable) {

        PriorityQueue<Integer> q = new PriorityQueue<>();

        for(String time : timetable){
            q.add(Integer.parseInt(time.substring(0,2))*60
                    + Integer.parseInt(time.substring(3)));
        }

        int start_time = 60*9;
        int ans = 0;
        int total = 0;

        for(int i=0; i<n; i++){

            total = 0;

            while(!q.isEmpty()){

                int cur = q.peek();

                if(cur<=start_time && total<m){
                    q.poll();
                    total++;
                } else break;

                ans = cur-1;

            }

            start_time += t;

        }

        if(total<m) ans = start_time-t;

        String hour = String.format("%02d",ans/60);
        String minute = String.format("%02d",ans%60);

        return hour+":"+minute;

    }

}
