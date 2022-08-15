import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        // 테스트 코드
        Solution s = new Solution();
        System.out.println(s.solution("1D2S#10S"));
    }

    public int solution(String dartResult) {
        int answer = 0;

        int[] score = new int[3];
        char[] bonus = new char[3];
        char[] option = new char[3];

        int count = -1;
        for (int i = 0; i < dartResult.length(); i++) {
            // 정수일 때
            if (dartResult.charAt(i) >= '0' && dartResult.charAt(i) <= '9') {
                count++; // 숫자가 무조건 앞에 먼저 나오니까, 나올 때마다 count++
                if (dartResult.charAt(i + 1) >= '0' && dartResult.charAt(i + 1) <= '9') { // 10일 때
                    score[count] = 10;
                    i++;
                    continue;
                }
                score[count] = dartResult.charAt(i) - '0';
            } else if (dartResult.charAt(i) == 'S' || dartResult.charAt(i) == 'D' || dartResult.charAt(i) == 'T') { // 연산자일 때
                bonus[count] = dartResult.charAt(i);
            } else { // 옵션
                option[count] = dartResult.charAt(i);
            }
        }

        System.out.println(Arrays.toString(score));

        for (int i = 0; i <= count; i++) {
            if (bonus[i] == 'D') {
                score[i] *= score[i];
            } else if (bonus[i] == 'T') {
                score[i] *= score[i] * score[i];
            } else if (option[i] == '*') {
                if (i != 0) {
                    score[i - 1] *= 2;
                }
                score[i] *= 2;
            } else if(option[i] == '#') {
                score[i] *= -1;
            }
        }

        for(int i = 0; i <= count; i++) {
            answer += score[i];
        }

        return answer;
    }
}