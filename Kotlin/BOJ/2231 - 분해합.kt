fun main() {
    val N = readLine()!!.toInt()
    var count = 0

    for(i in 0 until N) {
        var value = i

        var sum = value // 초기값 지정

        while(value > 0) {
            sum += value % 10
            value /= 10
        }

        if(sum == N) {
            count = i
            break
        }
    }

    println(count)
}