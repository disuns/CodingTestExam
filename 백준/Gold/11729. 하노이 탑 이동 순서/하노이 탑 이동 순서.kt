fun main(){
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()

    val move = mutableListOf<String>()
    hanoi(n, 1, 3, 2, move)
    println(move.count())
    println(move.joinToString ( "\n" ))
}

fun hanoi(items : Int, from : Int, to : Int, second : Int, move : MutableList<String>) {
    if (items == 1) {
        move.add("$from $to")
        return
    }
    hanoi(items - 1, from, second, to, move)
    move.add("$from $to")
    hanoi(items - 1, second, to, from, move)
}