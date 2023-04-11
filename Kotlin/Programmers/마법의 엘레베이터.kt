class Solution {
    fun solution(storey: Int): Int {
        var mValue = storey
        var answer = 0

        while (mValue > 0) {
            var lastNumber = mValue % 10

            if (lastNumber < 5) {
                mValue -= lastNumber
            } else if (lastNumber == 5) {
                val plusMyValue = (mValue + lastNumber) / 10 % 10
                val minusMyValue = (mValue - lastNumber) / 10 % 10

                val plus = minOf(10 - plusMyValue, plusMyValue)
                val minus = minOf(10 - minusMyValue, minusMyValue)

                if (minus < plus) mValue -= 5
                else mValue += 5
            } else {
                lastNumber = 10 - lastNumber
                mValue += lastNumber
            }

            answer += lastNumber
            mValue /= 10
        }

        return answer
    }
}
