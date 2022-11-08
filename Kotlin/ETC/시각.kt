/*
    정수 N이 입력되면 00시 00분 00초부터 N시 59분 59초까지의 모든 시각 중에서 3이 하나라도 포함되는 모든 경우의 수를 구하는 프로그램을 작성하세요.
    예를 들어 1을 입력했을 때 다음은 3이 하나라도 포함되어 있으므로 세어야 하는 시각입니다.
        - 00시 00분 03초
        - 00시 13분 30초
    반면에 다음은 3이 하나도 포함되어 있지 않으므로 세면 안 되는 시각입니다.
        - 00시 02분 55초
 */

fun main() = with(System.`in`.bufferedReader()) {
    val N = readLine().toInt()
    var count = 0

    for (i in 0..N) {
        for (j in 0 until 60) {
            for (k in 0 until 60) {
                if (i % 10 == 3 || j / 10 == 3 || j % 10 == 3 || k % 10 == 3 || k / 10 == 3) {
                    count++
                }
            }
        }
    }

    println(count)
}