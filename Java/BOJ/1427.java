import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    BOJ 2751 소트인사이드
    배열을 정렬하는 것은 쉽다. 수가 주어지면, 그 수의 각 자리수를 내림차순으로 정렬해보자.
 */

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String N = br.readLine();
        String[] change = N.split("");
        int[] value = new int[change.length];

        for(int i = 0; i < change.length; i++) {
            value[i] = Integer.parseInt(change[i]);
        }

        for(int i = 0; i < value.length - 1; i++) {
            for(int j = i + 1; j < value.length; j++) {
                if(value[i] < value[j]) {
                    int tmp = value[i];
                    value[i] = value[j];
                    value[j] = tmp;
                }
            }
        }

        for(int result : value) {
            sb.append(result);
        }

        System.out.println(sb);
    }
}