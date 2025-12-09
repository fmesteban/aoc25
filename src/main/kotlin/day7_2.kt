import java.io.File

fun main() {
    val grid = File("src/main/kotlin/resources/day7.txt").readLines().map{ it.toMutableList() }
    countTimelines(
        grid,
        0,
        grid[0].indexOf('S'),
        mutableMapOf<Pair<Int, Int>, Int>()
    ).let { print(it) }
}

fun countTimelines(grid: List<List<Char>>, level: Int, pos: Int, storedTimelines: MutableMap<Pair<Int, Int>, Int>): Int {
    if (storedTimelines.containsKey(Pair(level, pos))) {
        return storedTimelines[Pair(level, pos)]!!
    }
    if (level == grid.size-1) {
        return 1
    }
    val count = if (grid[level+1][pos] == '^') {
        (if (pos > 0) { countTimelines(grid, level+1, pos-1, storedTimelines) } else 0) +
        (if (pos < grid[level].size-1) { countTimelines(grid, level+1, pos+1, storedTimelines) } else 0 )
    } else {
        countTimelines(grid, level+1, pos, storedTimelines)
    }
    storedTimelines[Pair(level, pos)] = count
    return count
}
