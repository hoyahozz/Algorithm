val array = Array(100) { BooleanArray(100) }

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()

    repeat(n) {
        val input = readLine().split(" ").map { it.toInt() }

        val x = input[0]
        val y = input[1]

        for(i in x until x + 10) {
            for(j in y until y + 10) {
                array[i][j] = true
            }
        }
    }

    var count = 0

    repeat(100) { i ->
        repeat(100) { j ->
            if(array[i][j]) count++
        }
    }

    println(count)
}