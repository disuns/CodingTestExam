fun main(){
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()

    val stack = mutableListOf<String>()

    repeat(n) { str ->
        val str = br.readLine()
        val result = stackResult(stack, str)
        if (result != -2) {
            println(result)
        }
    }
}

fun stackResult(stack: MutableList<String>, str: String): Int{
    return when(str){
        "pop", "top" -> {
            if (stack.isNotEmpty()) {
                val top = stack.last()
                if(str== "pop") stack.removeAt(stack.size - 1)
                top.toInt()
            }else{
                -1
            }
        }
        "size" -> {
            stack.size
        }
        "empty" -> {
            if (stack.isEmpty()) 1 else 0
        }
        else -> {
            if (str.contains("push")) {
                val value = str.substringAfter("push ").trim()
                stack.add(value)
            }
            -2
        }
    }
}