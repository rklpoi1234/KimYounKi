




fun main() {
    val num = 3
    //val str = num.strplus("Kotlin")
    val str = num strplus "Kotlin" //중위 함수
    println(str)
}

infix  fun Int.strplus(x:String):String{
    return "$x version $this"
}







/* NormalFactorial.kt
fun main() {
    val number = 4
    val result: Long

    result = factorial(number)
    println("Factorial: $number -> $result")
}


fun factorial(n:Int):Long {
    return if(n==1) n.toLong() else n * factorial(n-1)
}
*/







/* TailRexFactorial.kt

fun main() {
    val number = 5
    println("Factorial: $number > ${factorial(number)}")
}

tailrec fun factorial(n:Int,run:Int = 1):Long{
    return if (n==1) run.toLong() else factorial(n-1,run*n)
}
*/






/*ScopeTest.kt

var global = 10

fun main() {

    fun localFunc1(){
        println("loclaFunc1")
    }

    localFunc1()

    global = 15
    val local1 = 15
    println("global $global")
    userFunc()
    println("final - global: $global, local1: $local1")
}

fun userFunc() {
    global = 20
    val local1 = 20
    println("userFunc - global: $global, local1: $local1")
}
