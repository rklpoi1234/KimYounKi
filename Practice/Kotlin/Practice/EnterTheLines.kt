fun main() {

    print("Enter the line")

    var n = readLine()!!.toInt()

    for (line in 1..n){
        for (space in 1..(n-line)) println("")
        for (star in 1 until 2*line) println("*")
        println()
    }


}





/*
fun main() {

    //5 -> 12345, 23451, 34512..
    do {
        println("Enter the number:")
        val input = readLine()!!.toInt()

        for (i in 0 until input){
            for(j in 0 until input){
                print((i+j)%input + 1)
            }
            println()
        }
    }while (input != 0)
}
*/




/*
fun main() {

    print("Enter the number: ")
    var number = readLine()!!.toInt()
    var factorial: Long = 1

    while (number > 0) { // n x ... x4 x3 x2 x1
        factorial *= number
        --number
    }
    println("Factorial: $factorial")
}
*/




