// 1. 5 x 5 배열 초기화
// 2. 배열 내부에는 숫자와, 호명 여부에 관한 정보를 가지고 있는 객체를 삽입
// 3. 숫자 한 번을 부를 때마다 배열 내부를 순회

fun main() = with(System.`in`.bufferedReader()) {
    val bingo = Array(5) { Array(5) { Number(0, false)} }
    var answer = 0

    // 빙고판 초기화
    for(i in 0 until 5) {
        val input = readLine().split(" ").map { it.toInt() }
        for(j in 0 until 5) {
            bingo[i][j] = Number(input[j], false)
        }
    }

    // 사회자 호명
    loop@for(i in 0 until 5) {
        val input = readLine().split(" ").map { it.toInt() }
        for(j in 0 until 5) {
            answer++
            // 해당 빙고의 호명 여부를 true 로 변경
            called(bingo, input[j])
            val num = search(bingo)

            if(num >= 3) {
                break@loop
            }
        }
    }

    println(answer)
}

fun called(bingo: Array<Array<Number>>, target: Int) {
    loop@for ((i, row) in bingo.withIndex()){
        for ((j,column) in row.withIndex()){
            if(bingo[i][j].num == target) {
                bingo[i][j].isCalled = true
                break@loop
            }
        }
    }
}

fun search(bingo: Array<Array<Number>>): Int {
    var bingoNumber = 0

    for(i in 0 until 5) {
        var count = 0
        for(j in 0 until 5) {
            if(bingo[i][j].isCalled) count++
        }
        if(count == 5) {
            bingoNumber++
        }
    }

    for(i in 0 until 5) {
        var count = 0
        for(j in 0 until 5) {
            if(bingo[j][i].isCalled) count++
        }
        if(count == 5) {
            bingoNumber++
        }
    }

    var diagonalCount = 0
    for((column, i) in (4 downTo(0)).withIndex()) {
        if(bingo[column][i].isCalled) diagonalCount++

        if(diagonalCount == 5) {
            bingoNumber++
        }
    }

    diagonalCount = 0
    for(i in 0 until 5) {
        if(bingo[i][i].isCalled) diagonalCount++

        if(diagonalCount == 5) {
            bingoNumber++
        }
    }

    return bingoNumber
}

data class Number(
    val num: Int,
    var isCalled: Boolean
)