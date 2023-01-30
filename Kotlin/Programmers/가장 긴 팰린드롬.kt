class Solution {
    fun solution(s: String): Int {
        for (i in s.lastIndex downTo 0) {
            var si = 0

            while (si + i <= s.lastIndex) {
                var isPel = true
                var start = si
                var end = si + i
                while (start < end) {
                    if (s[start] != s[end]) {
                        isPel = false
                        break
                    }
                    start++
                    end--
                }

                if (isPel) return i + 1
                si++
            }
        }
        return 0
    }
}

fun main() {
    println(Solution().solution("abcdba"))
}
