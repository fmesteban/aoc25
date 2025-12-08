import java.io.File
import kotlin.collections.all

fun main() {
    val intermediate = File("src/main/kotlin/resources/day6.txt").readLines()
        .map { it.toMutableList() }
        .transpose()
        .groupInLists()
    val operands = intermediate.map { it[0].last() }
    intermediate
        .map { it.map { it.dropLast(1) } }
        .map { it.map { it.joinToString("").trim() } }
        .map { it.map { it.toLong() } }
        .mapIndexed { i, numbers -> when (operands[i]) {
            '+' -> numbers.sum()
            '*' -> numbers.fold(1L) { acc, n -> acc * n }
            else -> throw IllegalArgumentException("Unknown operator ${operands[i]}")
        }}
        .sumOf { it }
    .let {
        print(it)
    }

}

fun isAllBlank(list: List<Char>): Boolean {
    if (list.isEmpty()) {
        return false
    }
    return list.all { it == ' ' }
}

fun List<List<Char>>.groupInLists(): List<List<List<Char>>> {
    var result: List<List<List<Char>>> = emptyList()
    var currentList: List<List<Char>> = emptyList()
    for (list in this) {
        if (isAllBlank(list)) {
            result = result + listOf(currentList)
            currentList = emptyList()
        } else {
            currentList = currentList + listOf(list)
        }
    }
    if (currentList.isNotEmpty()) {
        result = result + listOf(currentList)
    }
    return result
}
