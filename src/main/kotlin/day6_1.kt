import java.io.File

fun main() {
    File("src/main/kotlin/resources/day6.txt").readLines().map { it.split(" ").filter { it.isNotEmpty() } }.transpose().sumOf { ops ->
        var operator = ops.last()
        var numbers = ops.dropLast(1).map { it.toString().toLong() }
        when (operator) {
            "+" -> numbers.sum()
            "*" -> numbers.fold(1L) { acc, n -> acc * n }
            else -> throw IllegalArgumentException("Unknown operator $operator")
        }
    }.let {
        print(it)
    }

}


fun <T> List<List<T>>.transpose(): List<List<T>> {
    return (0..this[0].size - 1).map { i: Int ->
        var newLine = mutableListOf<T>()
        for (j in 0..this.size -1 ) {
            newLine.add(this[j][i])
        }
        newLine
    }
}
