/*
 	BOJ 1978 소수 찾기

    문제
    주어진 수 N개 중에서 소수가 몇 개인지 찾아서 출력하는 프로그램을 작성하시오.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


// 1은 소수에 들어가지 않으니 유의
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine()); // 몇번 실행할 것인지
        int result = 0; // 결과값

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++) {
            int value = Integer.parseInt(st.nextToken()); // 값 추출
            int count = 0;
            for(int j = 2; j <= value; j++) { // 1은 소수가 아니라 나눠봤자 의미가 없으므로 2부터 반복문 실행
                if(value % j == 0) { // 나머지가 0이라면, 해당 value의 약수라는 의미이므로 카운트 증가
                    count++;
                }
            }
            if(count == 1) { // 카운트가 0이라면 그 값이 1이라는 뜻이고, 1이 넘어간다면 소수가 아니라는 의미
                result++; // 소수인 경우에만 결과값 증가
            }
        }
        System.out.println(result);
    }

}