import java.util.Stack

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()

    loop@for(i in 0 until n) {
        val str = readLine()
        val stack = Stack<Char>()

        for(ch in str) {
            when (ch) {
                '(' -> stack.push(ch)
                ')' -> {
                    if(stack.isEmpty()) {
                        println("NO")
                        continue@loop
                    } else {
                        stack.pop()
                    }
                }
            }
        }

        if(stack.isEmpty()) println("YES")
        else println("NO")
    }
}