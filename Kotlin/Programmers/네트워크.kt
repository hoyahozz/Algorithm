package programmers

import java.util.*

class Solution {
    fun solution(n: Int, computers: Array<IntArray>): Int {
        var answer = 0
        val visited = BooleanArray(n)

        fun BFS(start: Int) {
            val queue = LinkedList<Int>()
            queue.add(start)
            visited[start] = true

            while(queue.isNotEmpty()) {
                val curr = queue.poll()

                for(i in computers[curr].indices) {
                    if(!visited[i] && computers[curr][i] == 1) {
                        queue.add(i)
                        visited[i] = true
                    }
                }
            }
        }

        for(i in computers.indices) {
            if(!visited[i]) {
                BFS(i)
                answer++
            }
        }

        return answer
    }
}

fun main() {
    val computers = arrayOf(
        intArrayOf(1, 1, 0),
        intArrayOf(1, 1, 0),
        intArrayOf(0, 0, 1)
    )

    println(Solution().solution(3, computers))
}