import java.io.File

fun main() {
    val paths = parseFile()

    var queue = mutableListOf("svr")
    var pathsToOut = 0
    while (queue.isNotEmpty()) {
        val current = queue.removeAt(0)
        if (current == "out") {
            pathsToOut++
            continue
        }
        queue.addAll(paths[current]!!)
    }

    println(pathsToOut)
}

fun parseFile(): MutableMap<String, MutableSet<String>> {
    val result = mutableMapOf<String, MutableSet<String>>()
    File("src/main/kotlin/resources/day11.txt").readLines().forEach { line ->
        val (name, rest) = line.split(": ")
        result[name] = rest.trim().split(" ").toMutableSet()
    }
    return result
}
