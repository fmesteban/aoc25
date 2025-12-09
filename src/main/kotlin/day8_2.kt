fun main() {
    val points = loadPoints()
    val distances = orderByDistance(points)
    var (_, xResult) = joinSets(points, distances, Int.MAX_VALUE)
    print(xResult)
}
