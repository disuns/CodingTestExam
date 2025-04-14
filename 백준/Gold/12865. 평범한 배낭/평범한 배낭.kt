fun main(){
    val br = System.`in`.bufferedReader()
    val (n, k) = br.readLine().split(" ").map { it.toInt() }

    val items = Array(n){
        val (w, v) = br.readLine().split(" ").map { it.toInt() }
        Pair(w, v)
    }

    val dp = IntArray(k + 1)
    items.forEach { (w, v) ->
        for (j in k downTo w) {
            dp[j] = maxOf(dp[j], dp[j - w] + v)
        }
    }

    println(dp[k])
}