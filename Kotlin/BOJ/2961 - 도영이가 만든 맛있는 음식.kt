import java.util.*
import kotlin.math.abs

val tastes = ArrayList<Pair<Long, Long>>()
var min = Long.MAX_VALUE
lateinit var visited: BooleanArray

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()

    repeat(n) {
        readLine().split(" ").map { it.toLong() }.run {
            tastes.add(this[0] to this[1])
        }
    }

    visited = BooleanArray(tastes.size)
    DFS(0, 1, 0, true, "")
    println(min)
}

fun DFS(start: Int, sour: Long, hot: Long, isFirst: Boolean, test: String) {
    if(!isFirst) min = min.coerceAtMost(abs(sour - hot))

    for(i in start until visited.size) {
        if(!visited[i]) {
            visited[i] = true
            DFS(i, sour * tastes[i].first, hot + tastes[i].second, false, "$test + $i")
            visited[i] = false
        }
    }
}
