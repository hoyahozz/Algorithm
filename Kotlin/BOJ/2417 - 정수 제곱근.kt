import kotlin.math.pow

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toLong()
    println(binarySearch(n))
}

fun binarySearch(n: Long): Long {
    var low: Long = 0
    var high: Long = n
    var min = Long.MAX_VALUE

    while (low <= high) {
        val middle = (low + high) / 2
        val sqrt = middle.toDouble().pow(2.0)

        if (sqrt < n) {
            println("if")
            low = middle + 1
        } else {
            println("else")
            min = min.coerceAtMost(middle)
            high = middle - 1
        }
    }

    return min
}