fun main() = with(System.`in`.bufferedReader()) {
    val arr1 = readLine().split(" ").map { it.toInt() } as ArrayList<Int>
    val arr2 = arr1.filter { it != 0 } as ArrayList<Int>

    while (arr2.size < arr1.size) arr2.add(0)

    println(arr2)
}
