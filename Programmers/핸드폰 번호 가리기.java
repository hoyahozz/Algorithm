import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        // 테스트 코드
        System.out.println(solution("01012341234"));
    }

    public static String solution(String phone_number) {

        String answer = "";

        /* 정규식을 이용한 방법
         * String first = phone_number.substring(0, phone_number.length()-4).replaceAll("[0-9]", "*");
         * String second = phone_number.substring(phone_number.length()-4);
         * answer = first + second;
         */

        /*
         * for 문을 이용한 방법
         * for(int i = 0; i < phone_number.length()-4; i++) {
         *     answer += "*";
         * }
         * answer += phone_number.substring(phone_number.length()-4);
         */

        // 베스트 풀이, 시간이 가장 빠름 (어마무시하다)
        char[] ch = phone_number.toCharArray();
        for(int i = 0; i < ch.length - 4; i ++){
            ch[i] = '*';
        }
        answer = String.valueOf(ch);

        return answer;

    }
}