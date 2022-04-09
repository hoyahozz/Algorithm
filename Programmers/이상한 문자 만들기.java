import java.util.*;

class Solution {
    public static void main(String[] args) {
        // 테스트 코드
        System.out.println(solution("Try  Hello   World   ASDZXC"));
    }

    public static String solution(String s) {

        String[] split = s.split("");
        StringBuilder answer = new StringBuilder();

        int count = 0;
        for (int i = 0; i < split.length; i++) {
            if (split[i].equals(" ")) {
                answer.append(" ");
                count = 0;
            } else {
                if (count % 2 != 0) {
                    answer.append(split[i].toLowerCase());
                } else {
                    answer.append(split[i].toUpperCase());
                }
                count++;
            }
        }

        return answer.toString();
    }
}