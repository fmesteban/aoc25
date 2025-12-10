import java.io.File
import kotlin.math.absoluteValue

fun main() {
    val points = File("src/main/kotlin/resources/day9.txt").readLines().map { line ->
        val (y, x) = line.split(","); Pair(x.toLong(), y.toLong())
    }

    var biggestRectangleArea = 0L

    for (i in 0..points.size-1) {
        for (j in i+1..points.size-1) {
            calculateArea(points[i].first, points[i].second, points[j].first, points[j].second).let {
                if (it > biggestRectangleArea) {
                    println("newArea = $it, biggestRectangleArea = $biggestRectangleArea, p1 = ${points[i]}, p2 = ${points[j]}")
                    biggestRectangleArea = it
                }
            }
        }
    }

    print(biggestRectangleArea)
}

fun calculateArea(x1: Long, y1: Long, x2: Long, y2: Long): Long {
    return ((x2 - x1).absoluteValue + 1) * ((y2 - y1).absoluteValue + 1)
}
