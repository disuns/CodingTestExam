class Solution {
    fun solution(str1: String, str2: String): String {
        var answer: String = ""
        
        
        str1.forEachIndexed { index, c -> 
            answer+=c
            answer+= str2[index]
        }
        
        return answer
    }
}