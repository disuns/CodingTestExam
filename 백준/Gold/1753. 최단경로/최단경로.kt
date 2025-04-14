import java.util.PriorityQueue
fun main(){
    
    val br = System.`in`.bufferedReader()
    val (V, E) = br.readLine().split(" ").map { it.toInt() }
    val K = br.readLine().toInt()

    val graph = Array(V + 1) { ArrayList<Pair<Int, Int>>() }
    repeat(E) {
        val (u, v, w) = br.readLine().split(" ").map { it.toInt() }
        graph[u].add(Pair(v, w))
    }

    val INF = Int.MAX_VALUE
    val dist = IntArray(V + 1) { INF }
    dist[K] = 0

    val pq = PriorityQueue<Pair<Int, Int>>(compareBy { it.first })
    pq.add(Pair(0, K))

    while (pq.isNotEmpty()) {
        val (curDist, curVertex) = pq.poll()
        if (curDist > dist[curVertex]) continue
        for ((nextVertex, weight) in graph[curVertex]) {
            val newDist = curDist + weight
            if (newDist < dist[nextVertex]) {
                dist[nextVertex] = newDist
                pq.add(Pair(newDist, nextVertex))
            }
        }
    }

    for (i in 1..V)
        println(if (dist[i] == INF) "INF" else dist[i])
}