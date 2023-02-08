import java.util.*

lateinit var array: Array<CharArray>
lateinit var visited: Array<BooleanArray>

val dx = intArrayOf(-1, 1, 0, 0)
val dy = intArrayOf(0, 0, -1, 1)

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()

    array = Array(n) { CharArray(n) }
    visited = Array(n) { BooleanArray(n) }

    repeat(n) {
        array[it] = readLine().toCharArray()
    }

    var component = 0
    var weakComponent = 0

    repeat(n) { i ->
        repeat(n) { j ->
            if (!visited[i][j]) {
                BFS(i, j, false)
                component++
            }
        }
    }

    visited = Array(n) { BooleanArray(n) }

    repeat(n) { i ->
        repeat(n) { j ->
            if (!visited[i][j]) {
                BFS(i, j, true)
                weakComponent++
            }
        }
    }

    println("$component $weakComponent")
}

fun BFS(sX: Int, sY: Int, isColorWeak: Boolean) {
    val queue = LinkedList<Pair<Int, Int>>()
    visited[sX][sY] = true
    queue.add(sX to sY)

    val color = array[sX][sY]

    while (queue.isNotEmpty()) {
        val curr = queue.poll()

        for (i in 0 until 4) {
            val x = curr.first + dx[i]
            val y = curr.second + dy[i]

            if (x !in array.indices || y !in array[0].indices) continue
            if (visited[x][y]) continue

            if (isColorWeak) {
                if ((color == 'R' || color == 'G') && array[x][y] == 'B') continue
                else if (color == 'B' && array[x][y] != 'B') continue
            }
            if (!isColorWeak && array[x][y] != color) continue

            queue.add(x to y)
            visited[x][y] = true
        }
    }
}
