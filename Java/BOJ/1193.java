/*
 	BOJ 1193번 분수찾기

	문제
    이와 같이 나열된 분수들을 1/1 → 1/2 → 2/1 → 3/1 → 2/2 → … 과 같은 지그재그 순서로 차례대로 1번, 2번, 3번, 4번, 5번, … 분수라고 하자.
    X가 주어졌을 때, X번째 분수를 구하는 프로그램을 작성하시오.
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = 1;
        int x = 0, y = 0;
        int mode = 0; // 대각선 아래로 내려가는지, 위로 올라가는지 체크하는 변수

        while(count < n) {
            if(mode == 0) { // 오른대각선으로 올라갈 때
                if(x == 0) { // x가 0이면 맨 위로 왔다는 이야기이므로, y값을 증가시키고 모드 변경
                    y++;
                    count++;
                    mode = 1;
                } else { // 0이 아니라면 오른대각선으로 계속해서 올라간다.
                    x--;
                    y++;
                    count++;
                }
            } else { // 왼대각선으로 내려갈 때
                if (y == 0) {  // y가 0이면 왼쪽 끝으로 왔다는 이야기이므로, x값을 증가시키고 모드 변경
                    x++;
                    count++;
                    mode = 0;
                } else { // 0이 아니라면 왼대각선으로 계속해서 내려간다.
                    x++;
                    y--;
                    count++;
                }
            }
        }
        System.out.println((x+1) + "/" + (y+1));
    }
}