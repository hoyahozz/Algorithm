/*
 	BOJ 4153 직각삼각형

    문제
    과거 이집트인들은 각 변들의 길이가 3, 4, 5인 삼각형이 직각 삼각형인것을 알아냈다. 주어진 세변의 길이로 삼각형이 직각인지 아닌지 구분하시오.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int max = a;

            if(a == 0 && b == 0 && c == 0) {
                return;
            }

            if (b > max) {
                max = b;
            }

            if (c > max) {
                max = c;
            }

            if(max == a) {
                if((b * b) + (c * c) == (a * a)) {
                    System.out.println("right");
                } else {
                    System.out.println("wrong");
                }
            } else if(max == b) {
                if((a * a) + (c * c) == (b * b)) {
                    System.out.println("right");
                } else {
                    System.out.println("wrong");
                }
            } else {
                if((a * a) + (b * b) == (c * c)) {
                    System.out.println("right");
                } else {
                    System.out.println("wrong");
                }
            }
        }
    }
}
