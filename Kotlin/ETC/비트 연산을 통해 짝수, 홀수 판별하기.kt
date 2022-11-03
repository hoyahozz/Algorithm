/*
    정수 값 N이 주어지면, bitwise 연산을 이용해 홀수인지 짝수인지 검사하시오.

    Given a number N, the task is to check whether the number is
    even or odd using Bitwise operator
 */

fun main() = with(System.`in`.bufferedReader()) {
    val input = readLine().toInt()

    println("Bitwise - Xor")
    if (isEvenWithXor(input)) println("Even")
    else println("Odd")

    println("Bitwise - And")
    if (isEvenWithAnd(input)) println("Even")
    else println("Odd")

}

fun isEvenWithXor(n: Int): Boolean {
    return n xor 1 == n + 1
}

fun isEvenWithAnd(n: Int): Boolean {
    return n and 1 == 0
}
