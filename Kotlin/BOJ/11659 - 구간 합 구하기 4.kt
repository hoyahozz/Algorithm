fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()

    val (N, M) = readLine().split(" ").map { it.toInt() }

    val numbers = readLine().split(" ").map { it.toInt() }
    val sumArray = IntArray(N + 1)

    for(i in 1 until sumArray.size) {
        sumArray[i] += (sumArray[i - 1] + numbers[i - 1])
    }

    repeat(M) {
        val (left, right) = readLine().split(" ").map { it.toInt() }

        sb.append(sumArray[right] - sumArray[left - 1]).append("\n")
    }

    print(sb)
}
