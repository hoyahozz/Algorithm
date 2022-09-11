fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val moneys = ArrayList<Int>()

    repeat(n) {
        moneys.add(readLine().toInt())
    }

    println(binarySearch(moneys, m))
}

fun binarySearch(moneys: ArrayList<Int>, m: Int): Long {
    var low: Long = moneys.maxOrNull()!!.toLong()
    var high: Long = 100_000 * 10000

    while (low < high) {
        val middle = (low + high) / 2
        var count = 1
        var money = middle

        for (i in 0 until moneys.size) {
            if (money < moneys[i]) { // 현재 가지고 있는 금액으로 충당이 불가능할 때 현금 인출
                money = middle
                count++
            }
            money -= moneys[i]
        }

        if (count > m) {
            low = middle + 1
        } else {
            high = middle
        }
    }

    return high
}