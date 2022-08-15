import java.util.*;

class Solution {
    public static void main(String[] args) {
        // 테스트 코드
        System.out.println(solution("XxYy", 25));
    }

    public static String solution(String s, int n) {

        char[] ch = s.toCharArray();

        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == 32) { // 공백이면 지나가기
                continue;
            }

            if(ch[i] >= 65 && ch[i] <= 90) { // 대문자일 때
                if((ch[i] + n) > 90) { // 90을 넘어가면 다시 'A'로
                    ch[i] -= 26;
                }
            } else if (ch[i] >= 97 && ch[i] <= 122) { // 소문자일 때
                if((ch[i] + n) > 122) { // 122를 넘어가면 다시 'a' 로
                    ch[i] -= 26;
                }
            }
            ch[i] += n;
        }

        return String.valueOf(ch);
    }
}