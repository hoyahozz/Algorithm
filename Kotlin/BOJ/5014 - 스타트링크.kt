import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    // F -> 건물 층 수
    // S -> 현재 층
    // G -> 목적지
    // U -> U층만큼 올라감
    // D -> D층만큼 내려감
    val (F, S, G, U, D) = readLine().split(" ").map { it.toInt() }
    val result = BFS(F, S, G, U, D)
    println(
        if (result == -1) "use the stairs"
        else result
    )
}

fun BFS(F: Int, S: Int, G: Int, U: Int, D: Int): Int {
    val queue = LinkedList<Int>()
    val visited = BooleanArray(F + 1)
    queue.add(S)
    visited[S] = true

    var level = 0

    while (queue.isNotEmpty()) {
        repeat(queue.size) {
            val curr = queue.poll()

            if (curr == G) return level

            val plus = curr + U
            val minus = curr - D

            if (plus <= F) {
                if (!visited[plus]) {
                    visited[plus] = true
                    queue.add(plus)
                }
            }
            if (minus > 0) {
                if (!visited[minus]) {
                    visited[minus] = true
                    queue.add(minus)
                }
            }
        }
        level++
    }

    return -1
}

