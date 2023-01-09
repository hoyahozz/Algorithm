/* https://school.programmers.co.kr/learn/courses/30/lessons/43238 */

class Solution {
    fun solution(n: Int, times: IntArray): Long {
        return binarySearch(n, times) + 1
    }

    fun binarySearch(peopleCount: Int, times: IntArray): Long {
        var start = 1L
        var end = times.last().toLong() * peopleCount.toLong()

        while(start <= end) {
            val middle = (start + end) / 2
            val count = times.sumOf { middle / it }

            if (count < peopleCount) start = middle + 1
            else end = middle - 1
        }

        return end
    }
}

