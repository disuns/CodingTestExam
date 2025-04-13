fun main(){
    cote()
}
fun cote(){
    val br = System.`in`.bufferedReader()
    val (m,n) = br.readLine()!!.split(" ").map { it.toInt() }

    val box = Array(n){br.readLine().split(" ").map { it.toInt() }.toMutableList() }

    val queue = ArrayDeque<Triple<Int, Int, Int>>()

    for (i in 0 until n) {
        for (j in 0 until m) {
            if (box[i][j] == 1) queue.add(Triple(i, j, 0))
        }
    }

    val directions = listOf(Pair(0, 1), Pair(0, -1), Pair(1, 0), Pair(-1, 0))

    var maxDays = 0

    while (queue.isNotEmpty()) {
        val (x, y, day) = queue.removeFirst()
        maxDays = maxOf(maxDays, day)
        for ((dx, dy) in directions) {
            val nx = x + dx
            val ny = y + dy
            if (nx in 0 until n && ny in 0 until m && box[nx][ny] == 0) {
                box[nx][ny] = 1
                queue.add(Triple(nx, ny, day + 1))
            }
        }
    }

    for (i in 0 until n) {
        for (j in 0 until m) {
            if (box[i][j] == 0) {
                println(-1)
                return
            }
        }
    }

    println(maxDays)
}