import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public static void main(String[] args) {
        // 테스트 코드
        Solution solution = new Solution();

        int[] progresses = new int[]{93,30,55};
        int[] speeds = new int[]{1,30,5};
//        int[] progresses = new int[]{95, 90, 99, 99, 80, 99};
//        int[] speeds = new int[]{1,1,1,1,1,1};

        System.out.println(Arrays.toString(solution.solution(progresses, speeds)));
    }

    public int[] solution(int[] progresses, int[] speeds) {


        Queue<Integer> pQueue = new LinkedList<Integer>();

        // 큐에 초기값 입력
        for(int pro : progresses) {
            pQueue.add(pro);
        }

        ArrayList<Integer> days = new ArrayList<>();

        // 할 일을 처리하는데 걸리는 시간을 계산하고 ArrayList 에 담는 과정
        int c = 0;
        while(!pQueue.isEmpty()) {
            int current = pQueue.peek();
            int currentDay = 0;

            while(current < 100) {
                current += speeds[c];
                currentDay++;
            }

            days.add(currentDay);;
            c++;
            pQueue.poll();
        }

        ArrayList<Integer> answerAr = new ArrayList<>();

        // 배포 리스트를 추출해내는 과정
        for(int i = 0; i < days.size(); i++) {
            int dayCounting = 1;

            // 마지막 숫자이면 더 비교할 필요가 없으니 바로 1을 넣어줌.
            if(i == days.size() - 1) {
                answerAr.add(1);
                break;
            }

            // i 인덱스를 기준으로 탐색
            for(int j = i+1; j < days.size(); j++) {
                if(days.get(i) < days.get(j)) {
                    // i 인덱스보다 큰 값을 발견하면, 바로 ArrayList 에 담고 i 인덱스를 j 인덱스로 이동시킨다.
                    // 왜? : 뒤에 있는 기능은 앞에 있는 기능이 배포될 때 함께 배포되니깐.
                    i = j - 1;
                    answerAr.add(dayCounting);
                    break;
                } else {
                    // i 인덱스보다 작은 값을 발견하면, 앞에 있는 기능이 배포될 준비가 완료됐을 때 함께 배포된다는 의미이다.
                    // 카운트를 늘려준다.
                    dayCounting++;
                    if(j == days.size() -1) {
                        // 비교 과정에서 마지막 값에 도달하면 카운트를 그대로 리스트에 넣어주고, i 인덱스를 j 인덱스로 맞춰준다.
                        // 첫 반복문은 작동하지 않게 된다.
                        i = j;
                        answerAr.add(dayCounting);
                    }
                }
            }
        }

        int[] answer = new int[answerAr.size()];

        for(int i = 0; i < answerAr.size(); i++) {
            answer[i] = answerAr.get(i);
        }

        return answer;
    }
}