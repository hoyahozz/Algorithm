fun main() = with(System.`in`.bufferedReader()) {
    val N = readLine().toInt()
    val moneys = readLine().split(" ").map { it.toInt() }
    val M = readLine().toLong()

    if (moneys.sum() <= M)
        println(getHigh(moneys))
    else
        println(binarySearch(moneys, M) - 1)
}

fun binarySearch(items: List<Int>, target: Long): Int {
    var low = 1
    var high = getHigh(items)
    val moneys = ArrayList<Int>()

    while (low < high) {
        val middle = (low + high) / 2

        moneys.addAll(items)

        for (i in moneys.indices) {
            if (middle < moneys[i]) {
                moneys[i] = middle
            }
        }

        val sum = moneys.sum()

        if (sum <= target) low = middle + 1
        else high = middle

        moneys.clear()
    }

    return high
}

fun getHigh(moneys: List<Int>): Int {
    var high = 0
    for (money in moneys) if (high < money) high = money
    return high
}