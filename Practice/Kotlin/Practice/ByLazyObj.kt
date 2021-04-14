class Person(val name: String, val age: Int)

fun main() {
    var isPersonInstantiated: Boolean = false  // ① 초기화 확인 용도

    val person : Person by lazy { // ② lazy를 사용한 person 객체의 지연 초기화
        isPersonInstantiated = true
        Person("Kim", 23) // ③ 이 부분이 Lazy 객체로 반환 됨
    }
    val personDelegate = lazy { Person("Hong", 40) }  // ④ 위임 변수를 사용한 초기화

    println("person Init: $isPersonInstantiated")
    println("personDelegate Init: ${personDelegate.isInitialized()}")

    println("person.name = ${person.name}")  // ⑤ 이 시점에서 초기화
    println("personDelegate.value.name = ${personDelegate.value.name}")  // ⑥ 이 시점에서 초기화

    println("person Init: $isPersonInstantiated")
    println("personDelegate Init: ${personDelegate.isInitialized()}")
}





/*  DelegatedClass.kt
interface Car{
    fun go():String
}

class  VanImpl(val power:String):Car {
    override  fun go() = "는 짐을 적재하며 $power 마력을 가집니다."
}
class  SportImpl(val power:String):Car {
    override  fun go() = "는 경주용에 사용하며 $power 마력을 가집니다."
}
class CarModel(val model:String,impl:Car):Car by impl{
    fun carInfo(){
        println("$model ${go()}") //1참조 없이 각 인터페이스 구현 클래스의 go를 접근
    }
}

fun main() {
    val myDamas = CarModel("Damas 2010",VanImpl("100마력"))
    val my350z = CarModel("350z 2008",SportImpl("350마력"))

    myDamas.carInfo()//2 carinfo에 대한 다형성을 나타냄
    my350z.carInfo()
}






