fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val numbers = readLine().split(" ").map { it.toInt() }.toIntArray()
    val dp = ArrayList<Int>()

    dp.add(numbers[0])

    for (i in 1 until numbers.size) {
        val index = lowerBound(0, dp.size, numbers[i], dp)

        if(dp.size <= index) dp.add(numbers[i])
        else dp[index] = numbers[i]
    }

    println(dp.size)
}

fun lowerBound(start: Int, end: Int, target: Int, dp: ArrayList<Int>): Int {
    var left = start
    var right = end

    while (left < right) {
        val middle = (left + right) / 2

        if (dp[middle] < target) left = middle + 1
        else right = middle
    }

    return right
}

//5
//1 4 2 4 5
/*
9
5 4 3 1 6 7 2 8 9

7
7 6 5 4 3 2 1

8
1 5 10 3 13 18 15 16

10
1 5 10 3 13 18 19 15 16 17
 */