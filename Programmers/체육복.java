import java.util.*;

class Solution {
    public static void main(String[] args) {
        // 테스트 코드
        Solution solution = new Solution();
        System.out.println(solution.solution(5, new int[]{1,2,4}, new int[]{2,4,3,5}));
    }

    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;

        Arrays.sort(lost);
        Arrays.sort(reserve);

        for(int j = 0; j < lost.length; j++) {
            for(int k = 0; k < reserve.length; k++) {
                if(reserve[k] == lost[j]) { // 체육복 여분이 있었는데 도난당한 경우
                    reserve[k] = -1;
                    lost[j] = -1;
                    answer++; // 자기옷은 자기가 입기
                }
            }
        }

        for(int j = 0; j < lost.length; j++) {
            for(int k = 0; k < reserve.length; k++) {
                if(reserve[k] - 1 == lost[j] || reserve[k] + 1 == lost[j]) { // 인접 학생에게 빌리기
                    answer++;
                    reserve[k] = -1;
                    break;
                }
            }
        }

        return answer;
    }
}