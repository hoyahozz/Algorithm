import java.util.Queue
import java.util.LinkedList

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val queue: Queue<Int> = LinkedList()

    repeat(n) {
        queue.add(it + 1)
    }

    while(queue.size != 1) {
        queue.poll()
        queue.add(queue.poll())
    }

    println(queue.peek())
}