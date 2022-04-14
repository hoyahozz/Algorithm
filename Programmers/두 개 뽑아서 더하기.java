import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

class Solution {
    public static void main(String[] args) {
        // 테스트 코드
        Solution solution = new Solution();

        System.out.println(Arrays.toString(solution.solution(new int[]{2,1,3,4,1})));
    }

    public int[] solution(int[] numbers) {

        ArrayList<Integer> aList = new ArrayList();

        for(int i = 0; i < numbers.length; i++) {
            for(int j = i+1; j < numbers.length; j++) {
                if(!aList.contains(numbers[i] + numbers[j])) {
                    aList.add(numbers[i] + numbers[j]);
                }
            }
        }

        int[] answer = new int[aList.size()];

        for(int k = 0; k < answer.length; k++) {
            answer[k] = aList.get(k);
        }
        // answer = aList.stream().mapToInt(Integer::intValue).toArray(); (속도 많이 차이남)

        Arrays.sort(answer);
        return answer;
    }
}