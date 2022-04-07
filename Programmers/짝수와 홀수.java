class Solution {
    public static void main(String[] args) {
        // 테스트 코드
        System.out.println(solution(11));
    }

    public static String solution(int num) {
        return (num % 2 == 0) ? "Even" : "Odd";
    }
}

/* in kotlin
fun solution(num : Int): String {
    return when {
        num % 2 == 0 -> "Even"
        else -> "Odd"
    }
}
 */