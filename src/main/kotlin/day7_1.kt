import java.io.File

fun main() {
    val grid = File("src/main/kotlin/resources/day7.txt").readLines().map{ it.toMutableList() }
    grid.dropLast(1).mapIndexed { i, line ->
        line.mapIndexed { j, c ->
            if (c == 'S') {
                if (grid[i+1][j] == '^') {
                    if (j > 0) { grid[i+1][j-1] = 'S' }
                    if (j < line.size-1) { grid[i+1][j+1] = 'S' }
                    1
                } else {
                    grid[i+1][j] = 'S'
                    0
                }
            } else {
                0
            }
        }
    }.flatten().sum().let {
        print(it)
    }
}
