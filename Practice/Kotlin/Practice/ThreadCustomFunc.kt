import java.util.*

public fun thread(start:Boolean = true,isDaemon:Boolean=false,
                  contextClassLoader: ClassLoader?=null,name: String?=null,
                  priority:Int=-1,block:()->Unit):Thread{
    val thread = object : Thread(){
        public override fun run() {
            block()
        }
    }
    if (isDaemon) //백그라운드 실행 여부
        thread.isDaemon = true
    if (priority > 0) //우선순위 1:낮음 5보통 ~ 10높음
        thread.priority = priority
    if (name != null) //이름
        thread.name = name
    if (contextClassLoader != null)
        thread.contextClassLoader = contextClassLoader
    if (start)
        thread.start()
    return thread

}

fun main() {
    //스레드의 옵션 변수를 손쉽게 설정할수있따.
    thread(start = true) {
        println("Current Threads(costiom function):${Thread.currentThread()}")
        println("prioity: ${Thread.currentThread().priority}") //기본값은 5
        println("Name: ${Thread.currentThread().name}")
        println("Name:${Thread.currentThread().isDaemon}")
    }
}






/*ThreadTest.kt

import java.util.concurrent.ThreadLocalRandom

//class
class SimpleThread : Thread(){
    override fun run() {
        println("Class Thread ${Thread.currentThread()}")
    }
}

//interface
class SimpleRunnable : Runnable{
    override fun run() {
        println("Interface Thread ${Thread.currentThread()}")
    }

}

fun main() {
    val thread = SimpleThread()

    thread.start()

    val runnable = SimpleRunnable()
    val thread2 = Thread(runnable)
    thread2.start()

    //익명객체
    object :Thread(){
        override fun run() {
            println("object Thread: ${Thread.currentThread()}")
        }
    }.start()

    //람다식
    Thread {
        println("Lambda Thread: ${Thread.currentThread()}")
    }.start()

}

*/
