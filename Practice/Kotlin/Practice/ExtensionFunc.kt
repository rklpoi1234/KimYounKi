ExtensionFunc.kt

fun main() {
    val source = "HelloWorld!"
    val target = "Kotlin"
    println(source.getLongString(target))
}
//String을 확장해 getLongString추가
fun String.getLongString(target: String):String  =
    if (this.length < target.length) this else target
   
   
/* InfixFuction .kt
fun main() {
    val multi = 3 multiply 10
    println("multi: $multi")
}

infix fun Int.multiply(x:Int):Int {
    return this * x
} */

/* InlineFuction.kt

inline fun shortFunc(a:Int, crossinline out:(Int)->Unit) {
    println("Hello")
    out(a)
    println("Goodbye")
}



fun main() {
    shortFunc(3) { println("a:$it") }

}
*/
