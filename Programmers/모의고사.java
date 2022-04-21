import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        // 테스트 코드
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(new int[]{1, 3, 2, 4, 2, 5})));
    }
    public int[] solution(int[] answers) {
        int[] first = new int[]{1,2,3,4,5};
        int[] second = new int[]{2,1,2,3,2,4,2,5};
        int[] third = new int[]{3,3,1,1,2,2,4,4,5,5};

        int fCount = 0;
        int sCount = 0;
        int tCount = 0;

        for(int i = 0; i < answers.length; i++) {
            if(first[i % first.length] == answers[i]) {
                fCount++;
            }

            if(second[i % second.length] == answers[i]) {
                sCount++;
            }

            if(third[i % third.length] == answers[i]) {
                tCount++;
            }
        }

        int[] countArr = new int[]{fCount, sCount, tCount};

        int max = Math.max(fCount, Math.max(sCount, tCount));

//        for (int j : countArr) {
//            if (max < j) max = j;
//        }

        int size = 0;

        for (int k : countArr) {
            if (max == k) size++;
        }

        int[] answer = new int[size];

        int cnt = 0;
        for(int i = 0; i < countArr.length; i++) {
            if(max == countArr[i]) {
                answer[cnt] = i + 1;
                cnt++;
            }
        }

        return answer;
    }
}