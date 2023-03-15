fun main() = with(System.`in`.bufferedReader()) {

    val n = readLine().toInt()
    val dp = IntArray(n + 1).apply {
        this[1] = 1
    }

    for (curr in 2 until dp.size) {
        var min = Integer.MAX_VALUE

        for (j in 1..curr) {
            if (j * j > curr) break

            val temp = curr - j * j
            min = minOf(min, dp[temp])
        }

        dp[curr] = min + 1
    }

    println(dp[n])
}

