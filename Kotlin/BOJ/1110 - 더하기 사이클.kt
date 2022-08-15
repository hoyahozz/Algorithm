fun main() {
    val n = readLine()!!.toInt()
    var count = 0
    var result = n

    if(n == 0) {
        print(1)
        return
    }

    while(true) {
        val first = result / 10
        val second = result % 10

        val sum = if(first + second >= 10) (first + second) % 10 else first + second

        result = (second * 10) + sum
        count++

        if(result == n) break
    }

    print(count)
}