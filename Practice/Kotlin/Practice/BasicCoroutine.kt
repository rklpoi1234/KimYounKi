import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        val job = GlobalScope.launch {
            delay(1000L)
            println("World")
            doSomthing()
        }
        println("Hello")
        println("job: ${job.isActive},${job.isCompleted}")
        //Thread.sleep(2000L)
        job.join()
        println("job: ${job.isActive},${job.isCompleted}")
    }
}
suspend fun doSomthing(){
    println("Do Something")
}








/* CoroutineScope.kt

import kotlinx.coroutines.*

fun main() = runBlocking(Dispatchers.Default) {

    launch(Dispatchers.IO) {
        delay(1200L)
        println("Task from runBlocking")
    }
    coroutineScope {
        launch {
            delay(1500L)
            println("Task from nested launch")
        }
        delay(200L)
        println("Task from coroutineScope")
    }
    println("end of runBlocking")
}

*/





/* RunBlokingTest.kt

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit>{

    launch {
        delay(1000L)
        println("World!")
    }
    println("Hello")

}

*/
