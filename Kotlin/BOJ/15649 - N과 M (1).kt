lateinit var visited: BooleanArray

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    visited = BooleanArray(n + 1)

    DFS(n, m, "")
}

fun DFS(n: Int, m: Int, sequence: String) {
    if (sequence.length >= m) {
        for (c in sequence) {
            print("$c ")
        }
        println()
        return
    }

    for (i in 1..n) {
        if (!visited[i]) {
            visited[i] = true
            DFS(n, m, sequence + "$i")
            visited[i] = false
        }
    }
}
