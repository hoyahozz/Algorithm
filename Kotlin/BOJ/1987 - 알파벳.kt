import kotlin.math.max

lateinit var array: Array<IntArray>
val dx = intArrayOf(-1, 1, 0, 0)
val dy = intArrayOf(0, 0, -1, 1)
var answer = 0
val visited = Array(26) { false }

fun main() = with(System.`in`.bufferedReader()) {
    val (R, C) = readLine().split(" ").map { it.toInt() }

    array = Array(R) { IntArray(C) }

    repeat(R) { x ->
        readLine().forEachIndexed { y, c ->
            array[x][y] = c - 'A'
        }
    }

    visited[array[0][0]] = true
    DFS(0, 0, 0)
    println(answer + 1)
}

fun DFS(x: Int, y: Int, depth: Int) {
    answer = max(depth, answer)

    for (i in 0 until 4) {
        val nextX = x + dx[i]
        val nextY = y + dy[i]

        if (nextX !in array.indices || nextY !in array[0].indices) continue
        if (visited[array[nextX][nextY]]) continue

        visited[array[nextX][nextY]] = true
        DFS(nextX, nextY, depth + 1)
        visited[array[nextX][nextY]] = false
    }
}

