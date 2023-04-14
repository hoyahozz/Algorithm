// 5*5 -> 완탐 가능
// P로부터 BFS를 돌려 다른 P를 만나는 순간
// 1. 닿는 데까지 맨해튼 거리가 2이상일 경우 무관
// 2. 닿는 데까지 맨해튼 거리가 2 미만일 경우 거리두기 지키지 않은 것

import java.util.*

val dx = intArrayOf(1, -1, 0, 0)
val dy = intArrayOf(0, 0, -1, 1)

class Solution {
    fun solution(places: Array<Array<String>>): IntArray {
        var answer: IntArray = intArrayOf()

        places.forEach { place ->
            val graph = makeGraph(place)
            var flag = true

            loop1@for(i in place.indices) {
                val room = place[i]
                for(j in room.indices) {
                    if(room[j] == 'P') {
                        if(BFS(graph, i to j) == false) {
                            flag = false
                            break@loop1
                        }
                    }
                }
            }

            if(flag) answer += 1
            else answer += 0
        }

        return answer
    }
}

fun BFS(graph: Array<Array<Char>>, start: Pair<Int, Int>): Boolean {
    val visited = Array(5) { BooleanArray(5) }

    val queue = LinkedList<Pair<Int, Int>>()
    queue.add(start)
    visited[start.first][start.second] = true
    var size = 0

    while(queue.isNotEmpty()) {
        repeat(queue.size) {
            val curr = queue.poll()

            if(graph[curr.first][curr.second] == 'P' && size <= 2 && curr != start) {
                return false
            }

            for(i in 0 until 4) {
                val x = curr.first + dx[i]
                val y = curr.second + dy[i]

                if(x !in graph.indices || y !in graph[0].indices) continue
                if(graph[x][y] == 'X') continue
                if(visited[x][y]) continue

                queue.add(x to y)
                visited[x][y] = true
            }
        }
        size++
    }

    return true
}

fun makeGraph(room: Array<String>): Array<Array<Char>> {
    val result = Array(5) { Array<Char>(5) { 'a' }}

    room.forEachIndexed { i, array ->
        array.forEachIndexed { j, char ->
            result[i][j] = char
        }
    }

    return result
}