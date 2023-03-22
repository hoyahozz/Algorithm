fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val mod = 1_000_000_000L
    val dp = Array(n + 1) { LongArray(10) }

    for (i in 0 until 10) dp[1][i] = 1L

    for (i in 2 until n + 1) {

        for (j in 0 until 10) {
            when(j) {
                0 -> dp[i][j] += dp[i - 1][1]
                9 -> dp[i][j] += dp[i - 1][8]
                else -> dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % mod
            }
        }
    }

    println((dp[n].sum() - dp[n][0]) % mod)
}
