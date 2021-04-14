package chap02.section3

fun main() {
    val num = 256

    if (num is Int) { //num이 Int형 일때
        print(num)
    } else if (num !is Int) { //num이 Int형이 아닐때,
        print("Not a Int")
    }
}

/* Any change.kt
package chap02.section3

fun main() {
    val num = 256

    if (num is Int) { //num이 Int형 일때
        print(num)
    } else if (num !is Int) { //num이 Int형이 아닐때,
        print("Not a Int")
    }
} */
