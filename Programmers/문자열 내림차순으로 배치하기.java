import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        // 테스트 코드
        Solution s = new Solution();
        System.out.println(s.solution("Zbcdefg"));
    }

    public String solution(String s) {
        char[] cArray = s.toCharArray();
        Arrays.sort(cArray);

        return new StringBuilder(String.valueOf(cArray)).reverse().toString();
    }
}