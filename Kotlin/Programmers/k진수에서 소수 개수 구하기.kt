import kotlin.math.sqrt

fun main() = with(System.`in`.bufferedReader()) {
    val (n, k) = readLine().split(" ").map { it.toInt() }

    val stringNumber = n.toString(k)
    var count = 0

    for (s in stringNumber.split("0")) {
        if (s.isEmpty()) continue

        if (isPrimeNumber(s.toLong())) count++
    }

    println(count)
}

fun isPrimeNumber(n: Long): Boolean {
    if (n == 1L) return false

    for (i in 2..sqrt(n.toDouble()).toInt()) {
        if (n % i == 0L) return false
    }

    return true
}
