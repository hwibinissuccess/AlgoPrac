package BJ.개인문제풀이.알고리즘kit.해결;

import java.util.LinkedList;
import java.util.Queue;

public class 다리를지나는트럭 {

    public int solution(int bridge_length, int weight, int[] truck_weights) {

        int time = 0;
        int sum = 0;
        Queue<Integer> q = new LinkedList<>();

        for(int i=0; i<truck_weights.length; i++){

            int truck = truck_weights[i];

            while(true){

                if(q.isEmpty()){
                    q.add(truck);
                    time++;
                    sum += truck;
                    break;
                } else if(bridge_length == q.size()){
                    sum -= q.poll();
                } else{
                    if(sum+truck > weight){
                        q.add(0);
                        time++;
                    } else{
                        q.add(truck);
                        time++;
                        sum += truck;
                        break;
                    }
                }

            }

        }

        return time+bridge_length;

    }

}
