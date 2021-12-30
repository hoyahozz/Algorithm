/*
 	BOJ 7568 덩치

    문제
    우리는 사람의 덩치를 키와 몸무게, 이 두 개의 값으로 표현하여 그 등수를 매겨보려고 한다.
    어떤 사람의 몸무게가 x kg이고 키가 y cm라면 이 사람의 덩치는 (x, y)로 표시된다.
    두 사람 A 와 B의 덩치가 각각 (x, y), (p, q)라고 할 때 x > p 그리고 y > q 이라면 우리는 A의 덩치가 B의 덩치보다 "더 크다"고 말한다.
    예를 들어 어떤 A, B 두 사람의 덩치가 각각 (56, 177), (45, 165) 라고 한다면 A의 덩치가 B보다 큰 셈이 된다.
    그런데 서로 다른 덩치끼리 크기를 정할 수 없는 경우도 있다.
    예를 들어 두 사람 C와 D의 덩치가 각각 (45, 181), (55, 173)이라면 몸무게는 D가 C보다 더 무겁고,
    키는 C가 더 크므로, "덩치"로만 볼 때 C와 D는 누구도 상대방보다 더 크다고 말할 수 없다.

    N명의 집단에서 각 사람의 덩치 등수는 자신보다 더 "큰 덩치"의 사람의 수로 정해진다.
    만일 자신보다 더 큰 덩치의 사람이 k명이라면 그 사람의 덩치 등수는 k+1이 된다.
    이렇게 등수를 결정하면 같은 덩치 등수를 가진 사람은 여러 명도 가능하다.
    아래는 5명으로 이루어진 집단에서 각 사람의 덩치와 그 등수가 표시된 표이다.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];

        // N만큼 반복문 실행
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()); // 키
            int y = Integer.parseInt(st.nextToken()); // 몸무게

            // 배열에 넣기
            arr[i][0] = x;
            arr[i][1] = y;
        }

        for (int j = 0; j < N; j++) {
            int rank = 1;
            for(int k = 0; k < N; k++) { // 어차피 본인의 값보다 작을 순 없으므로 아래의 조건문을 사용한다.
                if(arr[j][0] < arr[k][0] && arr[j][1] < arr[k][1]) { // 키, 몸무게 모두 작으면 순위가 낮아짐
                    rank++;
                }
            }
            sb.append(rank).append(" ");
        }

        System.out.println(sb);
    }
}