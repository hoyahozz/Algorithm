import java.util.*

var visited = Array(9) { false }
val graph = arrayOf(
    emptyArray(),
    arrayOf(2, 3, 8),
    arrayOf(1, 7),
    arrayOf(1, 4, 5),
    arrayOf(3, 5),
    arrayOf(3, 4),
    arrayOf(7),
    arrayOf(2, 6, 8),
    arrayOf(1, 7)
)

fun main() = with(System.`in`.bufferedReader()) {
    DFS(1)
    println("---------------------------------")
    visited = Array(9) { false }
    BFS(1)
}

fun DFS(x: Int) {
    visited[x] = true
    println("$x ")

    for (node in graph[x]) {
        if (!visited[node]) DFS(node)
    }
}

fun BFS(x: Int) {
    val q: Queue<Int> = LinkedList()
    q.offer(x)

    visited[x] = true

    while (q.isNotEmpty()) {
        val x = q.poll()
        println("$x ")

        for (node in graph[x]) {
            if (!visited[node]) {
                q.offer(node)
                visited[node] = true
            }
        }
    }
}