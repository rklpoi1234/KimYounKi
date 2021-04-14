fun main() {
    val intsHashSet:HashSet<Int> = hashSetOf(6,3,4,7) //불변성 기능이 없음
    intsHashSet.add(5) //add
    intsHashSet.remove(6)//remove
    println(intsHashSet)
}


/*ImmutableSet.kt

fun main() {
    val mixedTypesSet = setOf("Hello",5,"world",3.14,'c') //자료형 혼합 초기화
    var intSet:Set<Int> = setOf<Int>(1,5,5) //정수형만 초기화

    println(mixedTypesSet)
    println(intSet)
}
*/




/*MutableMap.kt

fun main() {
    //가변형 맵위 선언 및 초기화
    val capitalCityMap: MutableMap<String,String> //선언시키와 값의 자료형을 명시할수있음
            = mutableMapOf("korea" to "seoul","china" to "beijing","japan" to "tokyo")
    println(capitalCityMap.values) //값만출력
    println(capitalCityMap.keys) //키만 출력
    capitalCityMap.put("UK","London")//요소의추가
    capitalCityMap.remove("china")//요소의 삭제
    println(capitalCityMap)
}
*/





/*OtherMaps.kt

fun main() {
    val hashMap = hashMapOf(1 to "Hello",2 to "World")
    val sortedMap = sortedMapOf(1 to "Apple",2 to "Banana")
    val linkedHash = linkedMapOf(1 to "Computer",2 to "Mouse")

    println("hash = $hashMap")
    println("sorted = $sortedMap")
    println("linked = $linkedHash")
}

*/


/*TreeSet.kt

fun main() {
    val intsSortedSet = sortedSetOf(4,1,7,2)
    intsSortedSet.add(6)
    intsSortedSet.remove(1)
    println("intsSortedSet = ${intsSortedSet}")
    intsSortedSet.clear()
    println("intsSortedSet = ${intsSortedSet}")
}
*/




