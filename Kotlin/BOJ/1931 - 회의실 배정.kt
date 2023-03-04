lateinit var times: Array<Pair<Int, Int>>

fun main() = with(System.`in`.bufferedReader()) {
    var answer = 0
    val n = readLine().toInt()
    times = Array(n) { Pair(0, 0) }
    var endTime = -1

    repeat(n) {
        val (a, b) = readLine().split(" ").map { it.toInt() }
        times[it] = Pair(a, b)
    }

    times.sortWith(compareBy<Pair<Int, Int>> { it.second }.thenBy { it.first })

    times.forEach {
        if (it.first >= endTime) {
            answer++
            endTime = it.second
        }
    }

    println(answer)
}
