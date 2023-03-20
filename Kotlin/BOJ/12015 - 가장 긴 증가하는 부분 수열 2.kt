fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()

    val numbers = readLine().split(" ").map { it.toInt() }
    val dp = ArrayList<Int>()

    dp.add(numbers[0])

    for (i in 1 until numbers.size) {
        val index = lowerBound(numbers[i], dp)

        if (dp.size <= index) dp.add(numbers[i])
        else dp[index] = numbers[i]
    }

    println(dp.size)
}

fun lowerBound(target: Int, dp: ArrayList<Int>): Int {
    var low = 0
    var high = dp.size

    while (low < high) {
        val middle = (low + high) / 2

        if (dp[middle] < target) low = middle + 1
        else high = middle
    }

    return high
}