import java.io.*
import java.util.*

/**
 * 백준 1406번: 에디터
 */
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val initialText = br.readLine()
    val m = br.readLine().toInt()
    val commands = Array(m) { br.readLine() }
    val result = solution(initialText, commands)

    bw.write(result)
    bw.flush()
    bw.close()
}

fun solution(initialText: String, commands: Array<String>): String {
    val sb = StringBuilder()
    val linkedList = LinkedList<Char>()

    initialText.forEach { linkedList.add(it) }
    val iter = linkedList.listIterator(linkedList.size)

    commands.forEach { command ->
        val parts = command.split(" ")
        val char = parts[0].single()
        val value = parts.getOrNull(1)?.single()

        when (char) {
            'L' ->
                if (iter.hasPrevious()) iter.previous()

            'D' ->
                if (iter.hasNext()) iter.next()

            'B' -> {
                if (iter.hasPrevious()) {
                    iter.previous()
                    iter.remove()
                }
            }

            'P' -> {
                requireNotNull(value)
                iter.add(value)
            }
        }
    }

    linkedList.forEach { sb.append(it) }
    return sb.toString()
}
