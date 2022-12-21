import java.util.*

val stack = Stack<Int>()
var currentLimit = 0
val sb = StringBuilder()

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()


    loop@ for(i in 0 until n) {
        val input = readLine().toInt()

        if (currentLimit < input) {
            repeat(input - currentLimit) { push(++currentLimit) }
            pop()
        } else if(currentLimit == input) {
            sb.clear().append("NO")
            break@loop
        } else {
            while (true) {
                if (stack.isNotEmpty()) {
                    if (stack.peek() == input) {
                        pop()
                        break
                    }
                    pop()
                } else {
                    sb.clear().append("NO")
                    break@loop
                }
            }
        }
    }

    print(sb)
}

fun push(input: Int) {
    stack.push(input)
    sb.append("+\n")
}

fun pop() {
    stack.pop()
    sb.append("-\n")
}
