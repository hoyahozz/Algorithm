import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val (N, K) = readLine().split(" ").map { it.toInt() }
    val queue: Queue<Int> = LinkedList()
    val sb = StringBuilder()

    repeat(N) { queue.offer(it + 1) }

    sb.append("<")
    while (queue.isNotEmpty()) {
        repeat(K - 1) { queue.offer(queue.poll()) }

        sb.append(queue.poll()).append(", ")
    }

    sb.delete(sb.length - 2, sb.length)
    sb.append(">")

    println(sb)
}