/*
 	BOJ 1085 직사각형에서 탈출

    문제
    한수는 지금 (x, y)에 있다. 직사각형은 각 변이 좌표축에 평행하고, 왼쪽 아래 꼭짓점은 (0, 0), 오른쪽 위 꼭짓점은 (w, h)에 있다.
    직사각형의 경계선까지 가는 거리의 최솟값을 구하는 프로그램을 작성하시오.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        // 한수의 위치 x, y
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        // 오른쪽 끝대각선 w, h
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int[] arr = {x, y, w-x, h-y};

        // w - x -> x 라인의 경계선
        // h - y -> y 라인의 경계선

        int min = 999999;
        for(int i = 0; i < 4; i++) {
            if(min > arr[i]) {
                min = arr[i];
            }
        }
        System.out.println(min);
    }
}