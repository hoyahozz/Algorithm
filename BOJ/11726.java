import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    BOJ 11726 2xn 타일링
    2×n 크기의 직사각형을 1×2, 2×1 타일로 채우는 방법의 수를 구하는 프로그램을 작성하시오.
    아래 그림은 2×5 크기의 직사각형을 채운 한 가지 방법의 예이다.
    첫째 줄에 2×n 크기의 직사각형을 채우는 방법의 수를 10,007로 나눈 나머지를 출력한다.
*/

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine()) + 2;

        int[] pivo = new int[N];
        pivo[0] = 0;
        pivo[1] = 1;

        for(int i = 2; i < N; i++) {
            pivo[i] = (pivo[i - 2] + pivo[i - 1]) % 10007;
        }

        System.out.println(pivo[N - 1]);
    }
}