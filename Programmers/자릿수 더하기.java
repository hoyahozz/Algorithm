class Solution {
    public static void main(String[] args) {
        // 테스트 코드
        System.out.println(solution(10));
    }

    public static int solution(int n) {
        int answer = 0;

        while(0 < n) {
            answer += (n % 10);
            n /= 10;
        }

        System.out.println(answer);
        return answer;
    }
}

/* in kotlin
    fun solution(n: Int): Int {
        var answer = 0
        var n = n

        while(0 < n) {
            answer += (n % 10)
            n /= 10
        }

        println(answer)

        return answer
    }
 */