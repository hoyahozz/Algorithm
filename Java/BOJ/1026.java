import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

/*
    BOJ 1026 보물
    옛날 옛적에 수학이 항상 큰 골칫거리였던 나라가 있었다. 이 나라의 국왕 김지민은 다음과 같은 문제를 내고 큰 상금을 걸었다.
    길이가 N인 정수 배열 A와 B가 있다. 다음과 같이 함수 S를 정의하자.
    S = A[0] × B[0] + ... + A[N-1] × B[N-1]
    S의 값을 가장 작게 만들기 위해 A의 수를 재배열하자. 단, B에 있는 수는 재배열하면 안 된다.
    S의 최솟값을 출력하는 프로그램을 작성하시오.
*/

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        Integer[] B = new Integer[N];

        String[] tmp = br.readLine().split(" ");

        for(int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(tmp[i]);
        }

        tmp = br.readLine().split(" ");
        for(int i = 0; i < N; i++) {
            B[i] = Integer.parseInt(tmp[i]);
        }

        Arrays.sort(A);
        Arrays.sort(B, Collections.reverseOrder());

        int answer = 0;

        for(int i = 0; i < N; i++) {
            answer += A[i] * B[i];
        }

        sb.append(answer);

        System.out.println(sb);
    }
}