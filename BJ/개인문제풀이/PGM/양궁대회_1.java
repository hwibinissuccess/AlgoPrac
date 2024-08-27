package BJ.개인문제풀이.PGM;

public class 양궁대회_1 {



    static int N, maxMinus;
    static int[] arr;
    static int[] ans = {-1};

    public int[] solution(int n, int[] info) {

        N = n;
        maxMinus = -1;
        arr = new int[11];
        DFS(info, 0,0);

        return ans;
    }
    // idx는 점수 0~10, cnt는 사용한 화살 수
    public static void DFS(int[] apeach, int idx, int cnt){
        if(idx==11){ // 점수 접근을 다 했다면,
            // 화살을 다 썼는지 확인하고 다 썼으면 점수 계산
            if(cnt==N){
                int apScore = 0, liScore=0;
                for(int i=0; i<11; i++){
                    if(apeach[i] == 0 && arr[i]==0) continue;
                    if(apeach[i] >= arr[i]) apScore += 10-i;
                    else liScore += 10-i;
                }

                if(liScore>apScore){
                    // 라이언이 가장 큰 차이로 이기는 경우
                    if(liScore-apScore > maxMinus){
                        maxMinus = liScore-apScore;
                        ans = arr.clone();
                    }
                    // 라이언이 가장 큰 점수 차이로 우승할 수 있는 방법이 여러 가지일 경우
                    else if(liScore-apScore == maxMinus){
                        for(int i=10; i>=0; i--){
                            if(ans[i] < arr[i]){
                                ans = arr.clone();
                                return;
                            }else if(ans[i] > arr[i]) return;
                        }
                    }
                }
            }
            return;
        }

        // 둘다 0으로 점수 받기 포기
        if(apeach[idx]==0){
            DFS(apeach, idx+1, cnt);
        }

        // 어피치 이기기
        if(cnt+1+apeach[idx] <= N){ // 현재까지 사용한 화살 수 +1에 어치피 화살 수를 더해도 전체 화살 수가 넘지 않는다면
            arr[idx] = apeach[idx]+1;
            DFS(apeach, idx+1, cnt+1+apeach[idx]);
            arr[idx] = 0;
        }

        // 어피치한테 지기
        if(apeach[idx] != 0){
            for(int i=0; i<=apeach[idx]; i++){
                arr[idx] = i;
                DFS(apeach, idx+1, cnt+i);
                arr[idx]=0;
            }
        }
    }
}
