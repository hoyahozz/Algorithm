import java.util.*

lateinit var visited: Array<BooleanArray>
val dx = intArrayOf(-2, -2, 0, 0, 2, 2)
val dy = intArrayOf(-1, 1, -2, 2, -1, 1)

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val sb = StringBuilder()

    visited = Array(n) { BooleanArray(n) }

    val (r1, c1, r2, c2) = readLine().split(" ").map { it.toInt() }

    sb.append(BFS(r1, c1, r2, c2))

    println(sb)
}

fun BFS(r1: Int, c1: Int, r2: Int, c2: Int): Int {

    val queue = LinkedList<Pair<Int, Int>>()
    queue.add(Pair(r1, c1))
    visited[r1][c1] = true

    var level = 0

    while (queue.isNotEmpty()) {
        repeat(queue.size) {
            val curr = queue.poll()

            if (curr.first == r2 && curr.second == c2) return level

            for(i in 0 until 6) {
                val x = curr.first + dx[i]
                val y = curr.second + dy[i]

                if(x !in visited.indices || y !in visited[0].indices) continue
                if(visited[x][y]) continue

                queue.add(Pair(x, y))
                visited[x][y] = true
            }
        }
        level++
    }

    return -1
}