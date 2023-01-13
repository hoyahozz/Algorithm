lateinit var visited: BooleanArray
val sb = StringBuilder()

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    visited = BooleanArray(n + 1)

    DFS(n, m, 1, "")

    println(sb)
}

fun DFS(n: Int, m: Int, start: Int, sequence: String) {

    if (sequence.length >= m) {
        for (c in sequence) {
            sb.append("$c ")
        }
        sb.append("\n")
        return
    }

    for (i in start..n) {
        DFS(n, m, i, sequence + "$i")
    }
}
