fun main() = with(System.`in`.bufferedReader()) {
    val x = readLine().toInt()
    val dp = IntArray(x + 10)

    dp[1] = 1
    dp[2] = 2
    dp[3] = 4

    for (i in 4 until dp.size) {
        dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3]
    }

    repeat(x) {
        println(dp[readLine().toInt()])
    }
}
