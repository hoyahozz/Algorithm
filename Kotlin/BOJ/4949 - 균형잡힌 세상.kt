import java.util.Stack

fun main() = with(System.`in`.bufferedReader()) {

    while (true) {
        val input = readLine()
        if (input == ".") return

        val stack = Stack<Char>()

        var isBalanced = true

        input.forEach { ch ->
            when (ch) {
                '[' -> {
                    stack.push(ch)
                }
                '(' -> {
                    stack.push(ch)
                }
                ']' -> {
                    if (stack.isNotEmpty() && stack.peek() == '[') {
                        stack.pop()
                    } else {
                        isBalanced = false
                        return@forEach
                    }
                }
                ')' -> {
                    if (stack.isNotEmpty() && stack.peek() == '(') {
                        stack.pop()
                    } else {
                        isBalanced = false
                        return@forEach
                    }
                }

            }
        }

        if (stack.isNotEmpty())
            isBalanced = false

        when (isBalanced) {
            true -> println("yes")
            false -> println("no")
        }
    }
}