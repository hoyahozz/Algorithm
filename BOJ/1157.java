/*
 	BOJ 1157번 단어 공부

	문제
    알파벳 대소문자로 된 단어가 주어지면, 이 단어에서 가장 많이 사용된 알파벳이 무엇인지 알아내는 프로그램을 작성하시오.
    단, 대문자와 소문자를 구분하지 않는다.
*/


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 'a' -> 97, 'A' -> 65, 'Z' -> 90

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String s = br.readLine();
        int[] count = new int[26];
        int iMax = 0;
        int max = -1;

        for (int i = 0; i < s.length(); i++) {
            for (int j = 'A'; j <= 'Z'; j++) {
                int alpha = s.charAt(i);
                if (alpha > 90) { // LowerCase 소문자일 때 대문자로 변경
                    alpha -= 32; // to UpperCase
                }

                if (alpha == j) {
                    count[j - 65]++; // 해당 알파벳 자리의 카운트 증가
                }
            }
        }

        for (int k = 0; k < count.length; k++) {
            if (count[k] > max) {
                max = count[k]; // 실제 값
                iMax = k; // 배열 인덱스의 값
            }
        }
        for (int m = 0; m < count.length; m++) {
            if (iMax != m && max == count[m]) { // 다른 인덱스에서 맥스값이 발견되면 중복된다는 의미
                System.out.println("?");
                return;
            }
        }
        sb.append((char)(iMax + 65));
        System.out.println(sb);
    }
}
