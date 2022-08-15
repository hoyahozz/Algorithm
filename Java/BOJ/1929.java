/*
 	BOJ 1929 소수 구하기

    문제
    M이상 N이하의 소수를 모두 출력하는 프로그램을 작성하시오.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 에라토스테네스의 체를 이용하여 풀지 않으면 시간 초과 걸림.
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int M = Integer.parseInt(st.nextToken()); // 최소값
        int N = Integer.parseInt(st.nextToken()); // 최대값
        boolean[] arr = new boolean[N + 1]; // 소수인지 판단하는 배열

        if(N < 2) return; // 최대값이 2 이하이면 소수가 존재하지 않으므로 바로 프로그램 종료

        for(int i = 2; i <= Math.sqrt(N); i++) {
            if(arr[i]) {  // 배수의 첫 값이 들어있으면 pass (이미 한번씩 돌았다는 뜻임)
                continue;
            }
            for(int j = i*i; j <= N; j+=i) { // i의 배수에 true 를 넣음. 이는 곧 소수가 아니라는 의미임.
                arr[j] = true;
            }
        }

        for(int k = 0; k <= N; k++) {
            if(!arr[k] && k >= M && k > 1) { // 소수가 아니고, M과 1보다 큰 배열의 값만 출력한다.
                System.out.println(k);
            }
        }
    }
}