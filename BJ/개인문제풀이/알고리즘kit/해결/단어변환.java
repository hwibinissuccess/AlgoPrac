package BJ.개인문제풀이.알고리즘kit.해결;

public class 단어변환 {


    static boolean[] visit;
    static int ans;

    public int solution(String begin, String target, String[] words) {

        visit = new boolean[words.length];

        DFS(begin, target, words, 0);

        if(ans == 0){
            ans = 0;
        }

        return ans;

    }

    public static void DFS(String begin, String target, String[] words, int cnt){

        if(begin.equals(target)){
            ans = cnt;
            return;
        }

        for(int i=0; i<words.length; i++){

            if(visit[i]) continue;

            int k = 0;
            for(int j=0; j<begin.length(); j++){
                if(begin.charAt(j) == words[i].charAt(j)){
                    k++;
                }
            }

            if(k == begin.length()-1){
                visit[i] = true;
                DFS(words[i], target, words, cnt+1);
                visit[i] = false;
            }

        }

    }

}
