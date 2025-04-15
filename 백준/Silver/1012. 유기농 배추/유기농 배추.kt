import java.util.LinkedList
import java.util.Queue
fun main(){
    val br = System.`in`.bufferedReader()
    val t = br.readLine().toInt()
    repeat(t) {
        val (M, N, K) = br.readLine().split(" ").map { it.toInt() }

        val field = Array(N) { IntArray(M) { 0 } }

        repeat(K) {
            val (x, y) = br.readLine().split(" ").map { it.toInt() }
            field[y][x] = 1
        }
        var count = 0

        for (i in field.indices) {
            for (j in field[i].indices) {
                if (field[i][j] == 1) {
                    count++
                    bfs(field, i, j)
                }
            }
        }

        println(count)
    }
}
fun bfs(field: Array<IntArray>, startRow: Int, startCol: Int) {
    val queue: Queue<Pair<Int, Int>> = LinkedList()
    queue.offer(Pair(startRow, startCol))
    
    field[startRow][startCol] = 0

    val directions = arrayOf(
        Pair(-1, 0),
        Pair(1, 0),
        Pair(0, -1),
        Pair(0, 1)
    )

    while (queue.isNotEmpty()) {
        val (r, c) = queue.poll()
        for ((dr, dc) in directions) {
            val nr = r + dr
            val nc = c + dc
            
            if (nr in field.indices && nc in field[0].indices && field[nr][nc] == 1) {
                field[nr][nc] = 0
                queue.offer(Pair(nr, nc))
            }
        }
    }
}