import java.io.File

fun main() {
    File("src/main/kotlin/resources/day10.txt").readLines().sumOf { line ->
        val (goal, ways) = parseLine(line)
        countStepsMostDirectWay(goal, ways)
    }.let {
        println(it)
    }
}

private fun parseLine(line: String): Pair<List<Int>, List<List<Int>>> {
    val i = line.indexOf(']')
    val ways = line
        .substring(i+2, line.indexOf('{')-1)
        .replace("(", "").replace(")", "").split(" ")
        .map { it.split(",").map { it.toInt() }.fold(MutableList(it.length) { 0 }) { acc, n -> acc[n] = 1; acc } }
    val j = line.indexOf('{')
    val goal = line.substring(j+1).dropLast(1).split(",").map { it.toInt() }

    return Pair(goal, ways)
}

fun countStepsMostDirectWay(goal: List<Int>, ways: List<List<Int>>): Int {
    return 0
}
