import java.io.File
import kotlin.math.sqrt

class Point(val x: Double, val y: Double, val z: Double) {
    override fun toString(): String {
        return "Point(${x}, ${y}, ${z})"
    }
}

class Distance(val content: Double, val p1: Point, val p2: Point) {
    override fun toString(): String {
        return "Distance(${String.format("%.3f", content)}, ${p1}, ${p2})"
    }
}

const val ITERATIONS = 1000
const val THRESHOLD = 3

fun main() {
    val points = File("src/main/kotlin/resources/day8.txt")
        .readLines()
        .map{ it.split(",").map { it.toDouble() }.let { Point(it[0], it[1], it[2]) } }
    val distances = mutableListOf<Distance>()
    for (i in 0..points.size-2) {
        for (j in i+1..points.size-1) {
            distances.add(Distance(distance(points[i], points[j]), points[i], points[j]))
        }
    }
    distances.sortBy { it.content }
    var sets = points.map { mutableSetOf(it) }.toMutableList()
    for (i in 0..ITERATIONS-1) {
        val point1 = distances[i].p1
        val point2 = distances[i].p2

        val set1Index = sets.indexOfFirst { it.contains(point1) }
        val set2Index = sets.indexOfFirst { it.contains(point2) }

        if (set1Index != set2Index) {
            sets[set1Index].addAll(sets[set2Index])
            sets.removeAt(set2Index)
        }
    }
    sets.sortedByDescending { it.size }.take(THRESHOLD).fold(1L) { acc, n -> acc * n.size }.let {
        print(it)
    }
}

fun distance(point1: Point, point2: Point): Double {
    val dx = point2.x - point1.x
    val dy = point2.y - point1.y
    val dz = point2.z - point1.z
    return sqrt(dx * dx + dy * dy + dz * dz)
}
