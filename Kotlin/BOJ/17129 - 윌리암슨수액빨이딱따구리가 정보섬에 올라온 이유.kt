lateinit var array: Array<String>
lateinit var visited: Array<BooleanArray>

val dx = intArrayOf(-1, 1, 0, 0)
val dy = intArrayOf(0, 0, -1, 1)

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val sb = StringBuilder()

    array = Array(n) { readLine() }
    visited = Array(n) { BooleanArray(m) }

    var sX = 0
    var sY = 0

    repeat(n) { i ->
        for (j in array[i].indices) {
            array[i][j].apply {
                if (this == '2') {
                    sX = i
                    sY = j
                }
            }
        }
    }

    BFS(sX, sY).apply {
        if (this != -1) {
            sb.appendLine("TAK")
            sb.appendLine(this)
        } else {
            sb.append("NIE")
        }
    }

    println(sb)
}

fun BFS(sX: Int, sY: Int): Int {
    val queue = ArrayDeque<Pair<Int, Int>>()
    queue.add(sX to sY)
    visited[sX][sY] = true

    var level = 0

    while (queue.isNotEmpty()) {
        repeat(queue.size) {
            val curr = queue.removeFirst()

            if (array[curr.first][curr.second] in '3'..'5') return level

            for (i in 0 until 4) {
                val x = curr.first + dx[i]
                val y = curr.second + dy[i]

                if (x !in array.indices || y !in array[0].indices) continue
                if (visited[x][y]) continue
                if (array[x][y] == '1') continue

                queue.add(Pair(x, y))
                visited[x][y] = true
            }
        }
        level++
    }

    return -1
}