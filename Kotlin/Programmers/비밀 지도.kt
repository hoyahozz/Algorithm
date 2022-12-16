class Solution {
    fun solution(n: Int, arr1: IntArray, arr2: IntArray) {
        repeat(n) { i ->
            println(Integer.toBinaryString(arr1[i] or arr2[i]).replace("1", "#").replace("0", " "))
        }
    }
}

fun main() = with(System.`in`.bufferedReader()) {
    val n = 6
    val arr1 = intArrayOf(46, 33, 33, 22, 31, 50)
    val arr2 = intArrayOf(27, 56, 19, 14, 14, 10)

    Solution().solution(n, arr1, arr2)
}
