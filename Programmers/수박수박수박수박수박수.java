import java.util.*;

class Solution {
    public static void main(String[] args) {
        // 테스트 코드
        Solution s = new Solution();
        System.out.println(s.solution(5));
    }

    public String solution(int n) {

        StringBuilder answer = new StringBuilder();

        for(int i = 0; i < n; i++) {
            answer.append(i % 2 == 0 ? "수" : "박");
        }

        return answer.toString();
    }
}