class Solution {
    public static void main(String[] args) {
        // 테스트 코드
        System.out.println(solution(10));
    }

    public static boolean solution(int x) {

        int init = x;
        int count = 0;
        while (x > 0) {
            count += x % 10;
            x /= 10;
        }

        return (init % count == 0);
    }
}

/* in kotlin
    fun solution(x: Int): Boolean {
        var init = x
        var count = 0

        while(init > 0) {
            count += init % 10
            init /= 10
        }

        return (x % count == 0)
    }
 */