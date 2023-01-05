import java.util.*

lateinit var array: Array<IntArray>
lateinit var visited: BooleanArray

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val (x, y) = readLine().split(" ").map { it.toInt() }
    val m = readLine().toInt()

    array = Array(n + 1) { intArrayOf() }
    visited = BooleanArray(n + 1)

    repeat(m) { i ->
        val input = readLine().split(" ").map { it.toInt() }

        val parent = input[0]
        val child = input[1]
        array[parent] = array[parent] + child
        array[child] = array[child] + parent
    }

    println(BFS(x, y))
}

fun BFS(start: Int, end: Int): Int {
    val queue = LinkedList<Int>()
    var level = 0

    queue.add(start)
    visited[start] = true

    while (queue.isNotEmpty()) {
        repeat(queue.size) {
            val curr = queue.poll()
            if (curr == end) return level

            for (i in array[curr]) {
                if (!visited[i]) {
                    queue.add(i)
                    visited[i] = true
                }
            }
        }
        level++
    }

    return -1
}
