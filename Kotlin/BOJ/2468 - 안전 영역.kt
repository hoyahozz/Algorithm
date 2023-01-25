import java.util.*

lateinit var array: Array<IntArray>
lateinit var visited: Array<BooleanArray>

val dx = intArrayOf(-1, 1, 0, 0)
val dy = intArrayOf(0, 0, -1, 1)

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()
    val n = readLine().toInt()
    array = Array(n) { intArrayOf() }
    visited = Array(n) { BooleanArray(n) }

    val components = ArrayList<Int>()

    repeat(n) {
        array[it] += readLine().split(" ").map { it.toInt() }.toIntArray()
    }

    for (limit in 1..100) {
        var component = 0
        repeat(n) { x ->
            repeat(n) { y ->
                if (!visited[x][y] && array[x][y] > limit) {
                    BFS(x, y, limit)
                    component++
                }
            }
        }
        visited = Array(n) { BooleanArray(n) }
        components.add(component)
    }

    val max = components.maxOrNull() ?: 0

    sb.append(
        if (max == 0) 1
        else max
    )

    println(sb)
}

fun BFS(sX: Int, sY: Int, limit: Int) {
    val queue = LinkedList<Pair<Int, Int>>()
    queue.add(Pair(sX, sY))
    visited[sX][sY] = true

    while (queue.isNotEmpty()) {
        val curr = queue.poll()

        for (i in 0 until 4) {
            val x = dx[i] + curr.first
            val y = dy[i] + curr.second

            if (x !in array.indices || y !in array[0].indices) continue
            if (visited[x][y]) continue
            if (array[x][y] <= limit) continue

            queue.add(Pair(x, y))
            visited[x][y] = true
        }
    }
}
