package programmers

lateinit var visited: BooleanArray
var answer = 0
lateinit var numberList: IntArray

class Solution {
    fun solution(numbers: IntArray, target: Int): Int {
        visited = BooleanArray(numbers.size)
        numberList = numbers

        DFS(0, 0, target)

        return answer
    }

    fun DFS(sum: Int, depth: Int, target: Int) {
        if (depth == numberList.size) {
            if(sum == target) answer++
            return
        }

        DFS(sum + numberList[depth], depth + 1, target)
        DFS(sum - numberList[depth], depth + 1, target)
    }
}

fun main() {
    println(Solution().solution(intArrayOf(1, 1, 1, 1, 1), 3))
}