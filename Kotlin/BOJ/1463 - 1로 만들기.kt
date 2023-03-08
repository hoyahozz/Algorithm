import kotlin.system.exitProcess

fun main() = with(System.`in`.bufferedReader()) {
    val x = readLine().toInt()
    val dp = IntArray(x + 1) { 1 }

    if(x == 1) {
        println(0)
        exitProcess(0)
    }

    for (i in 4..x) {
        when {
            i % 2 == 0 && i % 3 == 0 -> {
                dp[i] += dp[i - 1].coerceAtMost(dp[i / 2]).coerceAtMost(dp[i / 3])
            }
            i % 2 == 0 -> {
                dp[i] += dp[i - 1].coerceAtMost(dp[i / 2])
            }
            i % 3 == 0 -> {
                dp[i] += dp[i - 1].coerceAtMost(dp[i / 3])
            }
            else -> {
                dp[i] += dp[i - 1]
            }
        }
    }

    println(dp.last())
}
