import java.io.BufferedReader
import java.io.File
import kotlin.math.max

fun main() {
    var ranges = mutableListOf<Pair<Long, Long>>()
    var ingredients = mutableListOf<Long>()
    File("src/main/kotlin/resources/day5.txt").bufferedReader().use { reader ->
        ranges = parseRanges(reader)

        var line = reader.readLine()
        while (line != null) {
            ingredients.add(line.toLong())
            line = reader.readLine()
        }
    }
    var cleanedRanges = cleanRanges(ranges)
    print(findIngredientsInRanges(cleanedRanges, ingredients.sorted()))
}

fun parseRanges(reader: BufferedReader): MutableList<Pair<Long, Long>> {
    var ranges = mutableListOf<Pair<Long, Long>>()
    var line = reader.readLine()
    while (line.isNotEmpty()) {
        val (begin, end) = line.split("-")
        ranges.add(Pair(begin.toLong(), end.toLong()))
        line = reader.readLine()
    }
    return ranges
}

/*
    Merges all overlapping ranges so that the result is a list of non overlapping ranges
 */
fun cleanRanges(ranges: MutableList<Pair<Long, Long>>): MutableList<Pair<Long, Long>> {
    ranges.sortBy { range -> range.first }
    var cleanedRanges = mutableListOf<Pair<Long, Long>>(ranges.first())
    for (range in ranges.drop(1)) {
        if (cleanedRanges.last().second < range.first) {
            cleanedRanges.add(range)
        } else {
            cleanedRanges[cleanedRanges.size - 1] =
                Pair(cleanedRanges.last().first, max(cleanedRanges.last().second, range.second))
        }
    }
    return cleanedRanges
}

/*
    Since all ranges are non overlapping and the ingredients are sorted, we can just iterate through the ranges and
    the ingredients at the same time. Once an ingredient is over the current range limit, we advance the range index
    to the following one, as we don't need to look on previous ones again
 */
fun findIngredientsInRanges(ranges: MutableList<Pair<Long, Long>>, ingredients: List<Long>): Long {
    var freshIngredients = 0L
    var currentRangeIdx = 0
    for (ingredient in ingredients) {
        while (currentRangeIdx < ranges.size) {
            val currentRange = ranges[currentRangeIdx]
            if (ingredient < currentRange.first) {
                break
            }
            if (ingredient <= currentRange.second) {
                freshIngredients++
                break
            }
            currentRangeIdx++
        }
    }
    return freshIngredients
}
