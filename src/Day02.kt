fun main() {

    fun isSafe(numbers: List<Int>): Boolean {
        var isSafe = true
        val isIncreasingSequence = numbers[0] < numbers[1]
        val isDecreasingSequence = numbers[1] < numbers[0]

        if (!isIncreasingSequence && !isDecreasingSequence) {
            return false
        }

        for (i in 1..<numbers.size) {
            if (isIncreasingSequence) {
                if (numbers[i] < numbers[i - 1]) {
                    isSafe = false
                    break
                }
                val difference = numbers[i] - numbers[i - 1]
                if (difference < 1 || difference > 3) {
                    isSafe = false
                    break
                }
            } else {
                if (numbers[i - 1] < numbers[i]) {
                    isSafe = false
                    break
                }
                val difference = numbers[i - 1] - numbers[i]
                if (difference < 1 || difference > 3) {
                    isSafe = false
                    break
                }
            }
        }
        return isSafe
    }

    fun part1(input: List<String>): Int {
        var safeCount = 0
        for (line in input) {
            val numbers = line.split(" ").map { it.toInt() }
            if (isSafe(numbers)) {
                safeCount += 1
            }
        }
        return safeCount
    }

    fun part2(input: List<String>): Int {
        var safeCount = 0
        for (line in input) {
            val numbers = line.split(" ").map { it.toInt() }
            if (isSafe(numbers)) {
                safeCount += 1
            } else {
                for (index in numbers.indices) {
                    val newList = numbers.map { it }.toMutableList()
                    newList.removeAt(index)
                    if (isSafe(newList)) {
                        safeCount += 1
                        break
                    }
                }
            }
        }
        return safeCount
    }

    val input = readInput("resources/Day02")
    part1(input).println()
    part2(input).println()
}
