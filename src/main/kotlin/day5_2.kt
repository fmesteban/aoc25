import java.io.File

fun main() {
    var ranges = mutableListOf<Pair<Long, Long>>()
    File("src/main/kotlin/resources/day5.txt").bufferedReader().use { reader ->
        ranges = parseRanges(reader)
    }
    var cleanedRanges = cleanRanges(ranges)
    var totalValidIngredients = cleanedRanges.fold(0L) { total, range ->
        total + (range.second - range.first + 1)
    }
    print(totalValidIngredients)
}
