import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

/*
    BOJ 9375 패션왕 신해빈
    해빈이는 패션에 매우 민감해서 한번 입었던 옷들의 조합을 절대 다시 입지 않는다.
    예를 들어 오늘 해빈이가 안경, 코트, 상의, 신발을 입었다면, 다음날은 바지를 추가로 입거나 안경대신 렌즈를 착용하거나 해야한다.
    해빈이가 가진 의상들이 주어졌을때 과연 해빈이는 알몸이 아닌 상태로 며칠동안 밖에 돌아다닐 수 있을까?
 */

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++) {
            int M = Integer.parseInt(br.readLine());
            HashMap<String, ArrayList<String>> hs = new HashMap<>();
            for(int j = 0; j < M; j++) {

                String[] tmp = br.readLine().split(" ");

                String value = tmp[0];
                String key = tmp[1];

                ArrayList<String> ar;

                ar = hs.getOrDefault(key, new ArrayList<>());
                ar.add(value);
                hs.put(key, ar);
            }

            int answer = 1;

            for(String key : hs.keySet()) {
                answer *= hs.get(key).size() + 1;
            }


            sb.append(answer - 1).append("\n");
        }

        System.out.println(sb);
    }
}