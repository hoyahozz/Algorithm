val dx = intArrayOf(0, 1, 1)
val dy = intArrayOf(1, 1, 0)
val dr = intArrayOf(0, 45, 90)
lateinit var array: Array<IntArray>
var answer = 0

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    array = Array(n) { IntArray(n) }

    repeat(n) {
        array[it] = readLine().split(" ").map { it.toInt() }.toIntArray()
    }

    DFS(0 to 1, n - 1 to n - 1, 0)
    println(answer)
}

fun DFS(start: Pair<Int, Int>, end: Pair<Int, Int>, rotate: Int) {
    if (start == end) answer++

    for (i in 0 until 3) {
        val x = start.first + dx[i]
        val y = start.second + dy[i]
        val nextRotate = dr[i]

        if (x !in array.indices || y !in array[0].indices) continue
        if (array[x][y] == 1) continue

        when (rotate) {
            0 -> if (i == 2) continue
            90 -> if (i == 0) continue
        }

        if (nextRotate == 45 && (array[x - 1][y] == 1 || array[x][y - 1] == 1)) continue

        DFS(x to y, end, nextRotate)
    }
}