class Solution {
    fun totalMoney(n: Int): Int {
        var result = 0
        val week = n / 7
        val remain = n % 7

        for (i in 0 until week) {
            val startValue = i + 1

            for (j in startValue until startValue + 7) {
                result += j
            }
        }

        if (remain != 0) {
            val startValue = week + 1
            
            for (i in 0 until remain) {
                result += (startValue + i)
            }
        }

        return result
    }
}
