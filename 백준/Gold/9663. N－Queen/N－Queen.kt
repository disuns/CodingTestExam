fun main(){
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()

    var answer = 0
    val positions = IntArray(n) { -1 }

    fun isPossible(row: Int, col: Int): Boolean {
        for (prevRow in 0 until row) {
            val prevCol = positions[prevRow]
            if (prevCol == col || Math.abs(prevRow - row) == Math.abs(prevCol - col)) {
                return false
            }
        }
        return true
    }

    fun dfs(row: Int) {
        if (row == n) {
            answer++
            return
        }
        
        for (col in 0 until n) {
            if (isPossible(row, col)) {
                positions[row] = col
                dfs(row + 1)
                positions[row] = -1
            }
        }
    }

    dfs(0)
    println(answer)
}