class Solution {
    public static void main(String[] args) {
        // 테스트 코드
        Solution solution = new Solution();

        System.out.println(solution.solution(13,17));
    }

    public int solution(int left, int right) {
        int answer = 0;
        for(int i = left; i <= right; i++) {
            int count = 1;
            for(int j = 2; j <= right; j++) {
                if(i % j == 0) {
                    count++;
                }
            }
            if(count % 2 == 0) {
                answer += i;
            } else {
                answer -= i;
            }
        }


        return answer;
    }
}