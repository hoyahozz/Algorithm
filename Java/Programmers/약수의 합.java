import java.util.*;

class Solution {
    public static void main(String[] args) {
        // 테스트 코드
        System.out.println(solution(12));
    }

    public static int solution(int n) {

        int answer = 0;
        int count = 1;

        while(count <= n) {
            if(n % count == 0) {
                answer += count;
            }

            count++;
        }

        return answer;
    }
}