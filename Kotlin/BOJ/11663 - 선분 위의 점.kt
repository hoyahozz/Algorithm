fun main() = with(System.`in`.bufferedReader()) {

    val (n, m) = readLine().split(" ").map { it.toInt() }
    var coordinates = readLine().split(" ").map { it.toLong() }
    val sb = StringBuilder()

    coordinates = coordinates.sorted()

    repeat(m) {
        val (low, high) = readLine().split(" ").map { it.toLong() }

        val lowIndex = lowerBound(coordinates, low)
        val highIndex = upperBound(coordinates, high)

        sb.append("${highIndex - lowIndex}").append("\n")
    }
    println(sb)
}

fun lowerBound(coordinates: List<Long>, target: Long): Int {
    var low = 0
    var high = coordinates.size

    while (low < high) {
        val middle = (low + high) / 2

        if (coordinates[middle] < target) low = middle + 1
        else high = middle
    }

    return high
}

fun upperBound(coordinates: List<Long>, target: Long): Int {
    var low = 0
    var high = coordinates.size

    while (low < high) {
        val middle = (low + high) / 2

        if (coordinates[middle] <= target) low = middle + 1
        else high = middle
    }

    return high
}