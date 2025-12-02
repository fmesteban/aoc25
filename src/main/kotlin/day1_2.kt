import java.io.File
import kotlin.math.absoluteValue

fun main() {
    val result = File("src/main/kotlin/resources/day1.txt").useLines { lines ->
        lines.fold(Pair(50, 0)) { (current, secret), line ->
            val dir = when (line[0]) {
                'L' -> -1
                else -> 1
            }
            var newVal = (current + dir * line.substring(1).toInt())
            var newSecret = secret
            if (newVal.absoluteValue >= 100) {
                newSecret += (newVal / 100).absoluteValue
            }
            if (current < 0 && newVal >= 0 || current > 0 && newVal <= 0) {
                newSecret += 1
            }
            Pair(newVal % 100, newSecret)
        }
    }
    print(result.second)
}
