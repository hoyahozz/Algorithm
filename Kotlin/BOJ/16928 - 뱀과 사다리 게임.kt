import java.util.*

val visited = BooleanArray(101)
val ladders = ArrayList<Pair<Int, Int>>()
val snakes = ArrayList<Pair<Int, Int>>()

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val sb = StringBuilder()

    repeat(n) {
        val ladder = readLine().split(" ").map { it.toInt() }
        ladders.add(ladder[0] to ladder[1])
    }

    repeat(m) {
        val snake = readLine().split(" ").map { it.toInt() }
        snakes.add(snake[0] to snake[1])
    }

    sb.append(BFS())
    
    println(sb)
}

fun BFS(): Int {
    val queue = LinkedList<Int>()
    queue.add(1)
    visited[1] = true

    var level = 0
    while(queue.isNotEmpty()) {
        for(i in 0 until queue.size) {
            val curr = queue.poll()
            if(curr == 100) return level

            for(j in 1..6) {
                if(curr + j <= 100 && !visited[curr + j]) {
                    val findLadder = ladders.find { it.first == curr + j }
                    val findSnake = snakes.find { it.first == curr + j }

                    if(findLadder != null) {
                        queue.add(findLadder.second)
                        continue
                    }

                    if(findSnake != null) {
                        queue.add(findSnake.second)
                        continue
                    }

                    queue.add(curr + j)
                    visited[curr + j] = true
                }
            }
        }
        level++
    }

    return -1
}