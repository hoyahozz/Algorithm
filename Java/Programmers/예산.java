import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

class Solution {
    public static void main(String[] args) {
        // 테스트 코드
        Solution solution = new Solution();

        System.out.println(solution.solution(new int[]{1,3,2,5,4}, 9));
    }

    public int solution(int[] d, int budget) {
        int answer = 0;

        Arrays.sort(d);

        int count = 0;
        for(int i : d) {
            if(count + i <= budget) {
                count += i;
                answer++;
            }
        }

        return answer;
    }
}