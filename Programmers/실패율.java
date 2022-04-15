import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

class Solution {
    public static void main(String[] args) {
        // 테스트 코드
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(7, new int[]{4, 4, 4, 4, 4, 4, 4, 4})));
    }

    public int[] solution(int N, int[] stages) {
        double[][] result = new double[N][2];

        // 스테이지만큼 반복문
        for(int i = 0; i < N; i++) {
            double count = 0;
            double fail = 0;
            for(int j = 0; j < stages.length; j++) {
                if(stages[j] >= i + 1) { // 전체 숫자 카운트
                    count++;
                }
                if(stages[j] == i + 1) { // 실패 인원 카운트
                    fail++;
                }
            }
            result[i][0] = i + 1; // 스테이지 (ex : 5 -> 1,2,3,4,5)
            result[i][1] = Double.isNaN(fail / count) ? 0 : fail/count; // 실패율 기록, NaN (스테이지 도달 유저 X)일땐 0으로 지정
        }

// 삽질의 기록. . . . . . . . .
//        for(int m = 0; m < N; m++) {
//            for(int p = m + 1; p < N; p++) {
//                if(calm[m][1] < calm[p][1]) {
//                    double temp = calm[m][0];
//                    double temp2 = calm[m][1];
//                    calm[m][0] = calm[p][0];
//                    calm[m][1] = calm[p][1];
//                    calm[p][0] = temp;
//                    calm[p][1] = temp2;
//                } else if(calm[m][1] == calm[p][1]) {
//                    if(calm[m][0] > calm[p][0]) {
//                        double temp = calm[m][0];
//                        double temp2 = calm[m][1];
//                        calm[m][0] = calm[p][0];
//                        calm[m][1] = calm[p][1];
//                        calm[p][0] = temp;
//                        calm[p][1] = temp2;
//                    }
//                }
//            }
//        }

        Arrays.sort(result, Collections.reverseOrder(Comparator.comparingDouble(a -> a[1])));

        int[] answer = new int[N];

        for(int l = 0; l < N; l++) {
            answer[l] = (int) result[l][0];
        }

        return answer;
    }
}