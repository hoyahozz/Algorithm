/*
 	BOJ 2775번 부녀회장이 될테야

    문제
    평소 반상회에 참석하는 것을 좋아하는 주희는 이번 기회에 부녀회장이 되고 싶어 각 층의 사람들을 불러 모아 반상회를 주최하려고 한다.
    이 아파트에 거주를 하려면 조건이 있는데, “a층의 b호에 살려면 자신의 아래(a-1)층의 1호부터 b호까지 사람들의 수의 합만큼 사람들을 데려와 살아야 한다” 는 계약 조항을 꼭 지키고 들어와야 한다.

    아파트에 비어있는 집은 없고 모든 거주민들이 이 계약 조건을 지키고 왔다고 가정했을 때, 주어지는 양의 정수 k와 n에 대해 k층에 n호에는 몇 명이 살고 있는지 출력하라.
    단, 아파트에는 0층부터 있고 각층에는 1호부터 있으며, 0층의 i호에는 i명이 산다.
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[][] apt = new int[15][15]; // 아파트의 수를 표시할 2차원 배열

        for(int i = 0; i < 15; i++) {
            apt[i][1] = 1; // 층마다 1호는 1로 값 설정
            apt[0][i] = i; // 0층은 1씩 늘어나게 설정 (0,1,2,3,4,5 . . .)
        }
        for(int i = 1; i < 15; i++) { // 층수
            for(int j = 2; j < 15; j++) { // 호수
                apt[i][j] = apt[i-1][j] + apt[i][j-1];
                // 해당 층의 이전 호의 인원과, 아래층 해당 호의 인원을 더하면 현재 층, 호의 인원수 값이 나옴
            }
        }

        for (int t = 0; t < T; t++) {
            int K = Integer.parseInt(br.readLine()); // 몇 층인지
            int N = Integer.parseInt(br.readLine()); // 몇 호인지
            System.out.println(apt[K][N]);
        }
    }
}