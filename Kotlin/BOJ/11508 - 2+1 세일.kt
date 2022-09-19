fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val milks = IntArray(n)
    var answer = 0

    repeat(n) {
        milks[it] = readLine().toInt()
    }

    milks.sortDescending()

    for(i in milks.indices) {
        if(i % 3 != 2) answer += milks[i]
    }

    println(answer)
}
