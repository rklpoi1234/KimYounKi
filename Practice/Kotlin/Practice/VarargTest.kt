package chap3.section1

fun avgFunc(inital:Float = 0f,vararg numbers:Float): Double{
    var result = 0f
    for (num in numbers) {
        result += num
    }
    println("result:$result,numbers.size${numbers.size}")
    val avg = (result+inital)/numbers.size +1
    return avg.toDouble()
}





fun main() {
    val result = avgFunc(5f,100f,90f,80f)
    println("avg result: $result" )
}

/*SumFunc.kt
package chap3.section1

fun sum(a:Int = 2 ,b:Int = 5) = a + b

fun max(a:Int , b:Int) =  if (a>b) a else b

fun outfunc(name:String) = println("Name: $name")

fun main() { //최상위 하뭇 Toplevel
    val result1 = sum(2,3)
    val result3 = sum(b = 2)
    val a = 3
    val b = 5

    val result2 = max(a,b)
    outfunc("Kildong")
    println(result1)
    println(result2)
    println(result3)
}
*/
