lateinit var array: Array<IntArray>
lateinit var visited: BooleanArray
var isAnswer = false

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()
    val (n, m) = readLine().split(" ").map { it.toInt() }

    array = Array(n) { intArrayOf() }
    visited = BooleanArray(n)

    repeat(m) {
        val input = readLine().split(" ").map { it.toInt() }
        array[input[0]] += intArrayOf(input[1])
        array[input[1]] += intArrayOf(input[0])
    }

    repeat(n) {
        DFS(it, 0)
        if (isAnswer) return@repeat
    }

    sb.append(if (isAnswer) 1 else 0)
    println(sb)
}

fun DFS(start: Int, depth: Int) {
    visited[start] = true
    if (depth >= 4) {
        isAnswer = true
        return
    }

    for (i in array[start]) {
        if (!visited[i]) {
            DFS(i, depth + 1)
        }
    }

    visited[start] = false
}
