fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val cantListen = HashSet<String>()
    val answers = ArrayList<String>()
    val sb = StringBuilder()

    repeat(n) { cantListen.add(readLine()) }

    repeat(m) {
        readLine().apply {
            if (cantListen.contains(this)) answers.add(this)
        }
    }

    sb.appendLine(answers.size)
    answers.sorted().forEach { sb.appendLine(it) }

    println(sb)
}
