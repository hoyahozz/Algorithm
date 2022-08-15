import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    BOJ 3036 링
    상근이는 창고에서 링 N개를 발견했다. 상근이는 각각의 링이 앞에 있는 링과 뒤에 있는 링과 접하도록 바닥에 내려놓았다.
    상근이는 첫 번째 링을 돌리기 시작했고, 나머지 링도 같이 돌아간다는 사실을 발견했다.
    나머지 링은 첫 번째 링 보다 빠르게 돌아가기도 했고, 느리게 돌아가기도 했다. 이렇게 링을 돌리다 보니 첫 번째 링을 한 바퀴 돌리면, 나머지 링은 몇 바퀴 도는지 궁금해졌다.
    링의 반지름이 주어진다. 이때, 첫 번째 링을 한 바퀴 돌리면, 나머지 링은 몇 바퀴 돌아가는지 구하는 프로그램을 작성하시오.
 */

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        String[] tmp = br.readLine().split(" ");

        int[] values = new int[tmp.length];

        for(int i = 0; i < tmp.length; i++) {
            values[i] = Integer.parseInt(tmp[i]);
        }

        for(int i = 1; i < tmp.length; i++) {
            int deno = values[0];
            int value = values[i];

            for(int j = 1; j <= value; j++) {
                if(value % j == 0 && deno % j == 0) {
                    value /= j;
                    deno /= j;
                    j = 1;
                }
            }

            sb.append(deno).append("/").append(value).append("\n");
        }

        System.out.println(sb);
    }
}