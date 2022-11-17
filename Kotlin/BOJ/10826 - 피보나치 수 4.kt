import java.math.BigInteger

lateinit var d: Array<BigInteger>

fun main() = with(System.`in`.bufferedReader()) {

    val n = readLine().toInt()

    d = Array(n + 1) { BigInteger.ZERO }

    if (n > 2) {
        d[0] = BigInteger.valueOf(1)
        d[1] = BigInteger.valueOf(1)
    }

    println(fibo(n))
}

fun fibo(n: Int): BigInteger {
    return when(n) {
        0 -> BigInteger.valueOf(0)
        in 1..2 -> BigInteger.valueOf(1)
        else -> {
            for (i in 2 until n) {
                d[i] = d[i - 1] + d[i - 2]
            }

            d[n - 1]
        }
    }
}