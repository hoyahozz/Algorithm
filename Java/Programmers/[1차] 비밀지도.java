import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        // 테스트 코드
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.solution(5, new int[]{9, 20, 28, 18, 11}, new int[]{30, 1, 21, 17, 28})));
    }

    public String[] solution(int n, int[] arr1, int[] arr2) {

        String[] answer = new String[n];

        for (int i = 0; i < n; i++) {
            answer[i] = String.format("%" + n + "d",
                            Long.parseLong(Integer.toBinaryString(arr1[i] | arr2[i])))
                    .replace("1", "#")
                    .replace("0", " ");
        }

        return answer;
    }
}