import java.util.*

const val maxSize = 100_001

fun main() = with(System.`in`.bufferedReader()) {
    val (start, end) = readLine().split(" ").map { it.toInt() }
    val visited = BooleanArray(maxSize)

    val queue = LinkedList<Int>()
    queue.add(start)
    visited[start] = true

    var level = 0
    while(queue.isNotEmpty()) {
        repeat(queue.size) {
            val curr = queue.poll()

            if(curr == end) {
                println(level)
                return@with
            }

            for(i in 0 until 3) {
                var next = curr
                when(i) {
                    0 -> next += 1
                    1 -> next -= 1
                    2 -> next *= 2
                }

                if(next in 0 until maxSize && !visited[next]) {
                    queue.add(next)
                    visited[next] = true
                }
            }
        }
        level++
    }

    println(0)
}

