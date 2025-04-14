fun main(){
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()

    var groupWordCount = 0

    repeat(n) {
        val word = br.readLine()!!

        if (isGroupWord(word))
            groupWordCount++
    }


    println(groupWordCount)
}

fun isGroupWord(word: String): Boolean {
    val seenCharacters = mutableSetOf<Char>()
    var prevChar: Char? = null

    for (c in word) {
        if (prevChar != null && c != prevChar) {
            if (seenCharacters.contains(c)) {
                return false
            }
            seenCharacters.add(c)
        } else if (prevChar == null) {
            seenCharacters.add(c)
        }
        
        prevChar = c
    }
    return true
}