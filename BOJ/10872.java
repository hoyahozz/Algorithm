/*
 	BOJ 10872번 팩토리얼

    문제
    0보다 크거나 같은 정수 N이 주어진다. 이때, N!을 출력하는 프로그램을 작성하시오.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int result = 1;

        if(N == 0) {
            System.out.println(1);
            return;
        }

        for(int i = 1; i <= N; i++) { // 반복문
            result *= i;
        }

        // result = pivot(N); // 재귀 함수

        System.out.println(result);

    }

    static int pivot(int value) {
        if(value == 1) return 1;

        return value * pivot(value - 1);
    }
}