import java.io.File

fun main() {
    val result = File("src/main/kotlin/resources/day1.txt").useLines { lines ->
        lines.fold(Pair(50, 0)) { (currentVal, secretVal), line ->
            val dir = when (line[0]) {
                'L' -> -1
                else -> 1
            }
            var newVal = (currentVal + dir * line.substring(1).toInt()) % 100
            Pair(newVal, secretVal + when {
                newVal == 0 -> 1
                else -> 0
            })
        }
    }
    print(result.second)
}
