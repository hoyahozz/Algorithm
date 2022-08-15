class Solution {
    public static void main(String[] args) {
        // 테스트 코드
        Solution s = new Solution();
        System.out.println(s.solution("yyXPP"));
    }

    public boolean solution(String s) {
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'p' || s.charAt(i) == 'P') {
                count++;
            } else if (s.charAt(i) == 'y' || s.charAt(i) == 'Y') {
                count--;
            }
        }

        return count == 0;
    }
}