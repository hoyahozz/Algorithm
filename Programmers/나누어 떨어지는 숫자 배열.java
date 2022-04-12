import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        // 테스트 코드
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.solution(new int[]{2, 36, 1, 13}, 1)));
    }

    public int[] solution(int[] arr, int divisor) {

        int len = 0;
        for (int k : arr) {
            if (k % divisor == 0) len++;
        }

        int[] answer = new int[len];

        int count = 0;
        for (int j : arr) {
            if (j % divisor == 0) {
                answer[count] = j;
                count++;
            }
        }

        Arrays.sort(answer);

        return len == 0 ? (new int[]{-1}) : answer;
    }
}