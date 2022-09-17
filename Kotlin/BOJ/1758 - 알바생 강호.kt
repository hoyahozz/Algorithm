fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val tips = IntArray(n)
    var result = 0L

    for (i in 0 until n) {
        tips[i] = readLine().toInt()
    }

    tips.sortDescending()

    var order = 0
    for (tip in tips) {
        if (tip - order > 0) {
            result += (tip - order)
        }
        order++
    }

    println(result)
}
