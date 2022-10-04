fun main() = with(System.`in`.bufferedReader()) {
    var n = readLine().toLong()
    var i = 2

    while (i <= n) {
        if (n % i == 0L) {
            println(i)
            n /= i
            continue
        }
        i++
    }
}
