lateinit var visited: BooleanArray

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    visited = BooleanArray(n + 1)

    DFS(n, m, 1, "")
}

fun DFS(n: Int, m: Int, start: Int, sequence: String) {

    if (sequence.length >= m) {
        for (c in sequence) {
            print("$c ")
        }
        println()
        return
    }

    for (i in start..n) {
        if (!visited[i]) {
            visited[i] = true
            DFS(n, m, i + 1, sequence + "$i")
            visited[i] = false
        }
    }
}
