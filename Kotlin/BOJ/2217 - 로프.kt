import kotlin.math.max

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val ropes = IntArray(n)

    for (i in 0 until n) {
        ropes[i] = readLine().toInt()
    }

    ropes.sort()

    var max = 0
    repeat(n) {
        max = max(max, ropes[it] * (n - it))
    }

    println(max)
}
