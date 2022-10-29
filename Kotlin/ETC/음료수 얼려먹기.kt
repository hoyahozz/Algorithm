/*
    N × M 크기의 얼음 틀이 있다. 구멍이 뚫려 있는 부분은 0, 칸막이가 존재하는 부분은 1로 표시된다.
    구멍이 뚫려 있는 부분끼리 상, 하, 좌, 우로 붙어 있는 경우 서로 연결되어 있는 것으로 간주한다.
    이때 얼음 틀의 모양이 주어졌을 때 생성되는 총 아이스크림의 개수를 구하는 프로그램을 작성하라.
    다음의 4 × 5 얼음 틀 예시에서는 아이스크림이 총 3개가 생성된다.

    입력
    - 첫 번째 줄에 얼음 틀의 세로 길이 N과 가로 길이 M이 주어진다. (1 <= N, M <= 1,000)
    - 두 번째 줄부터 N + 1 번째 줄까지 얼음 틀의 형태가 주어진다.
    - 이때 구멍이 뚫려있는 부분은 0, 그렇지 않은 부분은 1이다.

    출력
    2 25
    1011101110111011101110111
    1110111011101110111011101
    38
 */

var n = 0
var m = 0
lateinit var arr: Array<IntArray>

fun main() = with(System.`in`.bufferedReader()) {
    val input = readLine().split(" ").map { it.toInt() }
    var answer = 0

    n = input[0]
    m = input[1]

    arr = Array(n) { IntArray(m) }

    for (i in 0 until n) {
        val text = readLine()
        for (j in 0 until m) {
            arr[i][j] = Character.getNumericValue(text[j])
        }
    }

    for(i in 0 until n) {
        for(j in 0 until m) {
            if(DFS(i,j)) answer++
        }
    }

    println(answer)
}

fun DFS(x: Int, y: Int): Boolean {

    if (x < 0 || x >= n || y < 0 || y >= m) return false

    if (arr[x][y] == 0) {
        arr[x][y] = 1
        DFS(x - 1, y)
        DFS(x, y - 1)
        DFS(x + 1, y)
        DFS(x, y + 1)
        return true
    }
    return false
}
