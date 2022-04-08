import java.util.*;

class Solution {
    public static void main(String[] args) {
        // 테스트 코드
        System.out.println(solution(118372));
    }

    public static long solution(long n) {
        ArrayList<Long> list = new ArrayList<Long>();

        long answer = 0;

        while(0 < n) {
            list.add(n % 10); // 한자리씩 배열에 담기
            n /= 10;
        }

        Collections.sort(list); // 먼저 오름차순으로 나열
        int count = 1;
        for(long aList : list) {
            answer += aList * count; // 정수로 변환, 1의 자리부터 채워나가기
            count *= 10;
        }
        return answer;
    }
}

/* in kotlin
    fun solution(n : Long): Long {
        var answer: Long = 0
        var n = n
        val arr : ArrayList<Long> = ArrayList<Long>()

        while(0 < n) {
            arr.add((n % 10));
            n /= 10L;
        }

        arr.sort()

        var count = 1
        for(i in 0 until arr.size) {
            answer += (arr[i] * count)
            count *= 10
        }

        return answer
    }
 */