fun main() {
    val tmp = readLine()!!.split(" ")

    val N = tmp[0].toInt()
    val M = tmp[1].toInt()

    val numbers = readLine()!!.split(" ").map { it.toInt() }
    var answer = 0

    for(i in 0 until N - 2) {
        for(j in i + 1 until N - 1) {
            for(k in j + 1 until N) {
                val sum = numbers[i] + numbers[j] + numbers[k]
                if(sum in (answer)..M) answer = sum
            }
        }
    }

    println(answer)
}