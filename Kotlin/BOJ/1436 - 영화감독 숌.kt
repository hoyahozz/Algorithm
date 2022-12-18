fun main() = with(System.`in`.bufferedReader()) {
    val N = readLine().toInt()
    var number = 0L
    var count = 0

    while (count != N) {
        number++

        if (number.toString().contains("666")) {
            count++
        }
    }

    println(number)
}
