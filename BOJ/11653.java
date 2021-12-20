/*
 	BOJ 11653 소인수분해

    문제
    정수 N이 주어졌을 때, 소인수분해하는 프로그램을 작성하시오.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int value = Integer.parseInt(br.readLine()); // 소인수분해할 값
        int i = 2;

        while(i <= value) { // i가 값보다 작을 때까지 무한 반복
            if(value % i == 0) { // 나눠떨어지면 인수라는 의미임.
                System.out.println(i); // 출력
                value /= i; // 값을 i로 나눠주고
                continue; // 다시 반복문 진입
            }
            i++; // 나눠지지 않으면 더이상 인수가 아니라는 의미이므로 ++
        }
    }
}