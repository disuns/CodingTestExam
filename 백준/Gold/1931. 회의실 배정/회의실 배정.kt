fun main(){
    cote()
}
fun cote(){
    val br = System.`in`.bufferedReader()
    val n = br.readLine()!!.toInt()
    
    val meetings = Array(n) {
        val (start, end) = br.readLine()!!.split(" ").map { it.toInt() }
        Pair(start, end)
    }
    meetings.sortWith(compareBy({ it.second }, { it.first }))

    var count = 0
    var currentEnd = 0

    for ((start, end) in meetings) {
        if (start >= currentEnd) {
            count++
            currentEnd = end
        }
    }
    println(count)
}