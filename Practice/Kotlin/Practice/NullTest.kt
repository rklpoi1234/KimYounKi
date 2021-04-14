package chap02.section3

fun main() {
    var str1: String?
    str1 = null
    val len = if (str1 !=null) {
        str1. length
    } else -1
    println("str1: $str1, leghth: $len")
}


/* ValRefCompare.kt
package chap02.section3

fun main() {
    val a: Int = 128
    val b = a

    val c: Int? = a
    val d: Int? = a
    val e: Int? = c

    println(c == d)
    println(c === d)
    println(c === e)
} */
