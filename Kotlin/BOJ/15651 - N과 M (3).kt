lateinit var visited: BooleanArray
val sb = StringBuilder()

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    visited = BooleanArray(n + 1)

    DFS(n, m, "")

    println(sb)
}

fun DFS(n: Int, m: Int, sequence: String) {

    if (sequence.length >= m) {
        for (c in sequence) {
            sb.append("$c ")
        }
        sb.append("\n")
        return
    }

    for (i in 1..n) {
        DFS(n, m, sequence + "$i")
    }
}
