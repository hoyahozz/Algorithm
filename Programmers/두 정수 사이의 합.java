import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        // 테스트 코드
        Solution s = new Solution();
        System.out.println(s.solution(5,1));
    }

    public long solution(int a, int b) {
        long answer = 0;

        int start = Math.min(a, b);
        int end = Math.max(a, b);

        for(int i = start; i <= end; i++) {
            answer += i;
        }

        return answer;
    }
}