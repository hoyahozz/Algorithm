import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        // 테스트 코드
        Solution solution = new Solution();
        System.out.println(solution.solution(3,20,4));
    }

    public long solution(int price, int money, int count) {
        long answer = 0;

        for(int i = 1; i <= count; i++) {
            answer += (price * i);
        }

        return money > answer ? 0 : answer - money;
    }
}