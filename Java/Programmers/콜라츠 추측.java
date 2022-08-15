class Solution {
    public static void main(String[] args) {
        // 테스트 코드
        System.out.println(solution(626331));
    }

    public static int solution(long num) {
        int answer = 0;

        if(num == 1) { // num == 1 -> 0 리턴
            return 0;
        }

        for(int i = 0; i< 500; i++) { // 제한이 500번이니 500번까지만 돌림
            answer++;
            if(num % 2 == 0) { // 짝수일 때
                num /= 2;
            } else { // 홀수일 때
                num = (num * 3) + 1;
            }
            if(num == 1) { // 1이 나오면 곧바로 리턴
                return answer;
            }
        }

        return -1; // 500번을 돌려도 안나왔다는 뜻임
    }
}

/* in kotlin
    fun solution(num : Int): Int {

        var answer = 0
        var num = num.toLong() // 여기서 Long으로 바꿔줘야 하는데. . . . 어이가 아리마셍..

        if(num == 1.toLong()) {
            return 0
        }

        for(i in 0 until 500) {
            answer++
            if(num % 2.toLong() == 0L) {
                num /= 2
            } else {
                num = num * 3 + 1
            }

            if(num == 1.toLong()) {
                return answer
            }
        }

        return -1
    }
 */