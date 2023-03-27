fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val numbers = Array(n) { ArrayList<Int>() }
    val dp = Array(n) { ArrayList<Int>() }

    repeat(n) {
        val input = readLine().split(" ").map { it.toInt() }
        numbers[it].addAll(input)
    }

    dp[0].add(numbers[0][0])

    for (i in 1 until n) {
        numbers[i].forEachIndexed { j, value ->
            if (j == 0) {
                dp[i].add(dp[i - 1][0] + value)
            } else if (j == numbers[i].lastIndex) {
                dp[i].add(dp[i - 1][j - 1] + value)
            } else {
                dp[i].add(maxOf(dp[i - 1][j], dp[i - 1][j - 1]) + value)
            }
        }
    }

    println(dp[n - 1].maxOrNull()!!)
}
