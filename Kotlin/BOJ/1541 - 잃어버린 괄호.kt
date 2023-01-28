fun main() = with(System.`in`.bufferedReader()) {
    var sum = 0
    val tmp = readLine().split("-").map {
        it.split("+").sumOf { it.toInt() }
    }

    for(i in tmp.indices) {
        if(i == 0) sum += tmp[i]
        else sum -= tmp[i]
    }

    println(sum)
}