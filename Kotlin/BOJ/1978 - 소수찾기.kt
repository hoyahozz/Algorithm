fun main() {
    val N = readLine()!!.toInt()
    val numbers = readLine()!!.split(" ").map { it.toInt() }
    var answer = 0

    for(number in numbers) {
        var count = 0
        for(i in 1..number) {
            if(number % i == 0) count++
        }

        if(count < 3 && number != 1) answer++
    }

    println(answer)
}