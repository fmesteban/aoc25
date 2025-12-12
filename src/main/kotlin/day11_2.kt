data class Counter(var count: Long)

fun main() {
    val paths = parseFile()

    println(dfs(paths, "svr", mutableMapOf(), false, false))
}

fun dfs(
    paths: MutableMap<String, MutableSet<String>>,
    current: String,
    pathCount: MutableMap<Triple<String, Boolean, Boolean>, Long>,
    visitedDac: Boolean,
    visitedFft: Boolean,
): Long {
    var dac = visitedDac || current == "dac"
    var fft = visitedFft || current == "fft"
    if (pathCount.containsKey(Triple(current, dac, fft))) {
        return pathCount[Triple(current, dac, fft)]!!
    }
    if (current == "out") {
        return if (dac && fft) 1 else 0
    }
    var countForCurrent = 0L
    for (next in paths[current]!!) {
        countForCurrent += dfs(paths, next, pathCount, dac, fft)
    }
    pathCount[Triple(current, dac, fft)] = countForCurrent
    return countForCurrent
}
