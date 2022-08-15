import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
    BOJ 11659 좌표 정렬하기
    2차원 평면 위의 점 N개가 주어진다. 좌표를 x좌표가 증가하는 순으로, x좌표가 같으면 y좌표가 증가하는 순서로 정렬한 다음 출력하는 프로그램을 작성하시오.
 */

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[][] value = new int[N][2];

        for(int i = 0; i < N; i++) {
            String[] val = br.readLine().split(" ");
            value[i][0] = Integer.parseInt(val[0]);
            value[i][1] = Integer.parseInt(val[1]);
        }

        Arrays.sort(value, (e1, e2) -> {
           if(e1[0] == e2[0]) {
               return e1[1] - e2[1];
           } else {
               return e1[0] - e2[0];
           }
        });

        for(int i = 0; i < N; i++) {
            sb.append(value[i][0]).append(" ").append(value[i][1]).append("\n");
        }

        System.out.println(sb);
    }
}