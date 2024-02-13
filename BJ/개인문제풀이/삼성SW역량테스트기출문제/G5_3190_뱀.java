package BJ.개인문제풀이.삼성SW역량테스트기출문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Locale;

public class G5_3190_뱀 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int boardSize = Integer.parseInt(br.readLine());
        String[][] board = new String[boardSize][boardSize];

        for(int i=0; i<boardSize; i++){
            Arrays.fill(board[i],"");
        }

        int apple = Integer.parseInt(br.readLine());

        for(int i=0; i<apple; i++){
            String[] appleLocation = br.readLine().split(" ");
            int row = Integer.parseInt(appleLocation[0]) -1;
            int col = Integer.parseInt(appleLocation[1]) -1;
            board[row][col] = "apple";
        }

        int commandCount = Integer.parseInt(br.readLine());

        // 방향전환 명령을 저장 할 List 생성 후 List에 명령 저장
        LinkedList<String[]> commands = new LinkedList<>();
        for(int i=0; i<commandCount; i++){
            commands.add(br.readLine().split(" "));
        }

        int time=0;

        // 보드판 매열에서의 상하좌우 움직임에 사용할 배열
        int[] moveR = {0,1,0,-1};
        int[] moveC = {1,0,-1,0};

        // 뱀의 머리 위치 저장할 변수
        Location head = new Location(0,0,0);
        // 꼬리
        Location tail = new Location(0,0,0);

        // 꼬리가 방향전환을 할 시점으 저장 한 List 생성
        LinkedList<Location> tailDirections = new LinkedList<>();

        // 뱀의 처음 시작위치 x로 초기화(뱀의 이동경로는 모두 x로 표기)
        board[0][0] = "X";

        // 게임 시작
        while(true){
            time++;

            // 사과 먹었는지 표현하는 변수
            boolean appleEat = false;

            // 현재 뱀이 바라보고 있는 방향으로 1칸 이동한 위치 계산
            head.row = head.row+moveR[head.direction];
            head.column = head.column+moveC[head.direction];

            // 계산된 위치 보드판 벗어나거나 뱀의 몸통 닿았느지 체크
            if(head.row >= boardSize || head.row <0 || head.column >=boardSize || head.column<0 || board[head.row][head.column].equals("X")){
                break;
            }
            // 계산된 위치에 사과가 있으면 사과를 먹은 것을 표현
            if(board[head.row][head.column].equals("apple")){
                appleEat = true;
            }
            // 머리 1칸 이동
            board[head.row][head.column] = "X";

            // 방향전환 명령을 저장한 list가 비어있지 않으면
            if(commands.size() != 0){
                String[] command = commands.getFirst();

                // 명령을 실행할 시간과 현재 시간이 같다면
                if(command[0].equals(String.valueOf(time))){
                    if(command[1].equals("D")){
                        // 뱀의 머리가 바라보는 방향 시계방향으로 90도 회전
                        head.direction = head.direction+1 == 4 ? 0 : head.direction+1;
                    }
                    // 명령이 반시계 방향이라면
                    else{
                        head.direction = head.direction -1 == -1 ? 3: head.direction-1;
                    }
                    // 머리가 회전할 위치를 추후에 꼬리가 따라와 해당 위치에서 방향전환을 해야하므로
                    // 해당 위치를 꼬리가 탐색할 방향전환 list에 추가
                    tailDirections.add(new Location(head.row, head.column, head.direction));

                    // 수행한 방햐전환 명령 list에서 제거
                    commands.removeFirst();
                }
            }
            // 뱀이 사과를 먹었으면 꼬리는 가만히 있어야 하므로, 사과를 먹지 않았을 때만 로직수행
            if(!appleEat){
                // 현재 보드판에서 꼬리가 위치한 곳 빈문자열로 값 변경
                board[tail.row][tail.column] = "";

                tail.row = tail.row+moveR[tail.direction];
                tail.column = tail.column+moveC[tail.direction];

                // 머리가 방향전환을 한적이 있다면
                if(tailDirections.size() != 0){
                    // 시간순서대로 list에 저장되므로 list에서 제일 앞의 값 가져오기
                    Location temp = tailDirections.getFirst();

                    // 머리가 방향전환을 한 위치가 현재 꼬리가 이동한 위치와 같다면
                    if(tail.row == temp.row && tail.column == temp.column){
                        // 꼬리도 머리와 같은 방향으로 방향회전
                        tail.direction = temp.direction;

                        tailDirections.removeFirst();
                    }
                }

            }
            System.out.println(time);
        }
    }
    static class Location{
        int row;
        int column;
        int direction;

        public Location(int row, int column, int direction) {
            this.row = row;
            this.column = column;
            this.direction = direction;
        }
    }
}
