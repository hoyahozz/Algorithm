fun main() = with(System.`in`.bufferedReader()) {
    val (s, c) = readLine().split(" ").map { it.toInt() }
    val length = ArrayList<Long>()
    var answer = 0L

    repeat(s) {
        length.add(readLine().toLong())
    }

    val high = binarySearch(length, c) - 1

    var sumCount = 0L
    for (len in length) {
        val count = len / high
        sumCount += count
        answer += len - (high * count)
    }

    if (c < sumCount) println(high)
    else println(answer)
}

fun binarySearch(length: ArrayList<Long>, c: Int): Long {
    var low = 1L
    var high = length.maxOrNull()!! + 1

    while (low < high) {
        val middle = (low + high) / 2

        var count = 0L

        for (len in length) {
            count += len / middle
        }

        if (c <= count) low = middle + 1
        else high = middle
    }

    return high
}
