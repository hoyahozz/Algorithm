lateinit var array: Array<IntArray>
lateinit var visited: Array<Array<Array<Boolean>>>

val dx = intArrayOf(0, 0, -1, 1)
val dy = intArrayOf(-1, 1, 0, 0)

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m, t) = readLine().split(" ").map { it.toInt() }
    val sb = StringBuilder()

    array = Array(n) { IntArray(m) }
    visited = Array(n) { Array(m) { Array(2) { false } } }

    repeat(n) { i ->
        array[i] = readLine().split(" ").map { it.toInt() }.toIntArray()
    }

    val result = BFS()

    if (!result.first) sb.append("Fail")
    else {
        if (result.second <= t) sb.append(result.second)
        else sb.append("Fail")
    }

    println(sb)
}

fun BFS(): Pair<Boolean, Int> {
    val queue = ArrayDeque<Triple<Int, Int, Boolean>>()

    queue.add(Triple(0, 0, false))
    visited[0][0][0] = true

    var level = 0

    while (queue.isNotEmpty()) {
        repeat(queue.size) {
            val curr = queue.removeFirst()

            for (i in 0 until 4) {
                val x = curr.first + dx[i]
                val y = curr.second + dy[i]
                var flag = curr.third

                if (x < 0 || x >= array.size || y < 0 || y >= array[0].size) continue

                if (!flag) {
                    if (array[x][y] == 1) continue
                    if (visited[x][y][0]) continue
                    visited[x][y][0] = true
                } else {
                    if (visited[x][y][1]) continue
                    visited[x][y][1] = true
                }

                if (array[x][y] == 2) flag = true
                if (x == array.lastIndex && y == array[0].lastIndex) return Pair(true, level + 1)

                queue.add(Triple(x, y, flag))
            }
        }
        level++
    }

    return Pair(false, level)
}

