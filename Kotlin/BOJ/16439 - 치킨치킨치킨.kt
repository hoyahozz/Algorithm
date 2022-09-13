import java.io.BufferedReader

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val array = Array(n) { IntArray(m) }

    initArray(n, m, array, this)
    println(bruteForce(n, m, array))
}

fun initArray(n: Int, m: Int, array: Array<IntArray>, br: BufferedReader) {
    repeat(n) { n ->
        val scores = br.readLine().split(" ").map { it.toInt() }
        repeat(m) { m ->
            array[n][m] = scores[m]
        }
    }
}

fun bruteForce(n: Int, m: Int, array: Array<IntArray>) : Int {
    var max = 0
    for(i in 0 until m - 2) {
        for(j in i + 1 until m - 1) {
            for(k in j + 1 until m) {
                var sum = 0
                for(l in 0 until n) {
                    sum += maxOf(array[l][i], array[l][j], array[l][k])
                }
                if(max < sum) max = sum
            }
        }
    }

    return max
}