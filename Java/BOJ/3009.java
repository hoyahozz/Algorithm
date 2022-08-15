/*
 	BOJ 3009 네 번째 점

    문제
    세 점이 주어졌을 때, 축에 평행한 직사각형을 만들기 위해서 필요한 네 번째 점을 찾는 프로그램을 작성하시오.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[] x = new int[3];
        int[] y = new int[3];
        int resultX;
        int resultY;

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            x[i] = a;
            y[i] = b;
        }

        if (x[0] == x[1]) {
            resultX = x[2];
        } else if (x[0] == x[2]) {
            resultX = x[1];
        } else {
            resultX = x[0];
        }
        if (y[0] == y[1]) {
            resultY = y[2];
        } else if (y[0] == y[2]) {
            resultY = y[1];
        } else {
            resultY = y[0];
        }

        System.out.println(resultX + " " + resultY);
    }
}
