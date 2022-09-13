fun main() = with(System.`in`.bufferedReader()) {

    val t = readLine().toInt()

    repeat(t) {
        val (n, m) = readLine().split(" ").map { it.toInt() }

        val A = readLine().split(" ").map { it.toInt() }.sorted()
        val B = readLine().split(" ").map { it.toInt() }.sorted()
        getCount(A, B)
    }
}

fun getCount(A: List<Int>, B: List<Int>) {
    var count = 0

    for (a in A) {
        count += lowerBound(a, B)
    }

    println(count)
}

fun lowerBound(target: Int, B: List<Int>): Int {
    var low = 0
    var high = B.size

    while (low < high) {
        val middle = (low + high) / 2

        if (B[middle] < target) low = middle + 1
        else high = middle
    }

    return high
}