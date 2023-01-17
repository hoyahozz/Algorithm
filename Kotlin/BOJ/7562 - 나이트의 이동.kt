import java.util.*

val dx = intArrayOf(-2, -1, 1, 2, -2, 2, -1, 1)
val dy = intArrayOf(-1, -2, -2, -1, 1, 1, 2, 2)

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()

    repeat(n) {
        val i = readLine().toInt()

        val (sX, sY) = readLine().split(" ").map { it.toInt() }
        val (eX, eY) = readLine().split(" ").map { it.toInt() }

        println(BFS(i, sX, sY, eX, eY))
    }
}

fun BFS(size: Int, sX: Int, sY: Int, eX: Int, eY: Int): Int {
    val visited = Array(size) { BooleanArray(size) }

    val queue = LinkedList<Pair<Int, Int>>()
    queue.add(Pair(sX, sY))
    visited[sX][sY] = true

    var level = 0

    while (queue.isNotEmpty()) {
        repeat(queue.size) {
            val curr = queue.poll()

            for (i in 0 until 8) {
                val x = curr.first + dx[i]
                val y = curr.second + dy[i]

                if (x < 0 || x >= visited.size || y < 0 || y >= visited[0].size) continue
                if (visited[x][y]) continue

                if (x == eX && y == eY) {
                    return level + 1
                }

                queue.add(Pair(x, y))
                visited[x][y] = true
            }
        }
        level++
    }

    return 0
}
