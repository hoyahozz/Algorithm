import kotlin.math.abs

lateinit var numbers: IntArray

// 차례대로 덧셈(+)의 개수, 뺄셈(-)의 개수, 곱셈(×)의 개수, 나눗셈(÷)의 개수
// 음수를 양수로 나눌 때는 C++14의 기준을 따른다. 즉, 양수로 바꾼 뒤 몫을 취하고, 그 몫을 음수로 바꾼 것과 같다.
lateinit var operatorSizes: IntArray
var max = Int.MIN_VALUE
var min = Int.MAX_VALUE

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    numbers = readLine().split(" ").map { it.toInt() }.toIntArray()
    operatorSizes = readLine().split(" ").map { it.toInt() }.toIntArray()

    backTracking(n, 0, "")

    println(max)
    println(min)
}

fun backTracking(n: Int, depth: Int, operators: String) {
    if (depth == n - 1) {
        val result = operating(operators)

        max = maxOf(max, result)
        min = minOf(min, result)

        return
    }

    for (i in 0 until 4) {
        if (operatorSizes[i] != 0) {
            operatorSizes[i] -= 1
            var operator = ""

            when (i) {
                0 -> operator = "+"
                1 -> operator = "-"
                2 -> operator = "*"
                3 -> operator = "/"
            }

            backTracking(n, depth + 1, operators + operator)
            operatorSizes[i] += 1
        }
    }
}

fun operating(operators: String): Int {
    var result = numbers[0]

    operators.forEachIndexed { index, operator ->
        when (operator) {
            '+' -> result += numbers[index + 1]
            '-' -> result -= numbers[index + 1]
            '*' -> result *= numbers[index + 1]
            '/' ->
                if (result < 0) result = (abs(result) / numbers[index + 1]) * -1
                else result /= numbers[index + 1]
        }
    }

    return result
}
