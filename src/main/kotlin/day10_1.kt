import java.io.File
import kotlin.math.pow

fun main() {
    File("src/main/kotlin/resources/day10.txt").readLines().sumOf { line ->
        val (goal, steps) = parseLine(line)
        bfs(goal, steps)
    }.let {
        println(it)
    }
}

private fun parseLine(line: String): Pair<Int, List<Int>> {
    val i = line.indexOf(']')
    val goal = line.substring(1, i).toList().mapIndexed { i, c ->
        when (c) {
            '.' -> 0
            '#' -> 2.0.pow(i).toInt()
            else -> throw IllegalArgumentException("Unknown character $c")
        }
    }.sum()
    val steps = line
        .substring(i+2, line.indexOf('{')-1)
        .replace("(", "").replace(")", "").split(" ")
        .map { it.split(",").map { it.toInt() }.sumOf { 2.0.pow(it).toInt() } }

    return Pair(goal, steps)
}

fun bfs(goal: Int, steps: List<Int>): Int {
    val initial = 0
    val queue = mutableListOf(Pair(initial, 0))
    val visited = mutableSetOf(initial)
    while (queue.isNotEmpty()) {
        val (current, length) = queue.removeAt(0)
        visited.add(current)
        if (current == goal) {
            return length
        }
        for (step in steps) {
            val next = current xor step
            if (next !in visited) {
                queue.add(Pair(next, length + 1))
            }
        }
    }
    return -1
}
