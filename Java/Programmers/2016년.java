import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        // 테스트 코드
        Solution solution = new Solution();

        System.out.println(solution.solution(5,12));
    }

    public String solution(int a, int b) {
        String[] day = new String[]{"FRI","SAT","SUN","MON","TUE","WED","THU"};

        int[] days = new int[]{31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int plus = 0;

        for(int i = 0; i < a - 1; i++) {
            plus += days[i];
        }

        plus += b - 1; // 1월 1일도 함께 계산하는 것을 방지

        return day[plus % 7];
    }
}