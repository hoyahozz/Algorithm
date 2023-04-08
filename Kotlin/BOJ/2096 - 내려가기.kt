val dx = intArrayOf(-1, 0, 1)

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    var numbers: List<Int>
    val save = Array(3) { Score(0, 0) }
    val dp = Array(3) { Score(0, 0) }

    var answerMin = Int.MAX_VALUE
    var answerMax = Int.MIN_VALUE

    repeat(n) {
        numbers = readLine().split(" ").map { it.toInt() }

        for (j in 0 until 3) {
            var min = Int.MAX_VALUE
            var max = Int.MIN_VALUE

            for (k in 0 until 3) {
                val y = j + dx[k]

                if (y !in 0 until 3) continue

                min = minOf(min, dp[y].min)
                max = maxOf(max, dp[y].max)
            }

            save[j].min = numbers[j] + min
            save[j].max = numbers[j] + max
        }

        for (j in 0 until 3) {
            dp[j].min = save[j].min
            dp[j].max = save[j].max
        }
    }


    for (i in 0 until 3) {
        answerMax = maxOf(answerMax, dp[i].max)
        answerMin = minOf(answerMin, dp[i].min)
    }

    print("$answerMax $answerMin")
}

data class Score(
    var min: Int,
    var max: Int
)
