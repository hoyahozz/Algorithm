fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    var cards = readLine().split(" ").map { it.toInt() }
    val m = readLine().toInt()
    val propose = readLine().split(" ").map { it.toInt() }

    val answer = ArrayList<Int>()

    cards = cards.sorted()

    for (i in propose) {
        answer.add(binarySearch(cards, i))
    }

    for (ans in answer) {
        print("$ans ")
    }
}

fun binarySearch(cards: List<Int>, target: Int): Int {
    var low = 0
    var high = cards.lastIndex

    while (low <= high) {
        val middle = (low + high) / 2

        when {
            cards[middle] == target -> return 1
            cards[middle] <= target -> low = middle + 1
            else -> high = middle - 1
        }
    }

    return 0
}