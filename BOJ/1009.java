/*
 	BOJ 1009 분산처리

    문제
    재용이는 최신 컴퓨터 10대를 가지고 있다. 어느 날 재용이는 많은 데이터를 처리해야 될 일이 생겨서 각 컴퓨터에 1번부터 10번까지의 번호를 부여하고,
    10대의 컴퓨터가 다음과 같은 방법으로 데이터들을 처리하기로 하였다.

    1번 데이터는 1번 컴퓨터, 2번 데이터는 2번 컴퓨터,
    3번 데이터는 3번 컴퓨터, ... ,

    10번 데이터는 10번 컴퓨터, 11번 데이터는 1번 컴퓨터, 1
    2번 데이터는 2번 컴퓨터, ...

    총 데이터의 개수는 항상 ab개의 형태로 주어진다.
    재용이는 문득 마지막 데이터가 처리될 컴퓨터의 번호가 궁금해졌다. 이를 수행해주는 프로그램을 작성하라.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int count = 1;
            for (int j = 1; j <= b; j++) {
                count *= a;
                if(count >= 10) {
                    count %= 10;
                }
                if(count == 0) {
                    count = 10;
                    break;
                }
            }
            System.out.println(count);
        }
    }
}