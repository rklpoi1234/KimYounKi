
/* WhenNoArgs.kt
fun main() {

    print("Enter the score:")
    var score = readLine()!!.toDouble()
    var grade: Char = 'F'

    //인수 없는 when 의 사용
    when{
        score >= 90.0 -> grade = 'A' //인자 있는 when과 다르게 조건식을 구성할수있음
        score in 80.0..89.0 -> grade = 'B'
        score in 70.0..79.9 -> grade = 'C'
        score < 70.0 -> grade = 'F'
    }
    println("Score: $score, Grade: $grade")
} */





/* WhenTest.kt
fun main() {
    print("Enter the socre: ")
    val score = readLine()!!.toDouble()

    var grade: Char = 'F'

    when (score){
        in 90.0..100.0 -> grade = 'A'
        in 80.0..90.0 -> grade = 'B'
        in 70.0..80.0 -> grade = 'C'
        else -> grade = 'F'
    }


    println("score: $score, grade: $grade")
}
*/
