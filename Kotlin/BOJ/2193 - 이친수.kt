fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val d = Array(n+1) { LongArray(2) { 0 } }
    d[1][1] = 1

    for (i in 2..n) {
        d[i][0] = d[i-1][0] + d[i-1][1]
        d[i][1] = d[i-1][0]
    }

    println(d.contentDeepToString())

    print("${d[n][0] + d[n][1]}")
}