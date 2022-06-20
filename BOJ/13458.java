import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    BOJ 13458 시험 감독
    총 N개의 시험장이 있고, 각각의 시험장마다 응시자들이 있다. i번 시험장에 있는 응시자의 수는 Ai명이다.
    감독관은 총감독관과 부감독관으로 두 종류가 있다. 총감독관은 한 시험장에서 감시할 수 있는 응시자의 수가 B명이고, 부감독관은 한 시험장에서 감시할 수 있는 응시자의 수가 C명이다.
    각각의 시험장에 총감독관은 오직 1명만 있어야 하고, 부감독관은 여러 명 있어도 된다.
    각 시험장마다 응시생들을 모두 감시해야 한다. 이때, 필요한 감독관 수의 최솟값을 구하는 프로그램을 작성하시오.
 */

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        long answer = 0;

        int N = Integer.parseInt(br.readLine());
        int[] students = new int[N];

        String[] tmp = br.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            students[i] = Integer.parseInt(tmp[i]);
        }

        tmp = br.readLine().split(" ");
        int B = Integer.parseInt(tmp[0]);
        int C = Integer.parseInt(tmp[1]);

        for (int i = 0; i < N; i++) {
            answer++;
            students[i] -= B;
        }

        for (int i = 0; i < N; i++) {
            if(students[i] > 0) {
                if (students[i] % C > 0) {
                    answer += students[i] / C + 1;
                } else {
                    answer += students[i] / C;
                }
            }
        }

        sb.append(answer);
        System.out.println(sb);
    }
}