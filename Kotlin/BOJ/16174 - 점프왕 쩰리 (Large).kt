import java.util.*

lateinit var array: Array<IntArray>
lateinit var visited: Array<BooleanArray>

val dx = intArrayOf(1, 0)
val dy = intArrayOf(0, 1)

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val sb = StringBuilder()

    array = Array(n) { readLine().split(" ").map { it.toInt() }.toIntArray() }
    visited = Array(n) { BooleanArray(n) }

    sb.append(BFS(n))

    println(sb)
}

fun BFS(n: Int): String {
    val queue = LinkedList<Pair<Int, Int>>()

    queue.add(Pair(0, 0))
    visited[0][0] = true

    while(queue.isNotEmpty()) {
        val curr = queue.poll()
        val currValue = array[curr.first][curr.second]

        if(currValue == -1) return "HaruHaru"

        for(i in 0 until 2) {
            val x = curr.first + (currValue * dx[i])
            val y = curr.second + (currValue * dy[i])

            if(x !in array.indices || y !in array[0].indices) continue
            if(visited[x][y]) continue

            queue.add(Pair(x, y))
            visited[x][y] = true
        }
    }

    return "Hing"
}
