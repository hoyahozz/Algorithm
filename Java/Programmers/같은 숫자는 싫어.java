import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        // 테스트 코드
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.solution(new int[]{1,1,3,3,0,1,1})));
    }

    public int[] solution(int []arr) {

        ArrayList<Integer> a = new ArrayList();
        a.add(arr[0]); // 첫번째 요소는 바로 넣기

        // 중복 제거
        for(int i = 0; i + 1 < arr.length; i++) {
            if(arr[i] != arr[i + 1]) { // 현 요소가 그 다음 요소와 다르면 배열에 넣기
                a.add(arr[i + 1]);
            }
        }

        int[] answer = new int[a.size()];

        for(int j = 0; j < a.size(); j++) {
            answer[j] = a.get(j);
        }

        return answer;
    }
}