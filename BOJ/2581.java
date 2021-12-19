/*
 	BOJ 2581 소수

    문제
    자연수 M과 N이 주어질 때 M이상 N이하의 자연수 중 소수인 것을 모두 골라 이들 소수의 합과 최솟값을 찾는 프로그램을 작성하시오.
    예를 들어 M=60, N=100인 경우 60이상 100이하의 자연수 중 소수는
    61, 67, 71, 73, 79, 83, 89, 97 총 8개가 있으므로, 이들 소수의 합은 620이고, 최솟값은 61이 된다.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


// 1은 소수에 들어가지 않으니 유의
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int M = Integer.parseInt(br.readLine()); // 최소값
        int N = Integer.parseInt(br.readLine()); // 최대값
        int result = 0; // 결과값
        int[] iArr = new int[N+1]; // 0 ~ N
        int min = N;

        for (int i = M; i <= N; i++) {
            int count = 0;
            for (int j = 2; j <= i; j++) { // 1은 소수가 아니라 나눠봤자 의미가 없으므로 2부터 반복문 실행
                if (i % j == 0) { // 나머지가 0이라면, 해당 i 의 약수라는 의미이므로 카운트 증가
                    count++;
                }
            }
            if (count == 1) { // 카운트가 0이라면 그 값이 1이라는 뜻이고, 1이 넘어간다면 소수가 아니라는 의미
                iArr[i] = 1; // 카운트가 1이면 소수이므로 배열 값 증가
            }
        }

        for (int k = 0; k < iArr.length; k++) {
            if (iArr[k] == 1) {
                result += k;
                if (min > k) {
                    min = k;
                }
            }
        }

        if (result == 0) { // 소수가 없다는 의미이므로 -1 출력
            sb.append(-1);
        } else {
            sb.append(result).append("\n").append(min);
        }

        System.out.println(sb);
    }
}