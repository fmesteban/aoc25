import java.io.File

fun main() {
    val grid = File("src/main/kotlin/resources/day4.txt").readLines().map { it.toMutableList() }
    var result = 0
    while (true) {
        var rollsToRemove = HashMap<Int, Int>()
        for (x in 0..grid.size-1) {
            for (y in 0..grid[0].size-1) {
                if (grid[x][y] == '@') {
                    if (countAdyacents(grid, x, y) < 4) {
                        rollsToRemove.put(x, y)
                    }
                }
            }
        }
        if (rollsToRemove.isEmpty()) {
            break
        }
        result += rollsToRemove.size
        for ((x, y) in rollsToRemove) {
            grid[x][y] = ','
        }
    }
    print(result)
}
