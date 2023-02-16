import java.util.*

lateinit var array: Array<IntArray>
lateinit var visited: Array<BooleanArray>

val dx = intArrayOf(-1, 1, 0, 0)
val dy = intArrayOf(0, 0, -1, 1)

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }

    array = Array(n) { IntArray(m) }
    visited = Array(array.size) { BooleanArray(array[0].size) }

    repeat(n) {
        array[it] = readLine().split(" ").map { it.toInt() }.toIntArray()
    }

    var time = 0

    while (true) {
        var components = 0

        for (x in array.indices) {
            for (y in array[0].indices) {
                if (array[x][y] != 0 && !visited[x][y]) {
                    BFS(x to y)
                    components++
                }
            }
        }

        visited = Array(array.size) { BooleanArray(array[0].size) }

        if (components == 0) {
            println(0)
            return@with
        } else if (components > 1) {
            println(time)
            return@with
        }

        time++
    }
}

fun BFS(location: Pair<Int, Int>) {
    val queue = LinkedList<Pair<Int, Int>>()
    val copyArray = Array(array.size) { IntArray(array[0].size) }

    for (i in array.indices) {
        copyArray[i] = array[i].copyOf()
    }

    queue.add(location)
    visited[location.first][location.second] = true

    while (queue.isNotEmpty()) {
        val curr = queue.poll()
        var meltValue = 0

        for (i in 0 until 4) {
            val x = curr.first + dx[i]
            val y = curr.second + dy[i]

            if (x !in array.indices || y !in array[0].indices) continue
            if (array[x][y] <= 0) {
                meltValue++
                continue
            }
            if (visited[x][y]) continue

            queue.add(x to y)
            visited[x][y] = true
        }

        if (array[curr.first][curr.second] - meltValue < 0) copyArray[curr.first][curr.second] = 0
        else copyArray[curr.first][curr.second] -= meltValue
    }

    array = copyArray
}
