fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()

    val numbers = ("0 " + readLine()).split(" ").map { it.toInt() }
    val dp = IntArray(n + 1)

    dp[1] = numbers[1]

    for (i in 2 until numbers.size) {
        val curr = numbers[i]

        for (j in 0 until i) {
            if (numbers[j] < curr) {
                dp[i] = maxOf(dp[i], dp[j] + numbers[i])
            }
        }
    }

    println(dp.maxOrNull())
}

