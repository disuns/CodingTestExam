fun main(){
    val br = System.`in`.bufferedReader()
    val t = br.readLine().toInt()

    repeat(t){
        val xyr = br.readLine().split(" ")
        val jo = Triple(
            xyr[0].toInt(),
            xyr[1].toInt(),
            xyr[2].toInt()
        )
        val park = Triple(
            xyr[3].toInt(),
            xyr[4].toInt(),
            xyr[5].toInt()
        )

        val d = Math.sqrt(
            Math.pow((jo.first - park.first).toDouble(), 2.0) +
            Math.pow((jo.second - park.second).toDouble(), 2.0)
        )

        val result = when {
            d == 0.0 && jo.third == park.third -> -1
            d > jo.third + park.third -> 0
            d < kotlin.math.abs(jo.third - park.third) -> 0
            d == (jo.third + park.third).toDouble() -> 1
            d == kotlin.math.abs(jo.third - park.third).toDouble() -> 1
            else -> 2
        }
        
        println(result)
    }
}