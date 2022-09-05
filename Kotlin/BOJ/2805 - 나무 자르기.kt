lateinit var trees: List<Long>

fun main() = with(System.`in`.bufferedReader()) {
    val read = readLine().split(" ").map { it.toLong() }
    val N = read[0]
    val M = read[1]

    trees = readLine().split(" ").map { it.toLong() }

    println(binarySearch(M) - 1)
}

fun binarySearch(target: Long): Long {
    var low = 1L
    var high = getHigh()

    while (low < high) {
        val middle = (low + high) / 2
        var sum = 0L

        for (i in trees) {
            if (i - middle > 0) sum += (i - middle)
        }

        if (target <= sum) low = middle + 1
        else high = middle
    }

    return high
}

fun getHigh(): Long {
    var max = 0L
    for (i in trees) {
        if (max < i) max = i
    }

    return max
}