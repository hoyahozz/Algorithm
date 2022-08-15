import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        // 테스트 코드
        Solution solution = new Solution();
        System.out.println(solution.solution("powerasdas"));
    }

    public String solution(String s) {
        return s.substring((s.length()-1) / 2, s.length()/2 + 1);
    }
}