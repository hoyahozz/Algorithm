/*
 	BOJ 2231 분해합

    문제
    어떤 자연수 N이 있을 때, 그 자연수 N의 분해합은 N과 N을 이루는 각 자리수의 합을 의미한다.
    어떤 자연수 M의 분해합이 N인 경우, M을 N의 생성자라 한다. 예를 들어, 245의 분해합은 256(=245+2+4+5)이 된다.
    따라서 245는 256의 생성자가 된다. 물론, 어떤 자연수의 경우에는 생성자가 없을 수도 있다. 반대로, 생성자가 여러 개인 자연수도 있을 수 있다.

    자연수 N이 주어졌을 때, N의 가장 작은 생성자를 구해내는 프로그램을 작성하시오.

*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {
            int thisValue = i;
            int sum = i; // 기본적으로 전체값도 함께 더해주어야 하기 때문에 i로 초기화

            while(thisValue > 0) { // 각 자릿수별로 더해주기
                sum += thisValue % 10;
                thisValue /= 10;
            }

            if(sum == N) { // N과 같아지면 가장 작은 생성자이므로, 출력 후 리턴
                System.out.println(i);
                return;
            }
        }

        System.out.println(0); // N과 같은게 없다는 것은 생성자가 없다는 의미이므로 0 출력

    }
}