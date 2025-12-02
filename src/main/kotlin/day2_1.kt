import java.io.File

fun main() {
    File("src/main/kotlin/resources/day2.txt").useLines { lines ->
        lines.forEach { line ->
            val result = line.split(",").fold(0L) { sum, range ->
                val (first, last) = range.split("-")
                sum + (first.toLong()..last.toLong()).fold(0L) { partialSum, n ->
                    n.toString().let { repr ->
                        partialSum + if (repr.substring(0, repr.length / 2) == repr.substring(repr.length / 2)) n else 0
                    }
                }
            }
            print(result)
        }
    }
}
