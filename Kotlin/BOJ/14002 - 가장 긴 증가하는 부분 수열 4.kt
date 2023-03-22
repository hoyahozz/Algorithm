fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()

    val numbers = (readLine()).split(" ").map { it.toInt() }
    val dp = Array(n) { arrayListOf(numbers[it]) }
    var max = 0
    var maxIndex = 0

    for (i in 1 until numbers.size) {
        val curr = numbers[i]
        var next = ArrayList<Int>()

        for (j in 0 until i) {
            if (numbers[j] < curr) {
                if(next.size < dp[j].size + 1) {
                    next = dp[j]
                }
            }
        }

        dp[i] += next
    }

    for(i in 0 until n) {
        if(max < dp[i].size) {
            maxIndex = i
            max = dp[i].size
        }
    }

    println(dp[maxIndex].size)

    dp[maxIndex].sorted().forEach {
        print("$it ")
    }
}

/*
7
1 6 2 4 5 3 7
 */