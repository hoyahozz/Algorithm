fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val drinks = readLine().split(" ").map { it.toDouble() }.sorted()

    val max = drinks.maxOrNull() ?: 0.0
    var answer: Double = max

    for(i in 0 until drinks.lastIndex) {
        answer += (drinks[i] / 2)
    }

    println(answer)
}
