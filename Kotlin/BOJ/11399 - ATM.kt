fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val minutes = readLine().split(" ").map { it.toInt() }.sorted()
    var answer = 0

    for (i in minutes.indices) {
        var sum = 0
        for (j in 0..i) {
            sum += minutes[j]
        }
        answer += sum
    }

    println(answer)
}
