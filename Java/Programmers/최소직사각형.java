import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        // 테스트 코드
        Solution solution = new Solution();

        int[][] sizes = new int[][]{{10, 7}, {12, 3}, {8, 15}, {14, 7}, {5, 15}};
        System.out.println(solution.solution(sizes));
    }

    public int solution(int[][] sizes) {

        int max = 0;
        int min = 0;

        for (int[] size : sizes) {
            int paramMax = (Math.max(size[0], size[1]));
            int paramMin = (Math.min(size[0], size[1]));

            if (paramMax > max) {
                max = paramMax;
            }
            if (paramMin > min) {
                min = paramMin;
            }
        }
        return max * min;
    }
}