import java.util.*

lateinit var array: Array<ArrayList<Link>>
lateinit var visited: BooleanArray
lateinit var savedArray: ArrayList<Node>

data class Link(
    val to: Int,
    val weight: Int
)

data class Node(
    val number: Int,
    val sum: Int
)

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()

    if(n == 1) {
        println(0)
        return@with
    }

    array = Array(n) { ArrayList<Link>() }
    visited = BooleanArray(n)
    savedArray = ArrayList()

    repeat(n - 1) {
        val (from, to, weight) = readLine().split(" ").map { it.toInt() }
        array[from - 1].add(Link(to - 1, weight))
        array[to - 1].add(Link(from - 1, weight))
    }

    DFS(0, 0)

    val max = savedArray.maxByOrNull { it.sum }!!.number

    visited.fill(false)
    savedArray.clear()

    DFS(max, 0)

    println(savedArray.maxByOrNull { it.sum }!!.sum)
}

fun DFS(start: Int, sum: Int) {
    savedArray.add(Node(start, sum))
    visited[start] = true

    for (link in array[start]) {
        if (!visited[link.to]) {
            DFS(link.to, sum + link.weight)
        }
    }
}