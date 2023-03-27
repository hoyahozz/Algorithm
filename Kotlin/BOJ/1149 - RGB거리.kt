fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val rgbs = ArrayList<RGB>()
    val dp = Array(n + 1) { IntArray(3) }

    repeat(n) {
        val input = readLine().split(" ").map { it.toInt() }
        rgbs.add(RGB(input[0], input[1], input[2]))
    }

    for (i in 1 until n + 1) {
        dp[i][0] = rgbs[i - 1].red + minOf(dp[i - 1][1], dp[i - 1][2])
        dp[i][1] = rgbs[i - 1].green + minOf(dp[i - 1][0], dp[i - 1][2])
        dp[i][2] = rgbs[i - 1].blue + minOf(dp[i - 1][0], dp[i - 1][1])
    }

    println(minOf(dp[n][0], dp[n][1], dp[n][2]))
}

data class RGB(
    val red: Int,
    val green: Int,
    val blue: Int,
)