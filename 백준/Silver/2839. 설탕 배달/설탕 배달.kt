fun main(){
    
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()

    var answer = -1

    for (i in n/5 downTo 0){
        val remainFive = n - i * 5
        if(remainFive % 3 == 0){
            answer = i + remainFive / 3
            break
        }
    }

    println(answer)
}