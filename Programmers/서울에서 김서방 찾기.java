class Solution {
    public static void main(String[] args) {
        // 테스트 코드
        Solution s = new Solution();

        System.out.println(s.solution(new String[]{"zz", "Namu", "Kim"}));
    }

    public String solution(String[] seoul) {
        int count = 0;
        for(int i = 0; i < seoul.length; i++) {
            if(seoul[i].equals("Kim")) {
                count = i;
                break;
            }
        }

        return "김서방은 " + count + "에 있다.";
    }
}