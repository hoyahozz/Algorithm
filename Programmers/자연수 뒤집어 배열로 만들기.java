import java.util.*;

class Solution {
    public static void main(String[] args) {
        // 테스트 코드
        System.out.println(Arrays.toString(solution(1234567129)));
    }

    public static int[] solution(long n) {
        String size = String.valueOf(n);
        int[] answer = new int[size.length()];

        int count = 0;
        while(0 < n) {
            answer[count] = (int)(n % 10);
            n /= 10;
            count++;
        }

        return answer;
    }
}

/* in kotlin
    fun solution(n : Long): IntArray {
        val size = n.toString()
        var n = n
        val answer = IntArray(size.length)

        var count = 0
        while(0 < n) {
            answer[count] = (n % 10).toInt()
            n /= 10
            count++
        }

        return answer
    }
 */