import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        // 테스트 코드
        int[] arr = {5,6,1,2};

        System.out.println(Arrays.toString(solution(arr)));
    }

    public static int[] solution(int[] arr) {
        int[] answer = new int[arr.length - 1];

        if(arr.length == 1) { // 배열이 하나밖에 없을 때는 -1 출력
            return new int[]{-1};
        }

        int low = Integer.MAX_VALUE; // 최소값 저장을 위한 변수

        for (int j : arr) {
            if (j < low) {
                low = j; // 최소값
            }
        }

        int count = 0;
        for (int i : arr) {
            if (i != low) { // 최소값과 같지 않으면 출력할 배열에 값을 넣음
                answer[count] = i;
                count++;
            }
        }

        return answer;
    }
}

/* in kotlin
fun solution(num : IntArray): IntArray {
    val answer = IntArray(num.size - 1)

    var low = Int.MAX_VALUE

    for(i in num.indices) {
        if(num[i] < low) {
            low = num[i]
        }
    }

    var count = 0
    for(j in num.indices) {
        if(num[j] != low) {
            answer[count] = num[j]
            count++
        }
    }

    return answer
}
 */