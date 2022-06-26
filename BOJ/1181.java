import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

/*
    BOJ 1181 단어 정렬
    알파벳 소문자로 이루어진 N개의 단어가 들어오면 아래와 같은 조건에 따라 정렬하는 프로그램을 작성하시오.
    1. 길이가 짧은 것부터
    2. 길이가 같으면 사전 순으로
*/

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        String[] s = new String[N];

        for (int i = 0; i < N; i++) {
            s[i] = br.readLine();
        }

        Arrays.sort(s, new Comparator<String>() {
            public int compare(String s1, String s2) {
                if (s1.length() == s2.length()) {
                    return s1.compareTo(s2);
                }
                else {
                    return s1.length() - s2.length();
                }
            }
        });


        for (int i = 0; i < N; i++) {
            if(i != 0) {
                if(s[i].equals(s[i - 1])) {
                    continue;
                }
            }
            sb.append(s[i]).append("\n");
        }

        System.out.println(sb);
    }
}