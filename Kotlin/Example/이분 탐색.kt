val array = intArrayOf(1, 3, 3, 5, 7)

fun main() = with(System.`in`.bufferedReader()) {
    val target = readLine().toInt()

    println(binarySearch(target))
    println(upperBound(target))
    println(lowerBound(target))
}

fun binarySearch(target: Int): Int {
    var low = 0
    var high = array.lastIndex

    while (low <= high) {
        val middle = (high + low) / 2

        when {
            array[middle] == target -> return middle
            array[middle] < target -> low = middle + 1
            else -> high = middle - 1
        }
    }

    return -1
}

// key 보다 큰 첫 위치 반환
fun upperBound(target: Int): Int {
    var low = 0
    var high = array.size

    while (low < high) {
        val middle = (low + high) / 2

        when {
            array[middle] <= target -> low = middle + 1
            else -> high = middle
        }
    }
    return high
}

// key 보다 크거나 같은 첫 위치 반환
fun lowerBound(target: Int): Int {
    var low = 0
    var high = array.size

    while (low < high) {
        val middle = (low + high) / 2

        when {
            array[middle] < target -> low = middle + 1
            else -> high = middle
        }
    }

    return high
}