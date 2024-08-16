package BJ.개인문제풀이.PGM;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class 과제진행하기_1 {


    public String[] solution(String[][] plansArr) {

        Plan[] plans = new Plan[plansArr.length];
        for(int i=0; i<plansArr.length; i++){
            plans[i] = new Plan(plansArr[i]);
        }
        Arrays.sort(plans, (a, b) -> a.start - b.start);

        Stack<Plan> stop = new Stack<>();
        List<String> ans = new ArrayList<>();

        for(int i=0; i<plans.length-1; i++){
            Plan curPlan = plans[i];
            Plan nextPlan = plans[i+1];

            if(curPlan.getEndTime() > nextPlan.start){
                curPlan.playTime = curPlan.getEndTime()-nextPlan.start;
                stop.push(curPlan);
                continue;
            }
            ans.add(curPlan.name);

            int restTime = nextPlan.start-curPlan.getEndTime();

            while(restTime>0 && !stop.isEmpty()){
                Plan stoppedPlan = stop.peek();
                int timeDiff = stoppedPlan.playTime - restTime;
                stoppedPlan.playTime = timeDiff;
                restTime = timeDiff*-1;
                if(timeDiff > 0) break;
                ans.add(stop.pop().name);
            }
        }

        ans.add(plans[plans.length-1].name);
        while(!stop.isEmpty()) ans.add(stop.pop().name);
        return ans.toArray(new String[ans.size()]);
    }
}

class Plan{

    String name;
    int start;
    int playTime;

    public Plan(String name, String start, String playTime){
        this.name = name;
        String[] time = start.split(":");
        this.start = Integer.parseInt(time[0])*60+Integer.parseInt(time[1]);
        this.playTime = Integer.parseInt(playTime);
    }

    public Plan(String[] plan){
        this(plan[0], plan[1], plan[2]);
    }

    public int getEndTime(){
        return start+playTime;
    }
}
