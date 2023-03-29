fun main() = with(System.`in`.bufferedReader()) {
    val (n, k) = readLine().split(" ").map { it.toInt() }

    val dp = Array(201) { IntArray(201) }

    for(i in 0 until 201) {
        dp[0][i] = 1
        dp[1][i] = i + 2
        dp[i][0] = i + 1
    }

    for(i in 2 until 201) {
        for(j in 1 until 201) {
            dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % 1_000_000_000
        }
    }

    println(dp[k - 1][n - 1])
}
