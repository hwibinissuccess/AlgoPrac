package BJ.개인문제풀이.BJ;

import java.util.*;
import java.io.*;

public class 수정렬하기2 {
    public static void main(String args[]) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        List<Integer> nums = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<t; i++){
            nums.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(nums);

        for(int val : nums){
            sb.append(val).append("\n");
        }

        System.out.println(sb);
    }
}
