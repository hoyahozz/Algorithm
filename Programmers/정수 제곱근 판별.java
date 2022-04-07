import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        // 테스트 코드
        System.out.println(solution(121));
    }

    public static long solution(long n) {
        long answer = 0;

        for (long i = 0; i <= n; i++) {
            if(i * i == n) {
                answer = i;
                break;
            }
        }

        return (answer == 0) ? -1 : ((answer + 1) * (answer + 1));
    }
}

/* in kotlin
    fun solution(n: Long): Long {
        var answer: Long = 0

        for(i in 0 .. n) {
            if(i * i == n) return (i+1) * (i+1)
        }

        return -1
    }
 */