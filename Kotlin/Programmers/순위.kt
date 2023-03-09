package programmers

import java.util.*

class Solution {
    lateinit var winArray: Array<ArrayList<Int>>
    lateinit var loseArray: Array<ArrayList<Int>>

    fun solution(n: Int, results: Array<IntArray>): Int {
        var answer = 0

        winArray = Array(n) { ArrayList<Int>() }
        loseArray = Array(n) { ArrayList<Int>() }

        repeat(results.size) {
            val a = results[it][0] - 1
            val b = results[it][1] - 1

            winArray[a] += b
            loseArray[b] += a
        }

        repeat(n) {
            var correct = 0
            correct += BFS(n, winArray, it) + BFS(n, loseArray, it)

            if (correct == n - 1) answer++
        }

        return answer
    }

    fun BFS(n: Int, array: Array<ArrayList<Int>>, start: Int): Int {
        val visited = BooleanArray(n)
        visited[start] = true

        val queue = LinkedList<Int>()
        queue.add(start)

        var num = 0

        while (queue.isNotEmpty()) {
            val curr = queue.poll()

            for (i in array[curr]) {
                if (!visited[i]) {
                    num++
                    visited[i] = true
                    queue.add(i)
                }
            }
        }

        return num
    }
}
