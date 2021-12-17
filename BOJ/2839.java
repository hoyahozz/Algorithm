/*
 	BOJ 2839 설탕 배달

    문제
    상근이는 요즘 설탕공장에서 설탕을 배달하고 있다.
    상근이는 지금 사탕가게에 설탕을 정확하게 N킬로그램을 배달해야 한다.
    설탕공장에서 만드는 설탕은 봉지에 담겨져 있다. 봉지는 3킬로그램 봉지와 5킬로그램 봉지가 있다.

    상근이는 귀찮기 때문에, 최대한 적은 봉지를 들고 가려고 한다.
    예를 들어, 18킬로그램 설탕을 배달해야 할 때, 3킬로그램 봉지 6개를 가져가도 되지만,
    5킬로그램 3개와 3킬로그램 1개를 배달하면, 더 적은 개수의 봉지를 배달할 수 있다.

    상근이가 설탕을 정확하게 N킬로그램 배달해야 할 때,
    봉지 몇 개를 가져가면 되는지 그 수를 구하는 프로그램을 작성하시오.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int count = 0;

        while(true) {
            if(n % 5 == 0) {
                count += n / 5; // 몫만큼 더해줌
                break; // 5가 나눠지는 것이면 더 이상 값이 없을 것이므로 break
            }
            n -= 3; // 3을 계속해서 빼주며
            count ++; // 수를 올림

            if(n < 0) { // n이 0보다 작으면 정확하게 n킬로그램을 만들 수 없다는 뜻이므로
                count = -1; // -1 출력
                break;
            }
        }
        System.out.println(count);
    }
}