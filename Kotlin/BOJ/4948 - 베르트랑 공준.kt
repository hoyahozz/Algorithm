import java.io.BufferedReader
import java.io.InputStreamReader

const val MAX_VALUE = 123_456
val board = BooleanArray((MAX_VALUE * 2) + 1)

fun main() {
    initBoard()

    val br = BufferedReader(InputStreamReader(System.`in`))

    var N = br.readLine().toInt()

    while (N > 0) {
        var primeNumber = 0

        for (i in N + 1..(N * 2)) {
            if (!board[i] && i > 1) primeNumber++
        }

        println(primeNumber)

        N = br.readLine().toInt()
    }
}

fun initBoard() {
    for (number in 2 until board.size) {
        if (board[number]) continue

        for (i in number * 2 until board.size step (number)) board[i] = true
    }
}