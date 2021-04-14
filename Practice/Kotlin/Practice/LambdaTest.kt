package chap04.section1

fun main() {
    val result: Int

    //val mutlti = {a:Int,b:Int -> a * b }
    val mutlti : (a:Int,b:Int)-> Int = {a,b ->
        println("A:$a,B:$b")
        a * b
    }

    val nestedLambda: () -> () -> Unit = {{ println("nestedLambda")}}

    result = mutlti(10,20)
    println(result)
}

/*callByValue.kt
package chap04.section2

fun main() {
    val result = callByValue(lambda()) // 람다식 함수를 호출
    println(result)
}

fun callByValue(b: Boolean): Boolean { // 일반 변수 자료형으로 선언된 매개변수
    println("callByValue function")
    return b
}

val lambda: () -> Boolean = {  // 람다 표현식이 두 줄이다
    println("lambda function")
    true 		    // 마지막 표현식 문장의 결과가 반환
}*/

/* FuncArgument.kt
package chap04.section2

fun sum( a:Int , b:Int) = a + b

fun mul(a: Int,b: Int):Int{
    return a*b
}
fun funcFunc(a: Int,b: Int) = sum(a,b)

fun main() {

    val result = sum(10,20)
    val result2 = mul(sum(10,15),10)
    val result3 = funcFunc(2,3)

    println("result: $result, result2: $result2,result3: $result3")

} */
