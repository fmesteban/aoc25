import java.io.File
import kotlin.collections.getOrNull

fun main() {
    val grid = File("src/main/kotlin/resources/day4.txt").readLines().map { it.toMutableList() }
    var result = 0
    for (x in 0..grid.size-1) {
        for (y in 0..grid[0].size-1) {
            if (grid[x][y] == '@') {
                if (countAdyacents(grid, x, y) < 4) {
                    result++
                }
            }
        }
    }
    print(result)
}

fun countAdyacents(grid: List<List<Char>>, x: Int, y: Int): Int {
    var count = 0
    for (i in -1..1) {
        for (j in -1..1) {
            if (i == 0 && j == 0) {
                continue
            }
            if (grid.getOrNull(x+i)?.getOrNull(y+j) == '@') {
                count++
            }
        }
    }
    return count
}
