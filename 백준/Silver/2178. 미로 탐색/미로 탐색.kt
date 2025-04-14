import java.util.LinkedList
import java.util.Queue

fun main(){
    val br = System.`in`.bufferedReader()
    val (n, m) = br.readLine().split(" ").map { it.toInt() }

    val maze = Array(n) { br.readLine().toCharArray().map { it - '0' }.toIntArray() }

    val dx = intArrayOf(-1, 1, 0, 0)
    val dy = intArrayOf(0, 0, -1, 1)

    val queue: Queue<Pair<Int, Int>> = LinkedList()
    queue.add(Pair(0, 0))

    while (queue.isNotEmpty()) {
        val (x, y) = queue.poll()

        for (i in 0 until 4) {
            val nx = x + dx[i]
            val ny = y + dy[i]

            if (nx in 0 until n && ny in 0 until m && maze[nx][ny] == 1) {
                maze[nx][ny] = maze[x][y] + 1
                queue.add(Pair(nx, ny))
            }
        }
    }
    println(maze[n - 1][m - 1])
}