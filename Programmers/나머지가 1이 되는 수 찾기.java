import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        // 테스트 코드
        Solution solution = new Solution();
        System.out.println(solution.solution(19283742));
    }

    public int solution(int n) {
        int answer = 1000000;

        for(int i = n; i > 0; i--) {
            if(n % i == 1 && i < answer) {
                answer = i;
            }
        }

        return answer;
    }
}