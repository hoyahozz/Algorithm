/*
 	BOJ 4948 베르트랑 공준

    문제
    베르트랑 공준은 임의의 자연수 n에 대하여, n보다 크고, 2n보다 작거나 같은 소수는 적어도 하나 존재한다는 내용을 담고 있다.
    이 명제는 조제프 베르트랑이 1845년에 추측했고, 파프누티 체비쇼프가 1850년에 증명했다.
    예를 들어, 10보다 크고, 20보다 작거나 같은 소수는 4개가 있다.
    (11, 13, 17, 19) 또, 14보다 크고, 28보다 작거나 같은 소수는 3개가 있다. (17,19, 23)
    자연수 n이 주어졌을 때, n보다 크고, 2n보다 작거나 같은 소수의 개수를 구하는 프로그램을 작성하시오.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 에라토스테네스의 체를 이용하여 풀지 않으면 시간 초과 걸림.
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int value = Integer.parseInt(br.readLine());

        while(value != 0) {
            boolean[] arr = new boolean[(value*2) + 1]; // 소수인지 판단하는 배열

            if(value*2 < 2) return; // 최대값이 2 이하이면 소수가 존재하지 않으므로 바로 프로그램 종료

            for(int i = 2; i <= Math.sqrt(value*2); i++) {
                if(arr[i]) {  // 배수의 첫 값이 들어있으면 pass (이미 한번씩 돌았다는 뜻임)
                    continue;
                }
                for(int j = i*i; j <= value*2; j+=i) { // i의 배수에 true 를 넣음. 이는 곧 소수가 아니라는 의미임.
                    arr[j] = true;
                }
            }

            int count = 0;
            for(int k = 0; k <= value*2; k++) {
                if(!arr[k] && k > value && k > 1) { // 소수가 아니고, M과 1보다 큰 배열의 값만 출력한다.
                    count++;
                }
            }

            System.out.println(count);
            value = Integer.parseInt(br.readLine());
        }
    }
}