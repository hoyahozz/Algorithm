lateinit var array: Array<IntArray>
lateinit var visited: BooleanArray

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val sb = StringBuilder()

    array = Array(n + 1) { intArrayOf() }
    visited = BooleanArray(n + 1)

    repeat(m) {
        val (a, b) = readLine().split(" ").map { it.toInt() }
        array[b] += intArrayOf(a)
    }

    val x = readLine().toInt()

    sb.append(DFS(x) - 1)

    println(sb)
}

fun DFS(start: Int): Int {
    var level = 1

    if(visited[start]) return 0

    visited[start] = true

    for (i in array[start]) {
        if (!visited[i]) {
            level += DFS(i)
        }
    }

    return level
}