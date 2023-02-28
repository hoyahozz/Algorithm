import java.util.*
import kotlin.properties.Delegates

lateinit var array: Array<IntArray>
lateinit var visited: Array<BooleanArray>
lateinit var start: Pair<Int, Int>
var n by Delegates.notNull<Int>()

val dx = intArrayOf(-1, 1, 0, 0)
val dy = intArrayOf(0, 0, -1, 1)

fun main() = with(System.`in`.bufferedReader()) {
    n = readLine().toInt()

    array = Array(n) { IntArray(n) }
    visited = Array(n) { BooleanArray(n) }
    var flag = false

    repeat(n) {
        array[it] = readLine().split(" ").map { it.toInt() }.toIntArray()
    }

    repeat(n) { x ->
        repeat(n) { y ->
            if (array[x][y] in 1..8) flag = true // 갈 곳이 있는지 체크
            if (array[x][y] == 9) start = x to y // 상어 위치 체크
        }
    }

    if (!flag) {
        println(0) // 갈 곳이 없다면 곧바로 리턴한다.
        return@with
    }

    println(BFS())
}

fun BFS(): Int {

    var time = 0
    var findTime = 1 // 포인트를 찾는 데 소요된 시간

    var size = 2 // 상어 사이즈
    var exp = 0 // 상어 경험치

    val queue = LinkedList<Pair<Int, Int>>()
    queue.add(start)
    visited[start.first][start.second] = true

    while (queue.isNotEmpty()) {
        val nextSteps = ArrayList<Pair<Int, Int>>()

        repeat(queue.size) {
            val curr = queue.poll()
            for (i in 0 until 4) {
                val x = curr.first + dx[i]
                val y = curr.second + dy[i]

                if (x !in array.indices || y !in array.indices) continue
                if (visited[x][y]) continue
                if (size < array[x][y]) continue // 아기 상어는 자신의 크기보다 큰 물고기가 있는 칸은 지나갈 수 없다.

                if (size > array[x][y] && array[x][y] in 1..8) { // 자신의 크기보다 작은 물고기는 잡아먹을 후보지로 등록한다.
                    nextSteps.add(x to y)
                    visited[x][y] = true // 똑같은 후보지는 등록하지 않도록 설정한다.
                    continue
                }

                // 빈 칸일 경우 방문한다.
                queue.add(x to y)
                visited[x][y] = true
            }
        }

        // 후보지가 있다는 것은 어쨌든 갈 곳이 있다는 뜻이다.
        if (nextSteps.isNotEmpty()) {

            // 후보지 중, 가장 위에 있는 물고기를 이동지로 선정하고, 만약 그런 물고기가 여러마리라면 가장 왼쪽 물고기를 이동지로 선정한다.
            val next = nextSteps.sortedWith(compareBy<Pair<Int, Int>> { it.first }.thenBy { it.second }).first()

            // 다시 모든 빈칸을 돌아야하므로 큐를 클리어, 이동지를 큐에 넣는다.
            queue.clear()
            queue.add(next)

            // 방문 여부 역시 함께 초기화한다.
            visited = Array(n) { BooleanArray(n) }
            visited[next.first][next.second] = true

            // 경험치를 증가시키고, 만약 경험치가 아기 상어의 크기만큼 쌓였다면 아기 상어의 크기를 증가시킨다.
            exp += 1

            if (exp == size) {
                size++
                exp = 0
            }

            // 아기 상어가 출발한 칸을 0으로, 최종 이동지를 9로 함으로서 아기 상어가 이동했다는 것을 명시한다.
            array[start.first][start.second] = 0
            array[next.first][next.second] = 9
            start = next

            // 적합한 물고기를 찾으러 돌아다녔던 시간을 최종 시간에 넣는다.
            // 만약 적합한 물고기가 없다면, 시간이 늘어나지 않는다.
            time += findTime
            findTime = 0
        }

        findTime++
    }

    return time
}