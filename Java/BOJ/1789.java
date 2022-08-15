import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    BOJ 1789 수들의 합
    서로 다른 N개의 자연수의 합이 S라고 한다. S를 알 때, 자연수 N의 최댓값은 얼마일까?
*/

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        long S = Long.parseLong(br.readLine());
        long sum = 0;
        int count = 1;

        while (true) {
            sum += count;

            if (sum > S) {
                break;
            }
            count++;
        }

        sb.append(count - 1);

        System.out.println(sb);
    }

    public static void BinarySearch(long S) {
        long low = 1;
        long high = S;

        while(low >= high) {
            long middle = (low + high) / 2;


        }
    }
}