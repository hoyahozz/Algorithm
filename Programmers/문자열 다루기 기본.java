class Solution {
    public static void main(String[] args) {
        // 테스트 코드
        Solution s = new Solution();

        System.out.println(s.solution("1234"));
    }

    public boolean solution(String s) {

        char[] ch = s.toCharArray();

        if(ch.length != 4 && ch.length != 6) return false;

        for (char c : ch) {
            if (c < '0' || c > '9') return false;
        }

        return true;
    }
}