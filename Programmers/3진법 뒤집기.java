import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        // 테스트 코드
        Solution solution = new Solution();

        int n = 125;
        System.out.println(solution.solution(n));
    }

    public int solution(int n) {
        String three = Integer.toString(n, 3);
//        String reverse = "";
//        for(int i = three.length() - 1; i >= 0; i--) {
//            reverse += three.charAt(i);
//        }

        // 속도차이 어마무시함
        StringBuilder reverseBuilder = new StringBuilder();
        reverseBuilder.append(three);
        reverseBuilder.reverse();

        return Integer.parseInt(reverseBuilder.toString(), 3);
    }
}