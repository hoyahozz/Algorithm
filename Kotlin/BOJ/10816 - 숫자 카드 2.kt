lateinit var cards: IntArray
lateinit var finds: IntArray

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()

    val n = readLine().toInt()
    cards = readLine().split(" ").map { it.toInt() }.toIntArray().sortedArray()

    val m = readLine().toInt()
    finds = readLine().split(" ").map { it.toInt() }.toIntArray()

    finds.forEach {
        sb.append("${upperBound(it) - lowerBound(it)} ")
    }

    println(sb)
}

// upperBound - lowerBound

fun upperBound(target: Int): Int {
    var low = 0
    var high = cards.size

    while (low < high) {
        val middle = (low + high) / 2

        if (cards[middle] <= target) low = middle + 1
        else high = middle
    }

    return high
}

fun lowerBound(target: Int): Int {
    var low = 0
    var high = cards.size

    while (low < high) {
        val middle = (low + high) / 2

        if (cards[middle] < target) low = middle + 1
        else high = middle
    }

    return high
}
