class Solution {
    public static void main(String[] args) {
        // 테스트 코드
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[]{1,2,7,6,4}));
    }

    public int solution(int[] nums) {
        int answer = 0;

        for(int i = 0; i < nums.length - 2; i++) {
            for(int j = i+1; j < nums.length - 1; j++) {
                for(int k = j+1; k < nums.length; k++) {
                    int value = nums[i] + nums[j] + nums[k];
                    int count = 0;

                    for(int l = 2; l <= value; l++) {
                        if(value % l == 0) {
                            count++;
                        }
                    }
                    if(count == 1) {
                        answer++;
                    }
                }
            }
        }

        return answer;
    }
}