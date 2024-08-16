package BJ.개인문제풀이.PGM;

import java.util.ArrayList;
import java.util.HashSet;

public class 후보키_1 {



    static boolean[] result;
    static int col;
    static int row;
    static int ans = 0;
    static String[][] relationCopy;
    // 재귀에서 이전 후보키의 조합들
    static ArrayList<HashSet<Integer>> prevCandidateCols = new ArrayList<>();

    public int solution(String[][] relation) {

        col = relation[0].length;
        row = relation.length;
        result = new boolean[col];
        relationCopy = relation;


        // 열의 부분집합을 구해 해당 부분집합에 해당되는 열의 조합이 후보키가 될 수 있는지 검사
        subset(0);

        return ans;
    }

    public static void subset(int idx){
        if(idx >= col){ // 열의 부분집합 끝
            if(isCandidate()){ // 후보키인지 검사
                ans++;
            }
            return;
        }

        result[idx] = false; // false로 시작해 최소성 보장
        subset(idx+1);
        result[idx] = true;
        subset(idx+1);
    }

    // result 배열에 포함된 열의 조합이 후보키가 될 수 있는지 검사
    public static boolean isCandidate(){
        HashSet<String> tupleStr = new HashSet<>(); // result에 따라 합체된 문자열 ex) 100ryan, concomputer

        // 결과에 따라 문자열 합쳐보기
        for(int i=0; i<row; i++){
            String temp = "";
            for(int j=0; j<col; j++){
                if(!result[j]) continue; // result[j]가 false면 열의 조합에서 제외
                temp += relationCopy[i][j];
            }
            tupleStr.add(temp);
        }

        // 중복검사
        if(tupleStr.size() == row){ // 조합 완료된 문자열을 set에 넣었는데 row의 길이 그대로라면 중복 없음
            if(isMinimal()){
                return true;
            }
        }
        return false;
    }

    // 현재 열 조합(set)과 이전의 후보키를 만든 열 조합(set)끼리 부분지합 연산하여 최소성 검사
    public static boolean isMinimal(){
        // result에서 true인 열의 인덱스를 set으로 만듬
        HashSet<Integer> nowCols = new HashSet<>();
        for(int i=0; i<col; i++){
            if(result[i]) nowCols.add(i);
        }

        // 만약 현재 열 조합이 이전 열 조합을 포함한다면 최소성을 성립하지못함 ex) 2,3,4에 2,3에 포함되면 안됨
        for(HashSet set : prevCandidateCols)
            if(nowCols.containsAll(set)){
                return false;
            }

        prevCandidateCols.add(new HashSet<>(nowCols));
        return true;

    }
}
