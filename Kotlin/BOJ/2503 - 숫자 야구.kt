fun main() = with(System.`in`.bufferedReader()) {
    val inputs = ArrayList<Baseball>()
    var answer = 0

    repeat(readLine().toInt()) {
        val input = readLine().split(" ").map { it.toInt() }
        inputs.add(Baseball(input[0].toString(), input[1], input[2]))
    }

    loop@for (i in 100..999) {
        val target = i.toString()
        if(target.contains('0')) continue@loop

        for(x in 0 until 3) {
            for(y in x + 1 until 3) {
                if(target[x] == target[y]) continue@loop
            }
        }

        for (input in inputs) {
            if(!check(target, input)) continue@loop
        }
        answer++
    }
    println(answer)
}

fun check(target: String, baseball: Baseball): Boolean {
    var strike = 0
    var ball = 0

    repeat(3) { i ->
        if (baseball.number[i] == target[i])
            strike++
    }

    repeat(3) { i ->
        repeat(3) { j ->
            if(i != j && baseball.number[i] == target[j]) {
                ball++
            }
        }
    }

    return baseball.ball == ball && baseball.strike == strike
}

data class Baseball(
    val number: String,
    val strike: Int,
    val ball: Int
)

