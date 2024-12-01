import kotlin.math.abs

fun main() {
    fun part1(input: List<String>): Int {
        val list1 = input.map { it.split("   ")[0].toInt() }.sorted()
        val list2 = input.map { it.split("   ")[1].toInt() }.sorted()

        return list1.zip(list2).sumOf { abs(it.first - it.second) }
    }

    fun part2(input: List<String>): Int {
        val list1 = input.map { it.split("   ")[0].toInt() }
        val list2 = input.map { it.split("   ")[1].toInt() }

        return list1.sumOf { num -> (num * list2.count { it == num }) }
    }

    val input = readInput("resources/Day01")
    part1(input).println()
    part2(input).println()
}
