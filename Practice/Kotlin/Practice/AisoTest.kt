fun main() {
    data class Person(var name: String, var skills : String)
    var person = Person("Kildong", "Kotlin")

    // 여기서 this는 person 객체를 가리킴
    person.apply { this.skills = "Swift" }
    println(person)

    val retrunObj = person.apply { 
        name = "Sean" // ① this는 생략할 수 있음
        skills = "Java" // this 없이 객체의 멤버에 여러 번 접근
    }
    println(person)
    println(retrunObj)
}






/* ApplyTest.kt

fun main() {                                                     
    data class Person(var name : String, var skills : String)    
    var person = Person("kildong","Kotiln")                      
                                                                 
    person.apply { this.skills = "Swift" }                       
    println(person)                                              
                                                                 
    val returnObj = person.apply {                                
        name = "Sean" //1 this 생략할수있음                            
        skills = "Java" //this업싱 객체의 멤버에 여러번 접근                  
    }                                                            
    println(person)                                              
    println(returnObj)                                           
}                                






/*Cacl.kt

fun main() {
    val calc = Calc()
    var result = 0 //외부의 변수
    calc.addNum(2,3){x,y -> result = x+y}//클로저
    println(result)//값을 유지하여 5가 출력
}

class Calc{
    fun addNum(a:Int,b:Int,add:(Int,Int)->Unit) { //람다식add에는 반환값이없음
        add(a,b)
     }
}




/*chaing.kt

fun main() {
    var a=1
    val b=2

    a=a.let { it+2 }.let {
        println("a:$a")
        val i = it + b
        i
    }
    println(a) //5
}
*/


/*RunTest.kt


fun main() {
    data class Person(var name: String , var skills : String)
    var person = Person("Kildong","Kotiln")

    val retrunObj = person.apply {
        this.name = "Sean"
        this.skills = "Java"
        "success" //사용되지않음
    }
    println(person)
    println("returnObj: $retrunObj")

    val  returnObj2 = person.run {
        this.name = "Dooly"
        this.skills = "c#"
        "success"
    }
    println(person)
    println("returnObj2: $returnObj2")
}
*/




/*WithTset.kt



fun main() {
    data class  User(val name: String,var skills:String,var email:String?=null)
    val user = User("Kildong","default")

    val result = with (user) {
        skills = "Kotiln"
        email = "kildong@example.com"
    }
    println(user)
    println("result: $result")
}

*/



