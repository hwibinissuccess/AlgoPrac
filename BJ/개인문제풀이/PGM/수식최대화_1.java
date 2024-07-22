package BJ.개인문제풀이.PGM;

import java.util.ArrayList;

public class 수식최대화_1 {

    public long solution(String expression) {

        long ans = Long.MIN_VALUE;
        String op[][] = {{"+","-","*"},{"+","*","-"},{"-","+","*"},{"-","*","+"},
                {"*","+","-"},{"*","-","+"}};
        ArrayList<String> list = new ArrayList<>();
        int start = 0;
        for(int i=0; i<expression.length(); i++){
            if(expression.charAt(i) == '-' || expression.charAt(i) == '+' ||
                    expression.charAt(i) == '*'){
                list.add(expression.substring(start, i));
                list.add(expression.charAt(i)+"");
                start = i+1;
            }
        }

        list.add(expression.substring(start));

        for(int i=0; i<op.length; i++){
            ArrayList<String> sub_list = new ArrayList<String>(list);
            for(int k=0; k<3; k++){
                for(int j=0; j<sub_list.size(); j++){
                    if(op[i][k].equals(sub_list.get(j))){
                        sub_list.set(j-1, calc(sub_list.get(j-1), sub_list.get(j),
                                sub_list.get(j+1)));
                        sub_list.remove(j);
                        sub_list.remove(j);
                        j--;
                    }
                }
            }

            ans = Math.max(ans, Math.abs(Long.parseLong(sub_list.get(0))));
        }

        return ans;
    }

    public static String calc(String num1, String op, String num2){

        long n1 = Long.parseLong(num1);
        long n2 = Long.parseLong(num2);

        if(op.equals("+"))
            return n1+n2+"";
        else if(op.equals("-"))
            return n1-n2+"";

        return n1*n2+"";
    }
}
