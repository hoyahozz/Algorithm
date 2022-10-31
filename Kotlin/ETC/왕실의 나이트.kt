fun main() = with(System.`in`.bufferedReader()) {
    val input = readLine()
    val row = Character.getNumericValue(input[1])
    val column = input[0] - 'a' + 1
    var count = 0

    val dx = arrayOf(-2, -1, 1, 2, 2, 1, -1, -2)
    val dy = arrayOf(-1, -2, -2, -1, 1, 2, 2, 1)

    for(i in 0 until 8) {
        val nextRow = row + dx[i]
        val nextColumn = column + dy[i]

        if(nextRow in 1..8 && nextColumn in 1..8) {
            count++
        }
    }

    println(count)
}
