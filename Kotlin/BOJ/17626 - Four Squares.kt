fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val dp = IntArray(n + 1)
    dp[1] = 1

    for (i in 2 until dp.size) {
        var min = Integer.MAX_VALUE

        for (j in 1..i) {
            if (j * j > i) break

            val temp = i - j * j
            min = minOf(min, dp[temp])
        }

        dp[i] = min + 1
    }

    println(dp.last())
}
