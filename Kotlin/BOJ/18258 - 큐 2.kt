class Queue(num: Int) {

    private val queue = IntArray(num)
    private var front = 0
    private var rear = 0

    fun empty() = (front == rear)
    fun size() = rear - front

    fun push(value: Int) {
        queue[rear++] = value
    }

    fun pop(): Int {
        if (empty()) return -1

        return queue[front++]
    }

    fun front(): Int {
        if (empty()) return -1

        return queue[front]
    }

    fun back(): Int {
        if (empty()) return -1

        return queue[rear - 1]
    }
}

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val sb = StringBuilder()

    val queue = Queue(n)

    for (i in 0 until n) {
        val command = readLine().split(" ")

        if (command.size == 2) {
            queue.push(command[1].toInt())
            continue
        }

        when (command[0]) {
            "pop" -> sb.append(queue.pop()).append("\n")
            "size" -> sb.append(queue.size()).append("\n")
            "empty" -> sb.append("${if (queue.empty()) 1 else 0}").append("\n")
            "front" -> sb.append(queue.front()).append("\n")
            "back" -> sb.append(queue.back()).append("\n")
        }
    }

    println(sb)
}