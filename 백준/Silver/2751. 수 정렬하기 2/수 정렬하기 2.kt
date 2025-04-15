fun main(){
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()

    val ints = Array(n) { br.readLine().toInt() }

    ints.sort()

    println(ints.joinToString("\n"))
}