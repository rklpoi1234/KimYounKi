import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

suspend fun doWork1(): String{
    delay(1000)
    return "Work1"
}
suspend fun doWork2(): String{
    delay(3000)
    return "Work2"
}
private fun worksInSerial():Job{
    //순차적 실행
    val job = GlobalScope.launch {
        val one = doWork1()
        val two = doWork2()
        println("Kotlin One : $one")
        println("Kotlin Two : $two")
    }
    return job
}
fun main() = runBlocking {
    val time = measureTimeMillis {
        val job = worksInSerial()
        //readLine()
        job.join()
    }
    println("time: $time")
}
