fun main() = with(System.`in`.bufferedReader()) {
    var (N, K) = readLine().split(" ").map { it.toInt() }
    val moneys = IntArray(N)
    var count = 0

    for (i in 0 until N) {
        moneys[i] = readLine().toInt()
    }

    for (i in N - 1 downTo 0) {
        if (moneys[i] <= K) {
            count += K / moneys[i]
            K %= moneys[i]
        }
    }

    println(count)
}
