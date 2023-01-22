import java.util.*

lateinit var array: Array<IntArray>
lateinit var visited: Array<BooleanArray>

val dx = intArrayOf(0, 0, -1, 1)
val dy = intArrayOf(-1, 1, 0, 0)

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val sizes = ArrayList<Int>()

    array = Array(n) { intArrayOf() }
    visited = Array(n) { BooleanArray(m) }

    repeat(n) {
        array[it] = readLine().split(" ").map { it.toInt() }.toIntArray()
    }

    repeat(n) { x ->
        repeat(m) { y ->
            if (!visited[x][y] && array[x][y] == 1) {
                sizes.add(BFS(x, y))
            }
        }
    }

    sb.appendLine(sizes.size)
    sb.appendLine(sizes.maxOrNull() ?: 0)

    println(sb)
}

fun BFS(sX: Int, sY: Int): Int {
    val queue = LinkedList<Pair<Int, Int>>()
    queue.add(Pair(sX, sY))
    visited[sX][sY] = true

    var level = 0

    while (queue.isNotEmpty()) {
        repeat(queue.size) {
            val curr = queue.poll()
            level++

            for (i in 0 until 4) {
                val x = curr.first + dx[i]
                val y = curr.second + dy[i]

                if (x !in array.indices || y !in array[0].indices) continue
                if (visited[x][y]) continue
                if (array[x][y] == 0) continue

                queue.add(Pair(x, y))
                visited[x][y] = true
            }
        }
    }

    return level
}