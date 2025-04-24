import java.util.LinkedList
import java.util.Queue
fun main(){
    val br = System.`in`.bufferedReader()
    val (n,m) = br.readLine().split(" ").map { it.toInt() }

    val dir = listOf(Pair(-1,0), Pair(1,0), Pair(0,-1), Pair(0,1))

    val research = Array(n) { br.readLine().split(" ").map { it.toInt() }.toIntArray() }

    val empties = mutableListOf<Pair<Int, Int>>()
    val viruses = mutableListOf<Pair<Int, Int>>()

    for (i in 0 until n) {
        for (j in 0 until m) {
            when (research[i][j]) {
                0 -> empties.add(Pair(i, j))
                2 -> viruses.add(Pair(i, j))
            }
        }
    }

    var maxSafe = 0
    val E = empties.size
    for (a in 0 until  E-2){
        for (b in a+1 until E-1) {
            for (c in b+1 until E) {
                val lab = Array(n) { research[it].clone() }

                listOf(empties[a], empties[b], empties[c]).forEach { (x, y) ->
                    lab[x][y] = 1
                }

                spreadVirus(lab, viruses, dir, n, m)

                val safeCount = countSafe(lab, n, m)
                if (safeCount > maxSafe) {
                    maxSafe = safeCount
                }
            }
        }
    }
    
    println(maxSafe)
}

private fun spreadVirus(
    lab: Array<IntArray>,
    viruses: List<Pair<Int, Int>>,
    dirs: List<Pair<Int, Int>>,
    n: Int,
    m: Int
) {
    val queue: Queue<Pair<Int, Int>> = LinkedList()
    viruses.forEach { queue.add(it) }

    while (queue.isNotEmpty()) {
        val (x, y) = queue.poll()
        for ((dx, dy) in dirs) {
            val nx = x + dx
            val ny = y + dy
            if (nx in 0 until n && ny in 0 until m && lab[nx][ny] == 0) {
                lab[nx][ny] = 2
                queue.add(nx to ny)
            }
        }
    }
}

private fun countSafe(lab: Array<IntArray>, n: Int, m: Int): Int {
    var count = 0
    for (i in 0 until n) {
        for (j in 0 until m) {
            if (lab[i][j] == 0) count++
        }
    }
    return count
}
