fun main() = with(System.`in`.bufferedReader()) {
    val S = readLine().toLong()
    println(binarySearch(1, S, S))
}

fun binarySearch(low: Long, high: Long, target: Long): Long {
    // n(n + 1) / 2 -> 수의 합
    var low = low
    var high = high
    var answer = 0L

    while (low <= high) {
        val middle = (low + high) / 2
        val number = middle * (middle + 1) / 2
        when {
            number <= target -> {
                low = middle + 1
                answer = middle
            }
            else -> high = middle - 1
        }
    }

    return answer
}