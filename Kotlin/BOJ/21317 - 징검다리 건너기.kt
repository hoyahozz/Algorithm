fun main() = with(System.`in`.bufferedReader()) {
    val N = readLine().toInt()
    val energies = Array(30) { 0 to 0 }
    val dp = Array(30) { IntArray(2) }

    repeat(N - 1) {
        val input = readLine().split(" ").map { it.toInt() }
        energies[it + 1] = input[0] to input[1]
    }

    for(i in 2..N) {
        dp[i][0] = 1000000
        dp[i][1] = 1000000
    }

    val K = readLine().toInt()

    dp[2][0] = energies[1].first
    dp[3][0] = minOf((energies[1].first + energies[2].first), energies[1].second)

    for (i in 4..N) {
        dp[i][0] = minOf((dp[i - 1][0] + energies[i - 1].first), dp[i - 2][0] + energies[i - 2].second)
        dp[i][1] = minOf(minOf((dp[i - 1][1] + energies[i - 1].first), dp[i - 2][1] + energies[i - 2].second), dp[i - 3][0] + K)
    }

    println(minOf(dp[N][0], dp[N][1]))
}
