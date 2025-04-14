import java.util.LinkedList
import java.util.Queue
fun main(){
    val br = System.`in`.bufferedReader()
    val (n, m, v) = br.readLine().split(" ").map { it.toInt() }
    val graph = Array(n + 1) { mutableListOf<Int>() }

    repeat(m) {
        val (a, b) = br.readLine().split(" ").map { it.toInt() }
        graph[a].add(b)
        graph[b].add(a)
    }

    for (i in 1..n) {
        graph[i].sort()
    }

    val visitedDFS = BooleanArray(n + 1)
    val resultDFS = mutableListOf<Int>()
    dfs(v, graph, visitedDFS, resultDFS)

    val visitedBFS = BooleanArray(n + 1)
    val resultBFS = bfs(v, graph, visitedBFS)

    println(resultDFS.joinToString(" "))
    println(resultBFS.joinToString(" "))
}
fun dfs(
    v: Int,
    graph: Array<MutableList<Int>>,
    visited: BooleanArray,
    result: MutableList<Int>
) {
    visited[v] = true
    result.add(v)
    for (next in graph[v]) {
        if (!visited[next]) {
            dfs(next, graph, visited, result)
        }
    }
}

fun bfs(
    start: Int,
    graph: Array<MutableList<Int>>,
    visited: BooleanArray
): List<Int> {
    val result = mutableListOf<Int>()
    val queue: Queue<Int> = LinkedList()

    queue.add(start)
    visited[start] = true

    while (queue.isNotEmpty()) {
        val cur = queue.poll()
        result.add(cur)
        for (next in graph[cur]) {
            if (!visited[next]) {
                visited[next] = true
                queue.add(next)
            }
        }
    }
    return result
}