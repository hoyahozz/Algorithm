fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val dp = Array(n + 1) { Turn.CY }.apply {
        this[1] = Turn.SK
        if(n >= 2) this[2] = Turn.CY
    }

    for(i in 3..n) {
        dp[i] = dp[i % 2]
    }

    println(dp[n])
}

enum class Turn {
    SK, CY
}
