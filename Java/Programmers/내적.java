class Solution {
    public static void main(String[] args) {
        // 테스트 코드
        Solution solution = new Solution();

        int[] a = new int[]{1,2,3,4};
        int[] b = new int[]{-3,-1,0,2};

        System.out.println(solution.solution(a,b));
    }

    public int solution(int[] a, int[] b) {
        int answer = 0;

        for(int i = 0; i < a.length; i++) answer += a[i] * b[i];

        return answer;
    }
}