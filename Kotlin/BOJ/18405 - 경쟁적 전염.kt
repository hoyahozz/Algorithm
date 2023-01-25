import java.util.*

lateinit var array: Array<IntArray>
lateinit var visited: Array<BooleanArray>

val dx = intArrayOf(-1, 1, 0, 0)
val dy = intArrayOf(0, 0, -1, 1)

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()
    val (n, m) = readLine().split(" ").map { it.toInt() }

    array = Array(n) { intArrayOf() }
    visited = Array(n) { BooleanArray(m) }

    repeat(n) {
        array[it] += readLine().split(" ").map { it.toInt() }.toIntArray()
    }

    val (s, x, y) = readLine().split(" ").map { it.toInt() }

    BFS(findComponents(), s)
    sb.append(array[x - 1][y - 1])
    println(sb)
}

fun findComponents(): List<Triple<Int, Int, Int>> {
    val components = ArrayList<Triple<Int, Int, Int>>()

    for(i in array.indices) {
        for(j in array[i].indices) {
            if(array[i][j] != 0) {
                components += Triple(array[i][j], i, j)
            }
        }
    }

    return components.sortedBy { it.first }
}

fun BFS(components: List<Triple<Int, Int, Int>>, s: Int) {
    var level = 0
    val queue = LinkedList<Pair<Int, Int>>()

    components.forEach {
        queue.add(Pair(it.second, it.third))
        visited[it.second][it.third] = true
    }

    while (queue.isNotEmpty()) {
        if(level == s) break
        repeat(queue.size) {
            val curr = queue.poll()

            for (i in 0 until 4) {
                val nextX = dx[i] + curr.first
                val nextY = dy[i] + curr.second

                if (nextX !in array.indices || nextY !in array[0].indices) continue
                if (visited[nextX][nextY]) continue
                if (array[nextX][nextY] != 0) continue

                queue.add(Pair(nextX, nextY))
                visited[nextX][nextY] = true
                array[nextX][nextY] = array[curr.first][curr.second]
            }
        }
        level++
    }
}


