import kotlin.math.abs
import kotlin.math.round

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val sb = StringBuilder()
    val numbers = ArrayList<Int>()
    val hashMap = HashMap<Int, Int>()

    var max = Integer.MIN_VALUE
    var min = Integer.MAX_VALUE
    var sum = 0

    repeat(n) {
        val input = readLine().toInt()

        if (input > max) max = input
        if (input < min) min = input

        sum += input

        hashMap[input] = hashMap.getOrDefault(input, 0) + 1
        numbers.add(input)
    }

    numbers.sort()

    sb.append(avg(sum, n)).append("\n")
    sb.append(center(numbers)).append("\n")
    sb.append(many(hashMap)).append("\n")
    sb.append(range(max, min)).append("\n")

    println(sb)
}

fun avg(sum: Int, n: Int): Int = round(sum.toDouble() / n.toDouble()).toInt()

fun center(numbers: ArrayList<Int>): Int {
    return when {
        numbers.size % 2 == 0 -> {
            numbers[numbers.size / 2 - 1]
        }
        else -> {
            numbers[(numbers.size / 2)]
        }
    }
}

fun many(hashMap: HashMap<Int, Int>): Int {
    var max = 0
    val arrList = ArrayList<Int>()

    for (value in hashMap.values) {
        if (max < value) max = value
    }

    for (key in hashMap.keys.sorted()) {
        if (hashMap[key] == max) arrList.add(key)
    }

    arrList.sort()

    return if (arrList.size > 1) arrList[1]
    else arrList.first()
}

fun range(max: Int, min: Int): Int {
    return when {
        max < 0 -> {
            abs(min) - abs(max)
        }
        else -> {
            max - min
        }
    }
}