fun <T> find(a:Array<T>,Target:T):Int {
    for (i in a.indices) {
        if (a[i] == Target) return i

    }
    return -1
}
fun main() {
    val arr1: Array<String> = arrayOf("Apple","Banana","Cherry","Durian")
    val arr2: Array<Int> = arrayOf(1,2,3,4)

    println("arr.indices ${arr1.indices}") //indices는 배열의 유효 점위 반환
    println(find<String>(arr1,"Cherry")) //요소c의 인덱스 찾아내기
    println(find(arr2,2))//요소 2의 인덱스 찾아내기
}




/*generic.kt

class Box<T>(t:T){
    var name = t
}

fun main() {
    val box1:Box<Int> = Box<Int>(1)
    val box2:Box<String> = Box<String>("Hello")

    println(box1.name)
    println(box2.name)
}
*/




/*Number Limit.kt

class Calc<T:Number>{ //클래스의 형식 매개변수 제한
    fun plus(args:T,args2: T):Double {
        return args.toDouble() + args2.toDouble()
    }
}

fun main(args: Array<String>) {
    val calc = Calc<Int>()
    println(calc.plus(10,20))

    val calc2 = Calc<Double>()
    val calc3 = Calc<Long>()
    //val calc4 = Calc<String>() //제한된 자료형으로 인해 오류 발생!

    println(calc2.plus(2.5,3.5))
    println(calc3.plus(5L,10L))
}

*/


/*ReifedGeneric.kt

fun main() {
    val result = getType<Float>(10)
    println("result = $result")
}

inline fun <reified T> getType(value:Int):T{
    println(T::class) //실행 시간에 삭제되지 않고 사용가능
    println(T::class.java)

    return when (T::class){//받아들인 제네릭 자료형에 따라 반환
        Float::class -> value.toFloat()as T
        Int :: class -> value as T
        else -> throw  IllegalStateException("${T::class} is not supported!")

    }
}

/*

