class Solution {
    public static void main(String[] args) {
        // 테스트 코드
        Solution solution = new Solution();

        int[] numbers = new int[]{1,2,3,4,6,7,8,0};

        System.out.println(solution.solution(numbers));
    }

    public int solution(int[] numbers) {
        int answer = 0;

        for(int i = 0; i < 10; i++) {
            int tmp = i;
            for (int number : numbers) {
                if (i == number) {
                    tmp = 0;
                    break;
                }
            }
            answer += tmp;
        }

        return answer;
    }
}