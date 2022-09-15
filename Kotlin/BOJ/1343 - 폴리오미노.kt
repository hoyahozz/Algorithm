fun main() = with(System.`in`.bufferedReader()) {
    val boards = readLine()

    withReplace(boards)
    withGreedy(boards)
}

fun withReplace(boards: String) {
    val boards = boards.replace("XXXX", "AAAA", true).replace("XX", "BB", true)
    if (boards.contains('X')) println(-1) else println(boards)
}

fun withGreedy(boards: String) {
    var answer = ""
    val boards = boards.split(".")

    for (p in boards) {
        var part = p
        if (part.length % 2 != 0) {
            println(-1)
            return
        }
        while (part.isNotEmpty()) {
            if (part.length >= 4) {
                answer += "AAAA"
                part = part.removeRange(0..3)
            } else if (part.length >= 2) {
                answer += "BB"
                part = part.removeRange(0..1)
            }
        }
        answer += "."
    }

    if (answer.isNotEmpty()) println(answer.dropLast(1))
}
