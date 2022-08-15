class Solution {
    public static void main(String[] args) {
        // 테스트 코드
        Solution s = new Solution();
        System.out.println(s.solution(1000000));
    }

    public int solution(int n) {
        if(n <= 1) return 0; // 1보다 작으면 0 리턴

        boolean[] arr = new boolean[n + 1];
        int answer = 0;

        for(int i = 0; i <= n; i++) {
            arr[i] = true; // 처음엔 모두 true로 초기화
        }

        for(int j = 2; j <= n; j++) {
            if(!arr[j]) continue; // false면 이미 소수가 아니라는 의미
            for(int k = 2; j * k <= n; k++) {
                arr[j * k] = false; // 배수는 소수가 아니라는 의미
            }
        }

        for(int l = 2; l <= n; l++) { // 0,1은 소수가 아니니깐 집계하지 않음.
            if(arr[l]) answer++;
        }

        return answer;
    }
}