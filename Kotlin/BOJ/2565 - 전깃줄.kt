fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val electric = IntArray(501) { 0 }
    val dp = IntArray(501)

    repeat(n) {
        val (index, value) = readLine().split(" ").map { it.toInt() }
        electric[index] = value
    }

    for (i in 1 until 501) {
        val curr = electric[i]

        for (j in 0 until i) {
            if (curr > electric[j]) {
                dp[i] = maxOf(dp[i], dp[j] + 1)
            }
        }
    }

    println(n - dp.maxOrNull()!!)
}

/*

8
1 8
3 9
2 2
4 1
6 4
10 10
9 7
7 6

6
1 8
2 9
4 4
5 2
6 1
7 5

5
3 4
1 5
4 2
2 3
5 1
 */