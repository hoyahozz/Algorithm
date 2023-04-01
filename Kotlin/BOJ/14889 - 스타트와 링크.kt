import kotlin.math.abs
import kotlin.system.exitProcess

var n = 0
lateinit var array: Array<List<Int>>
lateinit var visited: BooleanArray
var answer = Int.MAX_VALUE
val sb = StringBuilder()

fun main() = with(System.`in`.bufferedReader()) {
    n = readLine().toInt()
    array = Array(n) { readLine().split(" ").map { it.toInt() } }
    visited = BooleanArray(n)


    backTracking(0, 0)

    sb.append(answer)
    println(sb)
}

fun backTracking(index: Int, count: Int) {
    if (count == n / 2) {
        getDiff()
        return
    }

    for (i in index until n) {
        if (!visited[i]) {
            visited[i] = true
            backTracking(i + 1, count + 1)
            visited[i] = false
        }
    }
}

fun getDiff() {
    var start = 0
    var link = 0

    for (i in 0 until n - 1) {
        for (j in i + 1 until n) {
            if (visited[i] && visited[j]) {
                start += array[i][j] + array[j][i]
            } else if (!visited[i] && !visited[j]) {
                link += array[i][j] + array[j][i]
            }
        }
    }

    answer = answer.coerceAtMost(abs(start - link))

    if (answer == 0) {
        sb.append(answer)
        println(sb)
        exitProcess(0)
    }
}