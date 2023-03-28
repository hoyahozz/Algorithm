fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val numbers = ("0 " + readLine()).split(" ").map { it.toInt() }

    val increaseDp = IntArray(n + 1)
    val decreaseDp = IntArray(n + 1)
    var max = 0

    increaseDp[1] = 1

    for (i in 2 until n + 1) {
        val curr = numbers[i]

        for (j in 0 until i) {
            if (numbers[j] < curr) {
                increaseDp[i] = maxOf(increaseDp[i], increaseDp[j] + 1)
            }
        }
    }

    for (i in n downTo 0) {
        val curr = numbers[i]

        for (j in i until n + 1) {
            if (numbers[j] < curr) {
                decreaseDp[i] = maxOf(decreaseDp[i], decreaseDp[j] + 1)
            }
        }
    }

    for(i in 1..n) {
        max = maxOf(max, increaseDp[i] + decreaseDp[i])
    }

    println(max)
}
